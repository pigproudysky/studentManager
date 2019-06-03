package com.nico.student.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.nico.student.bean.Student;
@Mapper
public interface StudentMapper {
	
	Student login(String name);
	
	List<Student> getAll(Map<String, Object> map);
	
	int getAllCount(Map<String, Object> map);

	int add(Student stu);

	int edit(Student stu);
	
	int getCount();
	
	Student checkName(Student stu);
	
}
