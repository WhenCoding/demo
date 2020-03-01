package com.xin.demo.strings;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @auther xgs
 * @date 2020/1/14 3:40 下午
 */

public class StringsTests {
    @Test
    public void test1(){
        String indices = "beta_yqms_%s_%s";
        System.out.println(String.format(indices,"20200114","web"));;
    }
    @Test
    public void test2(){
        String keywords = "北京 河南 安徽";
        System.out.println(String.format(keywords.replace(" ",",")));
    }
    @Test
    public void test3(){
        String keywords = "北京 河南 安徽";
        String regEx = "[' ']+"; // 一个或多个空格
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(keywords);
        System.out.println(m.replaceAll(",").trim());
    }
    @Test
    public void test4(){
        String keywords = "北京 河南 安徽";
        Pattern p = Pattern.compile("\\s+");
        Matcher m = p.matcher(keywords);
        String replaceAll = m.replaceAll(",");
        System.out.println(replaceAll);
    }
    @Test
    public void test5(){
        // ip匹配
        String keywords = "123.123.123.423";
        Pattern pattern = Pattern.compile("(\\d{1,3}\\.){3}(\\d{1,3})");
        Matcher m = pattern.matcher(keywords);
        System.out.println(m.matches());

    }
    @Test
    public void test6(){
        System.exit(-1);
    }
}
