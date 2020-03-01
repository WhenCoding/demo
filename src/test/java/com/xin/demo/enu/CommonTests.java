package com.xin.demo.enu;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @auther xgs
 * @date 2020/1/16 2:14 下午
 */
@Slf4j
public class CommonTests {
    @Test
    public void test() {
        String iphone = PhoneEnum.valueOf("apple").getProductName();
        log.info(iphone);
    }
}
