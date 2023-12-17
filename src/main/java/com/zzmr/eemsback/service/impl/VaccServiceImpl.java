package com.zzmr.eemsback.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzmr.eemsback.bean.Vacc;
import com.zzmr.eemsback.mapper.VaccMapper;
import com.zzmr.eemsback.service.VaccService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zzmr
 * @since 2023-12-10
 */
@Service
public class VaccServiceImpl extends ServiceImpl<VaccMapper, Vacc> implements VaccService {

    @Override
    public void saveOne(String value, String account) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("account", account);
        Vacc vaccData = baseMapper.selectOne(queryWrapper);
        // 如果存在就更新数据
        if (vaccData != null) {
            vaccData.setValue(value);
            baseMapper.updateById(vaccData);
        } else {
            Vacc vacc = new Vacc();
            vacc.setValue(value);
            vacc.setAccount(account);
            // 不存在就直接插入
            baseMapper.insert(vacc);
        }


    }
}
