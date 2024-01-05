package com.zzmr.eemsback.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zzmr.eemsback.bean.User;
import com.zzmr.eemsback.vo.AllBpprtVo;
import com.zzmr.eemsback.vo.StudentBpprtVo;
import com.zzmr.eemsback.vo.TeacherBpprtVo;

import java.util.List;

/**
 * @author zzmr
 * @create 2023-12-10 22:00
 */
public interface UserService extends IService<User> {
    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 获取同一个班所有学生的体温打卡信息
     *
     * @param classId
     * @return
     */
    List<StudentBpprtVo> getBpprtInfo(Integer classId);

    /**
     * 获取所有老师的体温打卡信息
     *
     * @return
     */
    List<TeacherBpprtVo> getTeBpprtInfo();

    /**
     * 获取所有人的体温打卡信息
     * @return
     */
    List<AllBpprtVo> getAllBpprtInfo();
}
