package com.nico.student.mapper;

import com.nico.student.bean.Account;
import com.nico.student.bean.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccountMapper {

    List<Account> getAll();

    Account getOne(int sid);

    int addAccount(Account acc);

    int buy(Account acc);

    int update(Account acc);

    int download(Account acc);


}
