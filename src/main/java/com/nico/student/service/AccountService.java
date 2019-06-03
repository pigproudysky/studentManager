package com.nico.student.service;

import com.nico.student.bean.Account;
import com.nico.student.bean.Student;

import java.util.List;

public interface AccountService {

    List<Account> getAll();

    Account getOne(int sid);

    int addAccount(Account acc);

    int buy(Account acc);

    int update(Account acc);

    int download(Account acc);

}
