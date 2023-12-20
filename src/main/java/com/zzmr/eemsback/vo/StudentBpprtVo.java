package com.zzmr.eemsback.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author zzmr
 * @create 2023-12-17 20:58
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class StudentBpprtVo {

    private String name;

    private String account;

    private String bpprt;

}
