package com.syw.mpgenerator.service.impl;

import com.syw.mpgenerator.entity.Employee;
import com.syw.mpgenerator.dao.EmployeeMapper;
import com.syw.mpgenerator.service.EmployeeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author syw
 * @since 2019-01-14
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
