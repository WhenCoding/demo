package com.xin.demo.model;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 静态代理（装饰者模式），用聚合的方式实现：构造方法中传入Bird实例
 */
@Slf4j
@AllArgsConstructor
public class BirdTimeProxy implements Flyable {
    private Flyable flyable;
    @Override
    public void fly() {
        long start = System.currentTimeMillis();
        flyable.fly();
        long end = System.currentTimeMillis();
        log.info("飞行时间:{}",end - start);
    }
}
