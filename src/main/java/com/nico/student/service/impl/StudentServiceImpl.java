package com.nico.student.service.impl;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nico.student.bean.Student;
import com.nico.student.mapper.StudentMapper;
import com.nico.student.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentMapper mapper;
	
	@Override
	public Student login(String name) {
		return mapper.login(name);
	}
	@Override
	public List<Student> getAll(Map<String, Object> map) {
		return mapper.getAll(map);
	}
	@Override
	public int getAllCount(Map<String, Object> map) {
		return mapper.getAllCount(map);
	}
	@Override
	public int add(Student stu) {
		return mapper.add(stu);
	}
	@Override
	public int edit(Student stu) {
		return mapper.edit(stu);
	}
	@Override
	public int getCount() {
		return mapper.getCount();
	}
	@Override
	public Student checkName(Student stu) {
		return mapper.checkName(stu);
	}



	

}
