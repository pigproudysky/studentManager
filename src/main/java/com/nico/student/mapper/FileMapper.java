package com.nico.student.mapper;

import com.nico.student.bean.File;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface FileMapper {

    List<File> getAll(Map<String,Object> map);

    int getCount();

    int getMyCount(int sid);

    //4.这里用到了，改为string,再去service
    File getOneBySid(String id);

    File getOneById(String id);

    int buy(File file);

    List<File> getHeat();


}
