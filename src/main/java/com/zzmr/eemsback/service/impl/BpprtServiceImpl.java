package com.zzmr.eemsback.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzmr.eemsback.bean.Bpprt;
import com.zzmr.eemsback.exception.BaseException;
import com.zzmr.eemsback.mapper.BpprtMapper;
import com.zzmr.eemsback.service.BpprtService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zzmr
 * @since 2023-12-10
 */
@Service
public class BpprtServiceImpl extends ServiceImpl<BpprtMapper, Bpprt> implements BpprtService {

    @Override
    public void insert(String value, String account) {

        Bpprt bpprt = new Bpprt();
        // 确定为当天
        bpprt.setDate(LocalDate.now());
        bpprt.setAccount(account);

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("account", bpprt.getAccount());
        queryWrapper.eq("date", bpprt.getDate());
        Bpprt bpprtDB = baseMapper.selectOne(queryWrapper);
        if (bpprtDB != null) {
            // 代表今天已经打过卡了
            throw new BaseException("请勿重复打卡");
        }
        bpprt.setValue(value);
        baseMapper.insert(bpprt);
    }
}
