package com.nico.student.mapper;

import com.nico.student.bean.Account;
import com.nico.student.bean.Recharge;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface RechargeMapper {

    List<Recharge> getAll(Map<String,Object> map);

    int getCount(Map<String, Object> map);

    int add(Recharge recharge);

}
