package com.zzmr.eemsback.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zzmr.eemsback.bean.Bpprt;
import com.zzmr.eemsback.bean.User;
import com.zzmr.eemsback.exception.BaseException;
import com.zzmr.eemsback.mapper.BpprtMapper;
import com.zzmr.eemsback.mapper.UserMapper;
import com.zzmr.eemsback.result.PageResult;
import com.zzmr.eemsback.service.UserService;
import com.zzmr.eemsback.vo.AllBpprtVo;
import com.zzmr.eemsback.vo.StudentBpprtVo;
import com.zzmr.eemsback.vo.TeacherBpprtVo;
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

    @Override
    public List<TeacherBpprtVo> getTeBpprtInfo() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("type", 1);
        List<User> teacherList = baseMapper.selectList(queryWrapper);

        List<TeacherBpprtVo> teacherBpprtVos = new ArrayList<>();

        for (User user : teacherList) {
            TeacherBpprtVo teacherBpprtVo = new TeacherBpprtVo();

            QueryWrapper q1 = new QueryWrapper();
            q1.eq("account", user.getAccount());
            q1.eq("date", LocalDate.now());
            Bpprt bpprt = bpprtMapper.selectOne(q1);

            if (bpprt != null) {
                teacherBpprtVo.setBpprt(bpprt.getValue());
            } else {
                teacherBpprtVo.setBpprt("0");
            }
            teacherBpprtVo.setAccount(user.getAccount());
            teacherBpprtVo.setName(user.getName());
            teacherBpprtVos.add(teacherBpprtVo);
        }
        return teacherBpprtVos;
    }

    @Override
    public List<AllBpprtVo> getAllBpprtInfo() {

        List<AllBpprtVo> allBpprtVoList = new ArrayList<>();

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.in("type", 0, 1, 2, 3);

        List<User> users = baseMapper.selectList(queryWrapper);

        for (User user : users) {

            AllBpprtVo allBpprtVo = new AllBpprtVo();

            QueryWrapper q1 = new QueryWrapper();
            q1.eq("account", user.getAccount());
            q1.eq("date", LocalDate.now());
            Bpprt bpprt = bpprtMapper.selectOne(q1);

            if (bpprt != null) {
                allBpprtVo.setBpprt(bpprt.getValue());
            } else {
                allBpprtVo.setBpprt("0");
            }

            String type = "";
            if (user.getType() == 0) {
                type = "学生";
            }
            if (user.getType() == 1) {
                type = "教职员工";
            }
            if (user.getType() == 2) {
                type = "学校二级管理员";
            }
            if (user.getType() == 3) {
                type = "学校疫情管理员";
            }

            allBpprtVo.setType(type);
            allBpprtVo.setName(user.getName());
            allBpprtVo.setAccount(user.getAccount());

            allBpprtVoList.add(allBpprtVo);

        }

        return allBpprtVoList;
    }

    @Override
    public PageResult getAllBpprtInfo(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.in("type", 0, 1, 2, 3);
        Page<User> userPage = (Page<User>) baseMapper.selectList(queryWrapper);


        long total = userPage.getTotal();
        List<User> result = userPage.getResult();


        List<AllBpprtVo> allBpprtVoList = new ArrayList<>();

        // 拿到了这几个用户，对这几个用户进行体温查询不就得了
        for (User user : result) {

            AllBpprtVo allBpprtVo = new AllBpprtVo();

            QueryWrapper q1 = new QueryWrapper();
            q1.eq("account", user.getAccount());
            q1.eq("date", LocalDate.now());
            Bpprt bpprt = bpprtMapper.selectOne(q1);

            if (bpprt != null) {
                allBpprtVo.setBpprt(bpprt.getValue());
            } else {
                allBpprtVo.setBpprt("0");
            }

            String type = "";
            if (user.getType() == 0) {
                type = "学生";
            }
            if (user.getType() == 1) {
                type = "教职员工";
            }
            if (user.getType() == 2) {
                type = "学校二级管理员";
            }
            if (user.getType() == 3) {
                type = "学校疫情管理员";
            }

            allBpprtVo.setType(type);
            allBpprtVo.setName(user.getName());
            allBpprtVo.setAccount(user.getAccount());

            allBpprtVoList.add(allBpprtVo);

        }

        // 返回值result要返回AllBpprtInfo
        return new PageResult(total, allBpprtVoList);

    }
}