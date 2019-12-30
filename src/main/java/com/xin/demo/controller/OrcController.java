package com.xin.demo.controller;

import com.xin.demo.model.AbstractOCR;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author sunluomeng
 * @date 2019/12/30 16:46
 */
@RestController
@RequestMapping("/ocr")
public class OrcController extends AbstractOCR {

    @RequestMapping(value = "baidu", method = RequestMethod.POST)
    String queryEntBindRelation(@RequestParam("file") MultipartFile file) {
        return super.textRecognition(file);
    }

    @Override
    public String getServiceProvider() {
        return "baidu";
    }
}
