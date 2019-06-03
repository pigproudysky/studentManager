package com.nico.student.service.impl;

import com.nico.student.bean.Bill;
import com.nico.student.bean.File;
import com.nico.student.mapper.BillMapper;
import com.nico.student.service.BillService;
import com.nico.student.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillMapper mapper;

    @Override
    public List<Bill> getAll(Map<String, Object> map) {
        List<Bill> bills = mapper.getAll(map);

        return bills;
    }

    @Override
    public int getCount(Map<String, Object> map) {
        return mapper.getCount(map);
    }

    @Override
    public int buy(Bill bill) {
        return mapper.buy(bill);
    }
}
