package com.minidwep.springboot.controller;

import com.minidwep.springboot.bean.Department;
import com.minidwep.springboot.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DeptController {

    @Autowired
    DepartmentMapper departmentMapper;

    @GetMapping("/dept/{id}")
    @ResponseBody
    public Department getDepartment(@PathVariable("id") Integer id){
        Department dept = departmentMapper.getDeptById(id);
        return dept;
    }

    @GetMapping("/hello")
    @ResponseBody
    public String getDepartm1ent(){
        return "hello";
    }

}
