package com.zzmr.eemsback.bean;

import com.baomidou.mybatisplus.annotation.IdType;

import java.time.LocalDate;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @author zzmr
 * @since 2024-01-01
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@TableName("isolation")
public class Isolation implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField("account")
    private String account;

    /**
     * 隔离开始时间
     */
    @TableField("start_date")
    private LocalDate startDate;

    /**
     * 隔离时间
     */
    @TableField("end_date")
    private LocalDate endDate;

    @TableField("name")
    private String name;

    @TableField("isRead")
    private Boolean isRead;

    /**
     * 隔离地点
     */
    @TableField("site")
    private String site;

}
