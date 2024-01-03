package com.zzmr.eemsback.controller;


import com.zzmr.eemsback.bean.User;
import com.zzmr.eemsback.result.Result;
import com.zzmr.eemsback.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        User userDB = userService.login(user);
        return Result.success(userDB);
    }

    @PutMapping("/change")
    public Result change(@RequestBody User user) {
        userService.updateById(user);
        return Result.success();
    }

    @GetMapping("/get/{id}")
    public Result getById(@PathVariable Long id) {
        User user = userService.getById(id);
        return Result.success(user);
    }

    // 插入疫情管理员信息
    @PostMapping("/insertSe")
    public Result insertSe(@RequestBody User user) {
        user.setPassword("000000");
        user.setType(3);
        userService.save(user);
        return Result.success();
    }

    // 插入二级单位管理员信息
    @PostMapping("/insertSlt")
    public Result insertSlt(@RequestBody User user) {
        user.setPassword("000000");
        user.setType(2);
        userService.save(user);
        return Result.success();
    }

}
