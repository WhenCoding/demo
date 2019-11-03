package com.xin.demo.model;

/**
 * 懒加载：加载一个类时，其内部类不会同时被加载。一个类被加载，当且仅当其某个静态成员（静态域、静态方法等）或构造器被调用时发生
 *
 */
public class Outter {
    static {
        System.out.println("hello i'm outter");
    }
    static class Inner {
        static {
            System.out.println("hello i'm inner");
        }
        public void invoke(){
            System.out.println("执行方法");
        }
    }

    public static void main(String[] args) {
        new Inner();
    }
}
