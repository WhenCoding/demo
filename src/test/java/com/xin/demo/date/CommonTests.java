package com.xin.demo.date;

import org.junit.jupiter.api.Test;

import java.time.Instant;

/**
 * @auther xgs
 * @date 2020/1/9 5:00 下午
 */

public class CommonTests {
    @Test
    public void  current(){
        Instant now = Instant.now();
        long l = now.toEpochMilli();
        System.out.println(l);
    }

}
