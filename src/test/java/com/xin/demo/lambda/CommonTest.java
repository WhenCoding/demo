package com.xin.demo.lambda;

import com.xin.demo.model.Apple;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.ToIntBiFunction;

public class CommonTest {
    @Test
    public void test1(){
        Callable<Integer> callable = () -> 42;
        try {
            Integer call = callable.call();
            System.out.println(call);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    /**
     * 同个lambda可以不同的函数是接口
     */
    public void test2(){
        Comparator<Apple> comparator1 = (Apple a1,Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
        ToIntBiFunction<Apple,Apple> comparator2 = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
        BiFunction<Apple,Apple,Integer> comparator3 = ( a1, a2) -> a1.getWeight().compareTo(a2.getWeight());
    }
}
