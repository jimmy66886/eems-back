package com.zzmr.eemsback.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;
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
 * @since 2024-01-03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@TableName("message")
public class Message implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField("info")
    private String info;

    @TableField("datetime")
    private LocalDateTime datetime;

    @TableField("author")
    private String author;


}
