package com.xin.demo.util;


import cn.hutool.core.codec.Base64;
import cn.hutool.core.io.FileUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

/**
 * @auther xgs
 * @date 2019/12/29 9:07 下午
 */

@Slf4j
public class UtilTests {
    /**
     * 百度ocr文字识别api，每天免费使用500次
     */
    @Test
    public void test1() {
        try (FileInputStream ins = new FileInputStream(new File("/Users/xin/Desktop/2.4.png"))
        ) {
            String encode = Base64.encode(ins);
            log.info(encode);
        } catch (FileNotFoundException fnex) {
            fnex.printStackTrace();
        } catch (IOException ioex) {
            ioex.printStackTrace();
        }
    }

    /**
     * 分析结果
     */
    @Test
    public void test2(){
        String result =  "{\n" +
                "    \"log_id\": 4191987840223293757,\n" +
                "    \"paragraphs_result\": [\n" +
                "        {\n" +
                "            \"words_result_idx\": [\n" +
                "                0\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"words_result_idx\": [\n" +
                "                1\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"words_result_idx\": [\n" +
                "                2\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"words_result_idx\": [\n" +
                "                3\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"words_result_idx\": [\n" +
                "                4\n" +
                "            ]\n" +
                "        }\n" +
                "    ],\n" +
                "    \"paragraphs_result_num\": 5,\n" +
                "    \"words_result_num\": 5,\n" +
                "    \"words_result\": [\n" +
                "        {\n" +
                "            \"words\": \"os游离肾脏\",\n" +
                "            \"location\": {\n" +
                "                \"width\": 422,\n" +
                "                \"top\": 40,\n" +
                "                \"left\": 52,\n" +
                "                \"height\": 46\n" +
                "            },\n" +
                "            \"probability\": {\n" +
                "                \"variance\": 0.050881,\n" +
                "                \"average\": 0.826912,\n" +
                "                \"min\": 0.452613\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"words\": \"游离肾上极\",\n" +
                "            \"location\": {\n" +
                "                \"width\": 249,\n" +
                "                \"top\": 252,\n" +
                "                \"left\": 105,\n" +
                "                \"height\": 48\n" +
                "            },\n" +
                "            \"probability\": {\n" +
                "                \"variance\": 0.0,\n" +
                "                \"average\": 0.999897,\n" +
                "                \"min\": 0.999677\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"words\": \"②游离肾下极\",\n" +
                "            \"location\": {\n" +
                "                \"width\": 254,\n" +
                "                \"top\": 373,\n" +
                "                \"left\": 100,\n" +
                "                \"height\": 49\n" +
                "            },\n" +
                "            \"probability\": {\n" +
                "                \"variance\": 0.000741,\n" +
                "                \"average\": 0.987402,\n" +
                "                \"min\": 0.926548\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"words\": \"3游离肾外侧\",\n" +
                "            \"location\": {\n" +
                "                \"width\": 251,\n" +
                "                \"top\": 499,\n" +
                "                \"left\": 103,\n" +
                "                \"height\": 48\n" +
                "            },\n" +
                "            \"probability\": {\n" +
                "                \"variance\": 0.017355,\n" +
                "                \"average\": 0.940038,\n" +
                "                \"min\": 0.645489\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"words\": \"④肾脏已完全游离,结束操作\",\n" +
                "            \"location\": {\n" +
                "                \"width\": 558,\n" +
                "                \"top\": 630,\n" +
                "                \"left\": 99,\n" +
                "                \"height\": 49\n" +
                "            },\n" +
                "            \"probability\": {\n" +
                "                \"variance\": 0.001465,\n" +
                "                \"average\": 0.987315,\n" +
                "                \"min\": 0.854934\n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        JSONObject jsonObject = JSONObject.parseObject(result);
        JSONArray wordsResult = JSONArray.parseArray(jsonObject.get("words_result").toString());
        wordsResult.forEach(wr -> {
            System.out.println(JSONObject.parseObject(wr.toString()).get("words").toString());
        });
    }
    @Test
    public void  testAll(){
        String encode = "";
        try (FileInputStream ins = new FileInputStream(new File("/Users/xin/Desktop/6.0.png"))
        ) {
            encode = Base64.encode(ins);
        } catch (FileNotFoundException fnex) {
            fnex.printStackTrace();
        } catch (IOException ioex) {
            ioex.printStackTrace();
        }
        // 调用api
        HashMap<String, Object> requestParmMap = new HashMap<>();
        requestParmMap.put("image",encode);
        String result = HttpUtil.createPost("https://aip.baidubce.com/rest/2.0/ocr/v1/accurate?access_token=24.3fd052ee8829d5defa03c79c2c3de5ee.2592000.1580216387.282335-18135095").form(requestParmMap).execute().body();
        JSONObject jsonObject = JSONObject.parseObject(result);
        JSONArray wordsResult = JSONArray.parseArray(jsonObject.get("words_result").toString());
        wordsResult.forEach(wr -> {
//            System.out.println(JSONObject.parseObject(wr.toString()).get("words").toString());
            FileUtil.appendString(JSONObject.parseObject(wr.toString()).get("words").toString().concat("\r\n"),"/Users/xin/Desktop/out.text","utf-8");
        });
        FileUtil.appendString("\r\n","/Users/xin/Desktop/out.text","utf-8");
    }
}
