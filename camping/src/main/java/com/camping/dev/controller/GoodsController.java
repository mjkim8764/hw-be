package com.camping.dev.controller;

import com.camping.dev.model.vo.GoodsDetailVO;
import com.camping.dev.service.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/products")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    private final Logger logger = LoggerFactory.getLogger("GoodsController's Log");

    @GetMapping("/{id}")
    public @ResponseBody
    GoodsDetailVO getGoodsDetail(@PathVariable("id") int id) {
        return goodsService.getGoodsDetail(id);
    }

}
