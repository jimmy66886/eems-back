package com.zzmr.eemsback.controller;

import com.zzmr.eemsback.result.Result;
import com.zzmr.eemsback.service.UserService;
import com.zzmr.eemsback.vo.StudentBpprtVo;
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
@Api(tags = "教职员工相关接口")
@RequestMapping("/te")
@CrossOrigin
public class TeController {

    @Autowired
    private UserService userService;

    /**
     * 获取同一个班所有学生的体温打卡信息
     *
     * @param classId
     * @return
     */
    @ApiOperation("获取所有学生的体温打卡信息")
    @GetMapping("/getBpprtInfo/{classId}")
    public Result getBpprtInfo(@PathVariable Integer classId) {
        // 获取所有学生的name，account，bpprt
        List<StudentBpprtVo> list = userService.getBpprtInfo(classId);

        return Result.success(list);
    }


}
