package com.zzmr.eemsback.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzmr.eemsback.bean.User;
import com.zzmr.eemsback.result.Result;
import com.zzmr.eemsback.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zzmr
 * @create 2023-12-10 18:50
 */
@RequestMapping("/user")
@RestController
@Api(tags = "用户相关接口")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public Result test() {
        List<User> list = userService.list();
        return Result.success(list);
    }

}
