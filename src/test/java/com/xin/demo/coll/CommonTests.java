package com.xin.demo.coll;

import com.xin.demo.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

/**
 * @auther xgs
 * @date 2020/1/16 1:30 下午
 */
@Slf4j
public class CommonTests {
    @Test
    public void testList(){
        List peoples = new ArrayList<Person>(){
            {
                add(new Person().setName("xiaoming").setAddress("henan"));
                add(new Person().setName("xiaoming").setAddress("wuzhi"));
                add(new Person().setName("xiaoming").setAddress("xinyang"));
                add(new Person().setName("xiaohong").setAddress("xinyang"));
            }
        };
        Map<String,String> map = (Map<String, String>) peoples.stream().collect(toMap(Person::getName,
                Person::getAddress,
                (s, a) -> s + ", " + a));
        map.forEach((k,v)-> log.info(v));
    }
}
