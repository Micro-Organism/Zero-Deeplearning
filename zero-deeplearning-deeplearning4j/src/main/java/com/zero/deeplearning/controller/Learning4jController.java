package com.zero.deeplearning.controller;

import com.zero.deeplearning.service.PredictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class Learning4jController {

    @Autowired
    PredictService predictService;


    @PostMapping("/predict-with-black-background")
    public int predictWithBlackBackground(@RequestParam("file") MultipartFile file) throws Exception {
        // 训练模型的时候，用的数字是白字黑底，
        // 因此如果上传白字黑底的图片，可以直接拿去识别，而无需反色处理
        return predictService.predict(file, false);
    }

    @PostMapping("/predict-with-white-background")
    public int predictWithWhiteBackground(@RequestParam("file") MultipartFile file) throws Exception {
        // 训练模型的时候，用的数字是白字黑底，
        // 因此如果上传黑字白底的图片，就需要做反色处理，
        // 反色之后就是白字黑底了，可以拿去识别
        return predictService.predict(file, true);
    }

}