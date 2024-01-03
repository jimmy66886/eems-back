package com.zzmr.eemsback.mapper;

import com.zzmr.eemsback.bean.Isolation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author zzmr
 * @since 2024-01-01
 */
@Mapper
public interface IsolationMapper extends BaseMapper<Isolation> {

    @Select("select * from isolation where account = #{isolation.account} and #{nowDate} >= #{isolation.startDate} and #{nowDate} <= #{isolation.endDate};")
    Isolation getByDate(@Param("isolation") Isolation isolation,@Param("nowDate") LocalDate nowDate);
}
