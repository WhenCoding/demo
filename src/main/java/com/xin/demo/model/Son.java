package com.xin.demo.model;

/**
 * 父类和子类的初始化顺序
 * 父类静态变量
 * 父类静态代码块
 * 子类静态变量
 * 子类静态代码块
 * 父类普通变量
 * 父类普通代码块
 * 父类构造函数
 * 子类普通变量
 * 子类普通代码块
 * 子类构造函数
 * 答案：：b d a c
 */
class Father {
    public Father(){
        System.out.println("a");
    }
    static {
        System.out.println("b");
    }
}

public class Son extends Father {
    public Son() {
        System.out.println("c");
    }
    static{
        System.out.println("d");
    }
    public static void main (String[] args){
        new Son();
    }
}
