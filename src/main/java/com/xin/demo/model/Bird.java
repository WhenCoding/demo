package com.xin.demo.model;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
@Slf4j
public class Bird implements Flyable{
    @Override
    public void fly() {
        try {
            log.info("Bird flying...");
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
