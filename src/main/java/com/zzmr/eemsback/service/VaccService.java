package com.zzmr.eemsback.service;

import com.zzmr.eemsback.bean.Vacc;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zzmr
 * @since 2023-12-10
 */
public interface VaccService extends IService<Vacc> {

    void saveOne(String value, String account);
}
