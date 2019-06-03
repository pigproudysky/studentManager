package com.nico.student.web;


import com.nico.student.bean.Account;
import com.nico.student.bean.Bill;
import com.nico.student.bean.File;
import com.nico.student.bean.Student;
import com.nico.student.service.AccountService;
import com.nico.student.service.BillService;
import com.nico.student.service.FileService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/acc")
public class AccountController {

    @Autowired
    private AccountService service;
    @Autowired
    private FileService fileService;
    @Autowired
    private BillService billService;

    @RequestMapping("/buy")
    public Integer buy(Integer fid){
        Student stu = (Student) SecurityUtils.getSubject().getSession().getAttribute("stu");
        Account account =  service.getOne(stu.getId());
        if(account== null){
            return -1;
        }
        File file = fileService.getOneById(fid);
        BigDecimal result = account.getAmount().subtract(file.getPrice());
        if(0 > result.floatValue()){
            return -1;
        }else if(0 <= result.floatValue()){
            account.setAmount(result);
            account.setIntegral(file.getPrice().intValue()*10);
            service.buy(account);
            file.setSale_number((file.getSale_number() + 1));
            fileService.buy(file);
            Bill bill = new Bill();
            bill.setSid(stu.getId());
            bill.setFid(file.getId());
            bill.setPrice(file.getPrice());
            billService.buy(bill);
            return 1;
        }
        return 0;
    }

}
