package com.zzmr.eemsback.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzmr.eemsback.bean.User;
import com.zzmr.eemsback.exception.BaseException;
import com.zzmr.eemsback.mapper.UserMapper;
import com.zzmr.eemsback.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author zzmr
 * @create 2023-12-10 22:00
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public User login(User user) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("account", user.getAccount());
        queryWrapper.eq("password", user.getPassword());
        User userDB = baseMapper.selectOne(queryWrapper);
        if (userDB != null) {
            return userDB;
        }
        throw new BaseException("账号或密码错误");
    }
}
