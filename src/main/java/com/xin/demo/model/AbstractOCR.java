package com.xin.demo.model;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.io.FileUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

/**
 * @author sunluomeng
 * @date 2019/12/30 16:47
 */
public abstract class AbstractOCR {

    @Value("${baiduOcrApi}")
    private String baiduApi;

    /**
     * 获取文件Base64
     *
     * @param fileInputStream 文件流
     * @return
     */
    public String getBase64(InputStream fileInputStream) {
        return Base64.encode(fileInputStream);
    }

    public String requestOcr(String encode) {
        HashMap<String, Object> requestParmMap = new HashMap<>();
        requestParmMap.put("image", encode);
        String result = HttpUtil.createPost(baiduApi).form(requestParmMap).execute().body();
        return result;
    }

    /**
     * 处理图片
     *
     * @param file
     */
    public InputStream processingPictures(MultipartFile file) {
        try {
            return file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 开始识别
     */
    public String textRecognition(MultipartFile file) {
        /**
         * 处理图片
         */
        InputStream inputStream = this.processingPictures(file);
        String base64 = this.getBase64(inputStream);
        String ocr = null;
        if (getServiceProvider().equalsIgnoreCase("baidu")) {
            ocr = this.requestOcr(base64);
        }
        return doOcr(ocr);
    }

    /**
     * 处理结果
     *
     * @param result
     */
    public String doOcr(String result) {
        StringBuffer stringBuffer = new StringBuffer("识别结果:\n");
        JSONObject jsonObject = JSONObject.parseObject(result);
        JSONArray wordsResult = JSONArray.parseArray(jsonObject.get("words_result").toString());
        wordsResult.forEach(wr -> {
//            System.out.println(JSONObject.parseObject(wr.toString()).get("words").toString());
            stringBuffer.append(JSONObject.parseObject(wr.toString()).get("words").toString().concat("\r\n"));
        });
        return stringBuffer.toString();
    }


    public abstract String getServiceProvider();
}
