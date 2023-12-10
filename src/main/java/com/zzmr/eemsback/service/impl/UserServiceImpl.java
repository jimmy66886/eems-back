package com.zzmr.eemsback.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzmr.eemsback.bean.User;
import com.zzmr.eemsback.mapper.UserMapper;
import com.zzmr.eemsback.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author zzmr
 * @create 2023-12-10 22:00
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
