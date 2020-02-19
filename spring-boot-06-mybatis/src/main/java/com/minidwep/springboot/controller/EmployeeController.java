package com.minidwep.springboot.controller;

import com.minidwep.springboot.bean.Department;
import com.minidwep.springboot.bean.Employee;
import com.minidwep.springboot.mapper.DepartmentMapper;
import com.minidwep.springboot.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeMapper employeeMapper;


    @GetMapping("/emp/{id}")
    @ResponseBody
    public Employee getEmpById(@PathVariable("id") Integer id){
        return employeeMapper.getEmpById(id);
    }
}
