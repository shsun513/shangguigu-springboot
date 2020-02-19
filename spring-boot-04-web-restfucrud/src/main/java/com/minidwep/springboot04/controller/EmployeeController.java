package com.minidwep.springboot04.controller;

import com.minidwep.springboot04.dao.DepartmentDao;
import com.minidwep.springboot04.dao.EmployeeDao;
import com.minidwep.springboot04.entities.Department;
import com.minidwep.springboot04.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

//    查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
//        放在请求域中
        model.addAttribute("emps",employees);
//        thymeleaf默认会拼串
//        classpath:/templates/xxx.html
        return "emp/list";
    }
//    来到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }
    @GetMapping("/emp1")
    public String toAddPage1(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add1";
    }
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        System.out.println("Use method addEmp");
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";

    }
//    修改员工
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.get(id);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        model.addAttribute("emp",employee);
        return "emp/add";
    }

    @PutMapping("/emp")
    public String updateEmp(Employee employee){
        System.out.println("Use method putEmp");
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}

