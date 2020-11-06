package com.dayeliu.seata.seataaccount.entities;

import lombok.*;

import java.math.BigDecimal;

/**
 * @author liuch
 * @date 2020/10/10 - 23:09
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private Integer id;
    private String userId;
    private BigDecimal money;
}
