package com.xin.demo.model;

/**
 * 最优秀的的单例模式，既使用了懒加载（加载一个类时，其内部类不会同时被加载。一个类被加载，当且仅当其某个静态成员（静态域、构造器、静态方法等）被调用时发生），
 * 又保证了线程安全，而且减少了sync的开销
 */
public class SingletonTwo {
    private static class SingletonTowHolder{
        private static SingletonTwo INSTANCE =  new SingletonTwo();
    }
    public static final SingletonTwo getInstance(){
        /**
         * Java规范里确实规定了外部类可以访问内部类的private/protected变量，
         * 内部类就相当于一个外部类的成员变量，就像访问自己的private/protected变量一样.........
         * 实际上，编译器实现的时候是这样的：
         * Outer类和Inner类不再是嵌套结构，而是变为一个包中的两个类，
         * 然后，对于private变量的访问，编译器会生成一个accessor函数.......
         */
        return SingletonTowHolder.INSTANCE;
    }
}
