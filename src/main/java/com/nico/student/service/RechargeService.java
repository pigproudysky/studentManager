package com.nico.student.service;

import com.nico.student.bean.Recharge;

import java.util.List;
import java.util.Map;

public interface RechargeService {

    List<Recharge> getAll(Map<String,Object> map);

    int getCount(Map<String, Object> map);

    int add(Recharge recharge);

}
