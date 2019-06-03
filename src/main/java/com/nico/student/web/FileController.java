package com.nico.student.web;

import com.nico.student.bean.*;
import com.nico.student.bean.File;
import com.nico.student.service.AccountService;
import com.nico.student.service.BillService;
import com.nico.student.service.FileService;
import com.nico.student.service.TypeService;
import com.nico.student.utils.PathUtils;
import com.nico.student.utils.ToImageUtil;
import org.apache.commons.io.FileUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService service;
    @Autowired
    private BillService billService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private AccountService accService;

    @RequestMapping("/list")
    public Map<String,Object> getAll(Integer page, Integer limit){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("page", (page - 1 ) * limit);
        map.put("limit", limit);
        Student stu = (Student) SecurityUtils.getSubject().getSession().getAttribute("stu");
        map.put("sid", stu.getId());
        List<File> files = service.getAll(new HashMap<>());
        Map<String, Object> pares = new HashMap<>();
        pares.put("sid",stu.getId());
        List<Bill> bills = billService.getAll(pares);
        List<Type> types = typeService.getAll();
        for(File f:files){
            for(Bill b:bills){
                if(f.getId() == b.getFid()){
                    f.setBillFlag(1);
                }
                for (Type t:types){
                    if(f.getType_id() == t.getId()){
                        f.setName(t.getName());
                    }
                }
            }
        }
        int count = service.getCount();
        Map<String ,Object> resultMap = new HashMap<String, Object>();
        resultMap.put("code", 0);
        resultMap.put("msg", "");
        resultMap.put("data", files);
        resultMap.put("count", count);
        return resultMap;
    }

    @RequestMapping("/all")
    public List<File> getAlls(Integer tid,String prefix) throws Exception{
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("tid",tid);
        map.put("prefix",prefix);
        List<File> files = service.getAll(map);
        List<Type> types = typeService.getAll();
        for(File f:files){
            for (Type t:types){
                if(f.getType_id() == t.getId()){
                    f.setName(t.getName());
                }
            }
        }
        return files;
    }

    //7.这里用到了，改，改了类型以后，有bug，很简单，你自己改，下面还有用到的地方，你自己照着改，我就不改了
    @RequestMapping("/getOne")
    public File getOneBySid(String fid) throws  Exception{
        File f = service.getOneById(fid);
        Map<String, Object> pares = new HashMap<>();
        Student stu = (Student) SecurityUtils.getSubject().getSession().getAttribute("stu");
        pares.put("sid",stu.getId());
        List<Bill> bills = billService.getAll(pares);
        List<Type> types = typeService.getAll();
        for(Bill b:bills){
            if(f.getId() == b.getFid()){
                f.setBillFlag(1);
            }
        }
        for (Type t:types){
            if(f.getType_id() == t.getId()){
                f.setName(t.getName());
            }
        }
        java.io.File file = new java.io.File(PathUtils.PPT_PATH+f.getData());
        f.setImageNum(ToImageUtil.converPPTtoImage(f));
        f.setImagePath(PathUtils.IMAGE_PATH + f.getPrefix() + "/");
        return f;
    }

    @RequestMapping("/download")
    private void down(HttpServletRequest request, HttpServletResponse response,Integer id) throws IOException {
        File fileInfo = service.getOneById(id);
        if(null != fileInfo){
            Student stu = (Student) SecurityUtils.getSubject().getSession().getAttribute("stu");
            Account account = accService.getOne(stu.getId());
            Account acc = new Account();
            acc.setSid(stu.getId());
            acc.setIntegral(account.getIntegral() - fileInfo.getPrice().intValue());
            int download = accService.download(acc);
            System.out.println(download);
        }
        String fileName = PathUtils.PPT_PATH+fileInfo.getData();
        InputStream bis = new BufferedInputStream(new FileInputStream(fileName));
        response.addHeader("Content-Disposition","attachment;filename="+fileName);
        response.setContentType("multipart/form-data");
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
        int len = 0;
        while((len = bis.read()) != -1){
            out.write(len);
            out.flush();
        }
        out.close();
    }

    @RequestMapping("/heat")
    public List<File> getHeat(){
        List<File> heat = service.getHeat();
        return heat;
    }




}
