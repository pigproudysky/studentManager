package com.nico.student.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nico.student.bean.Log;
import com.nico.student.bean.Student;
import com.nico.student.service.LogService;

@RestController
@RequestMapping("/log")
public class LogController {
	@Autowired
	private LogService logService; 
	
	@RequestMapping("/list")
	public Map<String,Object> getAll(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", (page - 1 ) * limit);
		map.put("limit", limit);
		Student stu = (Student)SecurityUtils.getSubject().getSession().getAttribute("stu");
		map.put("sid", stu.getId());
		List<Log> lst = logService.getAll(map);
		int count = logService.getCount(map);
		Map<String ,Object> resultMap = new HashMap<String, Object>();
		resultMap.put("code", 0);
		resultMap.put("msg", "");
		resultMap.put("data", lst);
		resultMap.put("count", count);
		return resultMap;
	} 
}
