package com.zzmr.eemsback.service.impl;

import com.zzmr.eemsback.bean.Isolation;
import com.zzmr.eemsback.mapper.IsolationMapper;
import com.zzmr.eemsback.service.IsolationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zzmr
 * @since 2024-01-01
 */
@Service
public class IsolationServiceImpl extends ServiceImpl<IsolationMapper, Isolation> implements IsolationService {

    @Autowired
    private IsolationMapper isolationMapper;

    @Override
    public Isolation getByDate(Isolation isolation) {
        Isolation isolationDB = isolationMapper.getByDate(isolation, LocalDate.now());
        return isolationDB;
    }
}
