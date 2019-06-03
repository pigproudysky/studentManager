package com.nico.student.service;


import com.nico.student.bean.Bill;

import java.util.List;
import java.util.Map;

public interface BillService {

    List<Bill> getAll(Map<String,Object> map);

    int getCount(Map<String,Object> map);

    int buy(Bill bill);
}
