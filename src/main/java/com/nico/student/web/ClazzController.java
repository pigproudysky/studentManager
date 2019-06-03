package com.nico.student.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nico.student.bean.Clazz;
import com.nico.student.service.ClazzService;

@RestController
@RequestMapping("/clazz")
public class ClazzController {

	@Autowired
	private ClazzService service;
	
	@RequestMapping("/getAll")
	public List<Clazz> getAll(){
		List<Clazz> lst = service.getAll();
		return lst;
	}
	
}
