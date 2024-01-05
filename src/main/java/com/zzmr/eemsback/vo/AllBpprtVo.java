package com.zzmr.eemsback.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author zzmr
 * @create 2024-01-05 20:21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Builder
public class AllBpprtVo {

    private String name;

    private String account;

    private String bpprt;

    private String type;

}
