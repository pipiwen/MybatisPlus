package com.syw.mp1.entity.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.syw.mp1.entity.Employee;
import com.syw.rad.annotation.persistence.annotation.MyBatisDao;

@MyBatisDao
public interface EmployeeDao extends BaseMapper<Employee> {
}
