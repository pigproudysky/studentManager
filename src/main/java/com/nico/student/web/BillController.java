package com.nico.student.web;

import com.nico.student.bean.Bill;
import com.nico.student.bean.File;
import com.nico.student.bean.Student;
import com.nico.student.service.BillService;
import com.nico.student.service.FileService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bill")
public class BillController {

    @Autowired
    private BillService service;
    @Autowired
    private FileService fileService;

    @RequestMapping("/list")
    public Map<String,Object> getAll(Integer page, Integer limit){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("page", (page - 1 ) * limit);
        map.put("limit", limit);
        Student stu = (Student) SecurityUtils.getSubject().getSession().getAttribute("stu");
        map.put("sid", stu.getId());
        List<Bill> bills = service.getAll(map);
        List<File> files = fileService.getAll(new HashMap<>());
        for(Bill b:bills){
            for (File f:files){
                if(b.getFid() == f.getId()){
                    b.setFileName(f.getPrefix());
                }
            }
        }
        int count = service.getCount(map);
        Map<String ,Object> resultMap = new HashMap<String, Object>();
        resultMap.put("code", 0);
        resultMap.put("msg", "");
        resultMap.put("data", bills);
        resultMap.put("count", count);
        return resultMap;
    }




}
