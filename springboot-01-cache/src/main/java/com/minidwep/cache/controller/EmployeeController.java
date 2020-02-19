package com.minidwep.cache.controller;

import com.minidwep.cache.bean.Employee;
import com.minidwep.cache.mapper.EmployeeMapper;
import com.minidwep.cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    @GetMapping("/emp/{id}")
    @ResponseBody
    public Employee getEmp(@PathVariable("id") Integer id){
        Employee emp = employeeService.getEmp(id);
        return emp;
    }

    @GetMapping("/emp")
    @ResponseBody
    public Employee updateEmp(Employee employee){
        System.out.println(employee.toString());
        Employee emp = employeeService.updateEmp(employee);
        return emp;
    }

    @GetMapping("/delemp")
    @ResponseBody
    public String delEmp(Integer id){
     employeeService.deleteEmp(id);
        return "Success";
    }

}
