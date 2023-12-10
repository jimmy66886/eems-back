package com.zzmr.eemsback.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zzmr
 * @create 2023-12-10 18:50
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @GetMapping("/test")
    public String test() {
        return "test success";
    }

}
