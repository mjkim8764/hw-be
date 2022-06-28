package com.camping.dev.controller;

import com.camping.dev.model.vo.SampleVO;
import com.camping.dev.service.SampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/sample")
public class SampleController {

    @Autowired
    private SampleService sampleService;

    private final Logger logger = LoggerFactory.getLogger("SampleController's Log");

    @PostMapping("/")
    public @ResponseBody SampleVO sampleTest() {

        logger.info("SampleController called!");
        return sampleService.getSample();

    }
}
