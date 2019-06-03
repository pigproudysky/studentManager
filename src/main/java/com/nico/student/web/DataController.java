package com.nico.student.web;

import java.util.ArrayList;
import java.util.List;

import com.nico.student.bean.Student;
import com.nico.student.service.FileService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nico.student.service.StudentService;

@RestController
@RequestMapping("/data")
public class DataController {
	
	@Autowired
	private FileService service;
	
	@RequestMapping("/show")
	public List<Integer> show(){
		List<Integer> lst = new ArrayList<>();
		Student stu = (Student) SecurityUtils.getSubject().getSession().getAttribute("stu");
		lst.add(service.getCount());
		lst.add(service.getMyCount(stu.getId()));
		return lst;
	}
	
	
}
