package com.syw.mpgenerator.dao;

import com.syw.mpgenerator.entity.Employee;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.syw.rad.annotation.persistence.annotation.MyBatisDao;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author syw
 * @since 2019-01-14
 */
@MyBatisDao
public interface EmployeeMapper extends BaseMapper<Employee> {

}
