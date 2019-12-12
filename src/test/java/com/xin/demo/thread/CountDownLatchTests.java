package com.xin.demo.thread;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;

@Slf4j
public class CountDownLatchTests {
    CountDownLatch countDownLatch = new CountDownLatch(2);

    Runnable runnable = () -> {
        log.info("子线程：{}，正在执行", Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            log.error("{}", e.getMessage());
        }
        log.info("子线程：{}，执行完毕", Thread.currentThread().getName());
    };

    @Test
    public void test1(){
        new Thread(runnable).start();
        new Thread(runnable).start();
        log.info("等待两个线程执行完毕……");
        try {
            countDownLatch.await();
            log.info("两个线程执行完毕，回到主线程继续执行……");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
