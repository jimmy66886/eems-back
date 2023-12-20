package com.zzmr.eemsback.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzmr.eemsback.bean.Bpprt;
import com.zzmr.eemsback.bean.User;
import com.zzmr.eemsback.exception.BaseException;
import com.zzmr.eemsback.mapper.BpprtMapper;
import com.zzmr.eemsback.mapper.UserMapper;
import com.zzmr.eemsback.service.UserService;
import com.zzmr.eemsback.vo.StudentBpprtVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zzmr
 * @create 2023-12-10 22:00
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private BpprtMapper bpprtMapper;

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

    @Override
    public List<StudentBpprtVo> getBpprtInfo(Integer classId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("class_id", classId);
        queryWrapper.eq("type", 0);
        List<User> list = baseMapper.selectList(queryWrapper);
        List<StudentBpprtVo> studentBpprtVos = new ArrayList<>();
        for (User user : list) {
            StudentBpprtVo studentBpprtVo = new StudentBpprtVo();
            studentBpprtVo.setName(user.getName());
            studentBpprtVo.setAccount(user.getAccount());
            QueryWrapper queryWrapper1 = new QueryWrapper();
            queryWrapper1.eq("account", user.getAccount());
            queryWrapper1.eq("date", LocalDate.now());
            Bpprt bpprt = bpprtMapper.selectOne(queryWrapper1);
            if (bpprt != null) {
                studentBpprtVo.setBpprt(bpprt.getValue());
            } else {
                studentBpprtVo.setBpprt("0");
            }
            studentBpprtVos.add(studentBpprtVo);
        }

        return studentBpprtVos;
    }
}
