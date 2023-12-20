package com.zzmr.eemsback.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzmr.eemsback.bean.Bpprt;
import com.zzmr.eemsback.result.Result;
import com.zzmr.eemsback.service.BpprtService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

/**
 * @author zzmr
 * @since 2023-12-10
 */
@RestController
@Api(tags = "体温相关接口")
@RequestMapping("/bpprt")
@CrossOrigin
public class BpprtController {

    @Autowired
    private BpprtService bpprtService;

    @GetMapping("/getBpprtInfo/{account}")
    public Result getBpprtInfo(@PathVariable String account) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("account", account);
        queryWrapper.eq("date", LocalDate.now());
        Bpprt bpprt = bpprtService.getOne(queryWrapper);
        if (bpprt != null) {
            return Result.success(bpprt);
        } else {
            return Result.success(null);
        }
    }

    @PostMapping("/insert/{value}/{account}")
    public Result insert(@PathVariable("value") String value, @PathVariable("account") String account) {
        bpprtService.insert(value, account);
        return Result.success();
    }
}

