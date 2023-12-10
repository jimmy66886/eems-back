package com.zzmr.eemsback.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * @author zzmr
 * @create 2023-12-10 21:51
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@TableName("user")
public class User {
    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField("account")
    private String account;

    @TableField("password")
    private String password;

    @TableField("birthday")
    private LocalDate birthDay;

    @TableField("name")
    private String name;

    @TableField("type")
    private Integer type;
}
