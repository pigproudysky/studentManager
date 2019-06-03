package com.nico.student.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nico.student.bean.Clazz;
import com.nico.student.mapper.ClazzMapper;
import com.nico.student.service.ClazzService;
@Service
public class ClazzServiceImpl implements ClazzService{
	
	@Autowired
	private ClazzMapper mapper;
	
	@Override
	public List<Clazz> getAll() {
		return mapper.getAll();
	}
		
}
