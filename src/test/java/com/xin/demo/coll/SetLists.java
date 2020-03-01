package com.xin.demo.coll;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

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
    @Test
    public void testMap(){
        HashMap<Integer, String> hashMap = new HashMap<Integer, String>() {
            {
                put(1,"apple");
                put(1,"banana");
                put(1,"peer");
            }
        };

    }
}
