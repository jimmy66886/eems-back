package com.zzmr.eemsback.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzmr.eemsback.bean.Bpprt;
import com.zzmr.eemsback.bean.User;
import com.zzmr.eemsback.result.PageResult;
import com.zzmr.eemsback.result.Result;
import com.zzmr.eemsback.service.UserService;
import com.zzmr.eemsback.vo.AllBpprtVo;
import com.zzmr.eemsback.vo.StudentBpprtVo;
import com.zzmr.eemsback.vo.TeacherBpprtVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * @author zzmr
 * @create 2023-12-17 20:55
 */
@RestController
@Api(tags = "学校疫情管理员相关接口")
@RequestMapping("/se")
@CrossOrigin
public class SeController {

    @Autowired
    private UserService userService;

    /**
     * 获取所有老师的体温打卡信息
     *
     * @return
     */
    @ApiOperation("获取所有老师的体温打卡信息")
    @GetMapping("/getTeBpprtInfo")
    public Result getTeBpprtInfo() {
        // 获取所有老师的name，account，bpprt
        List<TeacherBpprtVo> list = userService.getTeBpprtInfo();

        return Result.success(list);
    }

    @ApiOperation("获取所有人的体温打卡信息")
    @GetMapping("/getAllBpprtInfo")
    public Result getAllBpprtInfo() {
        List<AllBpprtVo> list = userService.getAllBpprtInfo();
        return Result.success(list);
    }

    @ApiOperation("分页查询所有人的体温打卡信息")
    @GetMapping("/getAllBpprtInfoByPage/{page}/{pageSize}")
    public Result getAllBpprtInfo(@PathVariable("page") Integer page, @PathVariable("pageSize") Integer pageSize) {
        PageResult pageResult = userService.getAllBpprtInfo(page, pageSize);
        return Result.success(pageResult);
    }


}
