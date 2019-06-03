package com.nico.student.service;

import java.util.List;
import java.util.Map;

import com.nico.student.bean.Student;

public interface StudentService {

	Student login(String name);
	
	List<Student> getAll(Map<String, Object> map);
	
	int getAllCount(Map<String, Object> map);

	int add(Student stu);

	int edit(Student stu);
	
	int getCount();
	
	Student checkName(Student stu);
	
}
