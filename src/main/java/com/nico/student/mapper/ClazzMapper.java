package com.nico.student.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nico.student.bean.Clazz;

@Mapper
public interface ClazzMapper {
	
	List<Clazz> getAll();
}
