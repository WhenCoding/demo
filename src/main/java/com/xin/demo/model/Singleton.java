package com.xin.demo.model;

import java.util.Objects;

/**
 * 单例模式
 */
public class Singleton {
    private static Singleton instance;

    /**
     * 私有化构造函数
     */
    private Singleton(){}

    /**
     * 在同步代码块的内部和外部都判断了instance == null，这是因为
     * 可能会有多个线程同时进入到同步代码块外的if判断中，
     * 如果在同步代码块内部不进行判空的话，可能会初始化多个实例。
     * @return
     */
    public static Singleton getInstance(){
        if(Objects.isNull(instance)){
            synchronized (Singleton.class){
                if(Objects.isNull(instance)){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
    /**
     * 可能存在的问题，双重检验锁线程不安全的问题：多线程环境中，返回一个初始化不完整的对象
     * 原因：
     * 创建对象整个过程不是原子操作，会有以下3个步骤：
     * 1、分配对象的内存空间；
     * 2、初始化对象；
     * 3、将初始化的对象指向内存空间。
     * 这三个步骤jvm优化可能造成指令重排序，比如1、3、2。
     * 因此当线程A按照1、3、2这个顺序，只是将对象分配内存空间（对象指向内存空间的时候instance 就不为null了），还未初始化完成的时候，
     * 这时候来了一个线程B调用getInstance()方法，就可能返回一个未初始化完成的对象，当线程B使用该对象时就会出现问题
     * 因此在多线程场景下，就会出现双重检验锁不安全的情况
     * 改进方案一：在jdk5的情况下，通过把instance 设置为volatile，防止指令重排序来解决
     * 改进方案二：使用静态内部类方式实现
     * @see SingletonTwo
     */

}
