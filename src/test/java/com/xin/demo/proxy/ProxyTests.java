package com.xin.demo.proxy;

import com.xin.demo.model.*;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

/**
 * 静态代理至少有以下两个局限性问题：
 *
 * 如果同时代理多个类，依然会导致类无限制扩展
 * 如果类中有多个方法，同样的逻辑需要反复实现
 *
 * 因此使用动态代理
 * 动态代理会减少重复的代码，使代码更整洁灵活
 */
public class ProxyTests {
    /**
     * 使用静态代理：先输出飞行日志，再输出时间
     */
    @Test
    public void test1(){
        Bird bird = new Bird();
        BirdTimeProxy birdTimeProxy = new BirdTimeProxy(bird);
        BirdLogProxy birdLogProxy = new BirdLogProxy(birdTimeProxy);
        birdLogProxy.fly();
    }
    /**
     * 使用静态代理：先输出飞行时间，再输出飞行日志
     */
    @Test
    public void test2(){
        Bird bird = new Bird();
        BirdLogProxy birdLogProxy = new BirdLogProxy(bird);
        BirdTimeProxy birdTimeProxy = new BirdTimeProxy(birdLogProxy);
        birdTimeProxy.fly();
    }
    /**
     * 动态代理举例
     */
    @Test
    public void test3(){
        /**
         * loader:　　一个ClassLoader对象，定义了由哪个ClassLoader对象来对生成的代理对象进行加载
         * interfaces:　　一个Interface对象的数组，表示的是我将要给我需要代理的对象提供一组什么接口，如果我提供了一组接口给它，那么这个代理对象就宣称实现了该接口(多态)，这样我就能调用这组接口中的方法了
         * h:　　一个InvocationHandler对象，表示的是当我这个动态代理对象在调用方法的时候，会关联到哪一个InvocationHandler对象上
         */
        Flyable flyable = (Flyable) Proxy.newProxyInstance(Bird.class.getClassLoader(),Bird.class.getInterfaces(),new BirdProxy());
//        flyable.fly();
        System.out.println(flyable.getClass());
    }

}
