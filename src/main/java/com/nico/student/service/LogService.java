package com.nico.student.service;

import java.util.List;
import java.util.Map;

import com.nico.student.bean.Log;


public interface LogService {

	void loginSave(Log log);
	void logoutSave(Log log);
	List<Log> getAll(Map<String, Object> map);
	int getCount(Map<String, Object> map);
}
