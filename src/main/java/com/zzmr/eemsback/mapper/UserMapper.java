package com.zzmr.eemsback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzmr.eemsback.bean.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zzmr
 * @create 2023-12-10 21:47
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
