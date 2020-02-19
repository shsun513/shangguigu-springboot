package com.minidwep.cache.mapper;

import com.minidwep.cache.bean.Employee;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;



public interface EmployeeMapper {
    @Select("SELECT * FROM employee WHERE id = #{id}")
    public Employee getEmp(Integer id);

    @Update("UPDATE employee SET lastName =#{lastName},email=#{email},gender=#{gender}" +
            ",d_id=#{dId} WHERE id=#{id}")
    public void updateEmp(Employee employee);

    @Delete("DELETE employee WHERE id=#{id}")
    public void deleteEmp(Integer id);

    @Insert("INSERT INTO employee(lastName,email,gender,d_id) VALUES(#{lastName},#{email},#{gender},#{dId})")
    public void insertEmp(Employee employee);
}
