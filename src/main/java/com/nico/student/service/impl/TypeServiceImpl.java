package com.nico.student.service.impl;

import com.nico.student.bean.Type;
import com.nico.student.mapper.TypeMapper;
import com.nico.student.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper mapper;

    @Override
    public List<Type> getAll() {
        return mapper.getAll();
    }

}
