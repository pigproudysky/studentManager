package com.nico.student.mapper;

import com.nico.student.bean.Type;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TypeMapper {

    List<Type> getAll();

}
