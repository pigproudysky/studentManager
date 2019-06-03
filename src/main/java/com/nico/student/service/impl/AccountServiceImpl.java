package com.nico.student.service.impl;

import com.nico.student.bean.Account;
import com.nico.student.bean.Student;
import com.nico.student.mapper.AccountMapper;
import com.nico.student.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper mapper;

    @Override
    public List<Account> getAll() {
        return mapper.getAll();
    }

    @Override
    public Account getOne(int sid) {
        return mapper.getOne(sid);
    }

    @Override
    public int addAccount(Account acc) {
        return mapper.addAccount(acc);
    }

    @Override
    public int buy(Account acc) {
        return mapper.buy(acc);
    }

    @Override
    public int update(Account acc) {
        return mapper.update(acc);
    }

    @Override
    public int download(Account acc) {
        return mapper.download(acc);
    }
}
