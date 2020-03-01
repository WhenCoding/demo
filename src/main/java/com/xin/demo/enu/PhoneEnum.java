package com.xin.demo.enu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @auther xgs
 * @date 2020/1/16 2:10 下午
 */
@AllArgsConstructor
@Getter
public enum  PhoneEnum {
    apple("apple"),
    huawei("huawei");
    String productName;
}
