package com.camping.dev.service;

import com.camping.dev.mapper.SampleMapper;
import com.camping.dev.model.vo.SampleVO;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SampleServiceImpl implements SampleService {

    private SampleMapper sampleMapper;
    private final Logger logger = LoggerFactory.getLogger("SampleServiceImpl's log");

    @Override
    public SampleVO getSample(){

        logger.info("getSample called!");

        SampleVO sampleVO = sampleMapper.getSample("aaa");
        logger.info(sampleVO.getAaa());
        logger.info(sampleVO.getBbb());
        logger.info(sampleVO.getCcc());
        logger.info(sampleVO.getDdd());

        return null;

    }

}
