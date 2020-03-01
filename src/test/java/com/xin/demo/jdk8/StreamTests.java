package com.xin.demo.jdk8;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @auther xgs
 * @date 2020/1/19 9:54 上午
 */
@Slf4j
public class StreamTests {
    /**
     * 将数据用逗号分隔输出为字符串
     */
    @Test
    public void test() {
        String[] strings = {"1", "2"};
        String collect = Arrays.stream(strings).collect(Collectors.joining(","));
        log.info(collect);
    }
}
