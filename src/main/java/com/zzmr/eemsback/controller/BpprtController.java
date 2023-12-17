package com.zzmr.eemsback.controller;


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

    @PostMapping("/insert/{value}/{account}")
    public Result insert(@PathVariable("value") String value, @PathVariable("account") String account) {
        Bpprt bpprt = new Bpprt();
        bpprt.setAccount(account);
        bpprt.setDate(LocalDate.now());
        bpprt.setValue(value);
        bpprtService.save(bpprt);
        return Result.success();
    }
}

