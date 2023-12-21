package com.zzmr.eemsback.controller;

import com.zzmr.eemsback.bean.User;
import com.zzmr.eemsback.result.Result;
import com.zzmr.eemsback.service.UserService;
import com.zzmr.eemsback.vo.StudentBpprtVo;
import com.zzmr.eemsback.vo.TeacherBpprtVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


}
