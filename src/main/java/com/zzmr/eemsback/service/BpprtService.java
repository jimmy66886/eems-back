package com.zzmr.eemsback.service;

import com.zzmr.eemsback.bean.Bpprt;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zzmr
 * @since 2023-12-10
 */
public interface BpprtService extends IService<Bpprt> {

    /**
     * 体温打卡，不可重复打卡
     * @param value
     * @param account
     */
    void insert(String value, String account);
}
