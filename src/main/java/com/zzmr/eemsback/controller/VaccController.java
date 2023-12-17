package com.zzmr.eemsback.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzmr.eemsback.bean.Vacc;
import com.zzmr.eemsback.result.Result;
import com.zzmr.eemsback.service.VaccService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zzmr
 * @since 2023-12-10
 */
@RestController
@Api(tags = "疫苗相关接口")
@RequestMapping("/vacc")
@CrossOrigin
public class VaccController {

    @Autowired
    private VaccService vaccService;

    @PostMapping("/insert/{value}/{account}")
    public Result insert(@PathVariable String value, @PathVariable String account) {
        vaccService.saveOne(value,account);
        return Result.success();
    }

    @GetMapping("/get/{account}")
    public Result getByAccount(@PathVariable String account) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("account", account);
        Vacc vacc = vaccService.getOne(queryWrapper);
        return Result.success(vacc);
    }

}

