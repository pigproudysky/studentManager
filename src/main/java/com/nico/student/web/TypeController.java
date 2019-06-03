package com.nico.student.web;

import com.nico.student.bean.Type;
import com.nico.student.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/type")
public class TypeController {

    @Autowired
    private TypeService service;

    @RequestMapping("/all")
    public List<Type> getAlls(){
        List<Type> types = service.getAll();
        return types;
    }
}
