package com.zzmr.eemsback.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzmr.eemsback.bean.Isolation;
import com.zzmr.eemsback.bean.User;
import com.zzmr.eemsback.exception.BaseException;
import com.zzmr.eemsback.result.Result;
import com.zzmr.eemsback.service.IsolationService;
import com.zzmr.eemsback.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zzmr
 * @since 2024-01-01
 */
@RestController
@RequestMapping("/isolation")
@CrossOrigin
@Api(tags = "隔离相关接口")
@Slf4j
public class IsolationController {

    @Autowired
    private IsolationService isolationService;

    @Autowired
    private UserService userService;

    @ApiOperation("查询学生")
    @GetMapping("/get/{account}")
    public Result getByAccount(@PathVariable String account) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("account", account);
        User user = userService.getOne(queryWrapper);
        return Result.success(user);
    }

    @PostMapping("/insert")
    public Result isolationThis(@RequestBody Isolation isolation) {

        // 如果插入时,发现数据库中已经有了一条该学生的隔离记录了,且这条记录仍在有效期内,就是当前日期大于开始日期小于结束日期,则不能添加
        // Isolation isolationDB = isolationService.getByDate(isolation);

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("account", isolation.getAccount());
        Isolation isolationDB = isolationService.getOne(queryWrapper);

        System.out.println(isolationDB);
        System.out.println(LocalDate.now());
        if (isolationDB != null) {
            throw new BaseException("该学生正在隔离中!");
        }

        isolation.setIsRead(false);
        isolationService.save(isolation);
        return Result.success();
    }

    @GetMapping("/list")
    public Result getIsolationList() {
        List<Isolation> list = isolationService.list();
        return Result.success(list);
    }

    @DeleteMapping("/remove/{id}")
    public Result removeById(@PathVariable Long id) {
        isolationService.removeById(id);
        return Result.success();
    }

    @GetMapping("/getIsolation/{account}/{isRead}")
    public Result getIsolationByAccount(@PathVariable String account, @PathVariable Boolean isRead) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("account", account);
        queryWrapper.eq("isRead", isRead);
        Isolation isolation = isolationService.getOne(queryWrapper);
        return Result.success(isolation);
    }

    @PutMapping("/read")
    public Result readIsolation(@RequestBody Isolation isolation) {
        isolation.setIsRead(true);
        isolationService.updateById(isolation);
        return Result.success();
    }


}

