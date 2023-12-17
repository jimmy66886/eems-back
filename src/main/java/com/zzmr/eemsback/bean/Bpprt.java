package com.zzmr.eemsback.bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @author zzmr
 * @since 2023-12-10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@TableName("bpprt")
public class Bpprt implements Serializable {


    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField("account")
    private String account;

    /**
     * 体温值
     */
    @TableField("value")
    private String value;

    @TableField("date")
    private LocalDate date;


}
