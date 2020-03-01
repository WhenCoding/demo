package com.xin.demo.jdk8;

import org.junit.Test;

import java.util.Objects;
import java.util.Optional;

/**
 * @auther xgs
 * @date 2020/1/9 4:21 下午
 */

public class CommonTests {
    /**
     * if args is Object,judge is null and set default value.
     */
    @Test
    public void  optionalTest(){
        int i = Optional.ofNullable(null).map(it -> Integer.parseInt(it.toString())).orElse(1);
        System.out.println(i);
    }
}
