package com.nico.student.mapper;

import com.nico.student.bean.Bill;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BillMapper {

    List<Bill> getAll(Map<String,Object> map);

    int getCount(Map<String,Object> map);

    int buy(Bill bill);


}
