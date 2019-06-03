package com.nico.student.service.impl;

import com.nico.student.bean.Recharge;
import com.nico.student.mapper.RechargeMapper;
import com.nico.student.service.RechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class RechargeServiceImpl implements RechargeService {

    @Autowired
    private RechargeMapper mapper;

    @Override
    public List<Recharge> getAll(Map<String, Object> map) {
        return mapper.getAll(map);
    }

    @Override
    public int getCount(Map<String, Object> map) {
        return mapper.getCount(map);
    }

    @Override
    public int add(Recharge recharge) {
        return mapper.add(recharge);
    }
}
