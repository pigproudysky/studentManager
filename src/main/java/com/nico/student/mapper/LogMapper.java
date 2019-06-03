package com.nico.student.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.nico.student.bean.Log;


@Mapper
public interface LogMapper {

	void loginSave(Log log);

	void logoutSave(Log log);

	List<Log> getAll(Map<String, Object> map);

	int getCount(Map<String, Object> map);

}
