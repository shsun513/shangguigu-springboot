package com.minidwep.cache.service;

import com.minidwep.cache.bean.Employee;
import com.minidwep.cache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;

@Service
@CacheConfig(cacheNames = "emp")
public class EmployeeService {


    @Autowired
    EmployeeMapper employeeMapper;

//    @Cacheable(cacheNames = "emp",key = "#root.methdoName+'['+#id+']'")
//    @Cacheable(cacheNames = "emp",keyGenerator = "myKeyGenerator")
    @Cacheable(cacheNames = "emp",key="#id")
    public Employee getEmp( Integer id){
        System.out.println("查询"+id+"员工");
        Employee emp = employeeMapper.getEmp(id);
        return emp;
    }


    /**
     *     public void updateEmp(Employee employee);
     *
     *     public void deleteEmp(Integer id);
     *
     *     public void insertEmp(Employee employee);
     *
     */

    @CachePut(value = "emp",key = "#result.id")
     public Employee updateEmp(Employee employee){
         System.out.println("保存了"+employee.getId()+"员工");
         employeeMapper.updateEmp(employee);
         return employee;
     }


     @CacheEvict(value = "emp",key = "#id")
//@CacheEvict(value = "emp",allEntries = true)
     public void deleteEmp(Integer id){
         System.out.println("删除了"+id+"员工");
//         employeeMapper.deleteEmp(id);
     }

     public void insertEmp(Employee employee){
         System.out.println("保存了"+employee.getId()+"员工");
         employeeMapper.insertEmp(employee);
     }

     @Caching(
             cacheable = {
                     @Cacheable(value = "emp",key = "#lastName")
             },
             put = {
                     @CachePut(value = "emp",key = "#result.id"),
                     @CachePut(value = "emp",key = "#result.email")
             }
     )
     public Employee getEmpByLastName(){
        return new Employee();
     }



}
