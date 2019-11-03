package com.xin.demo.model;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 静态代理（装饰者模式），用聚合的方式实现
 */
@Slf4j
@AllArgsConstructor
public class BirdLogProxy implements Flyable {
    private Flyable flyable;
    @Override
    public void fly() {
        log.info("Bird start Fly...");
        flyable.fly();
        log.info("Bird end Fly...");
    }
}
