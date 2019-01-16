package com.syw.mpgenerator.service.impl;

import com.syw.mpgenerator.entity.User;
import com.syw.mpgenerator.dao.UserMapper;
import com.syw.mpgenerator.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author syw
 * @since 2019-01-15
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
