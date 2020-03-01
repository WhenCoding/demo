package com.xin.demo.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @auther xgs
 * @date 2020/1/16 1:29 下午
 */
@Data
@Accessors(chain = true)
public class Person {
    private String name;
    private String address;
}
