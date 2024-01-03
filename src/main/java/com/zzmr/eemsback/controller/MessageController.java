package com.zzmr.eemsback.controller;


import com.zzmr.eemsback.bean.Message;
import com.zzmr.eemsback.result.Result;
import com.zzmr.eemsback.service.MessageService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zzmr
 * @since 2024-01-03
 */
@RestController
@Api(tags = "消息相关接口")
@RequestMapping("/message")
@CrossOrigin
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/send")
    public Result sendMessage(@RequestBody Message message) {
        message.setDatetime(LocalDateTime.now());
        messageService.save(message);
        return Result.success();
    }

    @GetMapping("/getAll")
    public Result getAll() {
        List<Message> messageList = messageService.list();
        return Result.success(messageList);
    }

    @DeleteMapping("/remove/{id}")
    public Result remove(@PathVariable Long id) {
        messageService.removeById(id);
        return Result.success();
    }


}

