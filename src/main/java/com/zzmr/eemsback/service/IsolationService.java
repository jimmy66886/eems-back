package com.zzmr.eemsback.service;

import com.zzmr.eemsback.bean.Isolation;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zzmr
 * @since 2024-01-01
 */
public interface IsolationService extends IService<Isolation> {

    /**
     * 根据隔离对象中的日期区间,来判断当前用户在此时是否正在被隔离
     * @param isolation
     * @return
     */
    Isolation getByDate(Isolation isolation);
}
