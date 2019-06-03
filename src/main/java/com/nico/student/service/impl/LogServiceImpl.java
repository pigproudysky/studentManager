package com.nico.student.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nico.student.bean.Log;
import com.nico.student.mapper.LogMapper;
import com.nico.student.service.LogService;

@Service
public class LogServiceImpl implements LogService {

	@Autowired
	private LogMapper logMapper;
	
	public void loginSave(Log log) {
		logMapper.loginSave(log);
	}

	public void logoutSave(Log log) {
		logMapper.logoutSave(log);
	}

	public List<Log> getAll(Map<String, Object> map) {
		return logMapper.getAll(map);
	}

	public int getCount(Map<String, Object> map) {
		return logMapper.getCount(map);
	}
	

}
