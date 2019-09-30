package com.itheima.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 账户的实体类
 */
@Data
public class Account implements Serializable {

    private Integer id;
    private String name;
    private Float money;
}
