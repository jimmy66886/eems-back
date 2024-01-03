package com.zzmr.eemsback.controller;

import com.zzmr.eemsback.bean.User;
import com.zzmr.eemsback.result.Result;
import com.zzmr.eemsback.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zzmr
 * @create 2023-12-11 19:31
 */
@RestController
@Api(tags = "学校二级单位管理员相关接口")
@RequestMapping("/slt")
@CrossOrigin
public class SltController {

    @Autowired
    private UserService userService;

    // 插入学生信息
    @PostMapping("/insert")
    public Result insert(@RequestBody User user) {
        user.setPassword("000000");
        user.setType(0);
        userService.save(user);
        System.out.println(user);
        return Result.success();
    }

    // 插入老师信息
    @PostMapping("/insertTeacher")
    public Result insertTeacher(@RequestBody User user) {
        user.setPassword("000000");
        user.setType(1);
        userService.save(user);
        return Result.success();
    }


}
