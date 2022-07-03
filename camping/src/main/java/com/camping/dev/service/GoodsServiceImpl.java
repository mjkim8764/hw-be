package com.camping.dev.service;

import com.camping.dev.mapper.GoodsMapper;
import com.camping.dev.model.vo.GoodsSampleVO;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GoodsServiceImpl implements GoodsService{

    private GoodsMapper goodsMapper;
    private final Logger logger = LoggerFactory.getLogger("GoodsServiceImpl's log");

    @Override
    public List<GoodsSampleVO> getSampleList(){

        logger.info("getSampleList called!");

        // read main_data.csv

        return goodsMapper.getSampleList();

    }

}
