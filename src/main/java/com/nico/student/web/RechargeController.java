package com.nico.student.web;

import com.nico.student.bean.Account;
import com.nico.student.bean.Recharge;
import com.nico.student.bean.Student;
import com.nico.student.service.AccountService;
import com.nico.student.service.RechargeService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/recharge")
public class RechargeController {

    @Autowired
    private RechargeService service;
    @Autowired
    private AccountService accService;

    @RequestMapping("/list")
    public Map<String,Object> getAll(Integer page, Integer limit){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("page", (page - 1 ) * limit);
        map.put("limit", limit);
        Student stu = (Student) SecurityUtils.getSubject().getSession().getAttribute("stu");
        map.put("sid", stu.getId());
        List<Recharge> bills = service.getAll(map);
        int count = service.getCount(map);
        Map<String ,Object> resultMap = new HashMap<String, Object>();
        resultMap.put("code", 0);
        resultMap.put("msg", "");
        resultMap.put("data", bills);
        resultMap.put("count", count);
        return resultMap;
    }

    @RequestMapping("/add")
    public boolean add(Recharge recharge){
        Student stu = (Student) SecurityUtils.getSubject().getSession().getAttribute("stu");
        recharge.setSid(stu.getId());
        Account old = accService.getOne(stu.getId());
        Account news = new Account();
        news.setSid(stu.getId());
        if(null == old){
            news.setAmount(recharge.getPrice());
            news.setIntegral(Integer.parseInt(String.valueOf(recharge.getPrice()))* 10 );
            accService.addAccount(news);
        }else {
            news.setAmount(old.getAmount().add(recharge.getPrice()));
            news.setIntegral(old.getIntegral() + recharge.getPrice().multiply(new BigDecimal(10)).intValue());
            accService.update(news);
        }
        return service.add(recharge)>0?true:false;
    }




}
