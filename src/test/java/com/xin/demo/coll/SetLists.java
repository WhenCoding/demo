package com.xin.demo.coll;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SetLists {
    @Test
    public void test1(){
        List<String> stringList = Collections.emptyList();
        stringList.add("小明");
    }
    @Test
    public void test2(){
        List<String> stringList = Arrays.asList("1", "2");

    }
}
