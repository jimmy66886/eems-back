package com.zzmr.eemsback.service.impl;

import com.zzmr.eemsback.bean.Message;
import com.zzmr.eemsback.mapper.MessageMapper;
import com.zzmr.eemsback.service.MessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zzmr
 * @since 2024-01-03
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {

}
