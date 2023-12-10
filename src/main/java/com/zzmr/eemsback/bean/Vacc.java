package com.zzmr.eemsback.bean;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author zzmr
 * @since 2023-12-10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@TableName("vacc")
public class Vacc implements Serializable {


    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField("value")
    private String value;

    @TableField("account")
    private String account;


}
