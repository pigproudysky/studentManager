package com.nico.student.service;

import com.nico.student.bean.File;

import java.util.List;
import java.util.Map;

public interface FileService {

    List<File> getAll(Map<String,Object> map);

    int getCount();

    int getMyCount(int sid);
    //5.用到了，改，再去serviceimpl
    File getOneById(String id);

    int buy(File file);

    List<File> getHeat();

}
