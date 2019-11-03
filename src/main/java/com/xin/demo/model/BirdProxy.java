package com.xin.demo.model;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
@Slf4j
public class BirdProxy implements InvocationHandler {
    /**
     * proxy:　　指代我们所代理的那个真实对象
     * method:　　指代的是我们所要调用真实对象的某个方法的Method对象
     * args:　　指代的是调用真实对象某个方法时接受的参数
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("Bird start Fly...");
        method.invoke(Bird.class.newInstance(),args);
        log.info("Bird end Fly...");
        return null;
    }
}
