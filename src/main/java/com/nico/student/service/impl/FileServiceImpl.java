package com.nico.student.service.impl;

import com.nico.student.bean.Bill;
import com.nico.student.bean.File;
import com.nico.student.bean.Student;
import com.nico.student.bean.Type;
import com.nico.student.mapper.FileMapper;
import com.nico.student.service.BillService;
import com.nico.student.service.FileService;
import com.nico.student.service.TypeService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileMapper mapper;

    @Override
    public List<File> getAll(Map<String,Object> map) {
        return mapper.getAll(map);
    }

    @Override
    public int getCount() {
        return mapper.getCount();
    }

    @Override
    public int getMyCount(int sid) {
        return mapper.getMyCount(sid);
    }
    //6.这里用到了，改，再去controller
    @Override
    public File getOneById(String id) {
        return mapper.getOneById(id);
    }

    @Override
    public int buy(File file) {
        return mapper.buy(file);
    }

    @Override
    public List<File> getHeat() {
        return mapper.getHeat();
    }
}
