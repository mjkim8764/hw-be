package com.camping.dev.service;

import com.camping.dev.mapper.GoodsMapper;
import com.camping.dev.mapper.MemberMapper;
import com.camping.dev.mapper.RentalMapper;
import com.camping.dev.mapper.ReviewMapper;
import com.camping.dev.model.vo.*;
import lombok.AllArgsConstructor;
import org.apache.ibatis.session.SqlSessionException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
@AllArgsConstructor
public class RentalServiceImpl implements RentalService {

    private RentalMapper rentalMapper;
    private GoodsMapper goodsMapper;
    private ReviewMapper reviewMapper;
    private MemberMapper memberMapper;
    private final Logger logger = LoggerFactory.getLogger("RentalServiceImpl's log");


    // 대여 요청
    @Override
    public RentalResponseVO sendRentalRequest(RentalRequestVO rentalRequestVO) {

        RentalResponseVO resultVO = new RentalResponseVO();

        try {

            if(rentalMapper.countingRentInfoByEmail(rentalRequestVO.getId(),
                                                    rentalRequestVO.getEmail()) == 0) {

                rentalRequestVO.setLenderEmail(goodsMapper.getLenderEmail(rentalRequestVO.getId()));
                rentalMapper.insertRentalRequest(rentalRequestVO);
                resultVO.setStatus("6000");

            } else {

                resultVO.setStatus("6002");    // 6002 : 중복 대여 요청

            }

        } catch (SqlSessionException e) {
            e.printStackTrace();
            resultVO.setStatus("6001");
        } catch (Exception e) {
            e.printStackTrace();
            resultVO.setStatus("6001");
        }

        return resultVO;

    }


    // 대여 수락
    @Override
    public RentalResponseVO sendRentalAccept(RentalAcceptVO rentalAcceptVO) {

        RentalResponseVO resultVO = new RentalResponseVO();

        try {

            rentalMapper.acceptRental(rentalAcceptVO);
            resultVO.setStatus("6000");

        } catch (SqlSessionException e) {
            e.printStackTrace();
            resultVO.setStatus("6001");
        } catch (Exception e) {
            e.printStackTrace();
            resultVO.setStatus("6001");
        }

        return resultVO;

    }


    // 대여 거절
    @Override
    public RentalResponseVO sendRentalReject(RentalRejectVO rentalRejectVO) {

        RentalResponseVO resultVO = new RentalResponseVO();

        try {

            rentalMapper.rejectRental(rentalRejectVO);
            resultVO.setStatus("6000");

        } catch (SqlSessionException e) {
            e.printStackTrace();
            resultVO.setStatus("6001");
        } catch (Exception e) {
            e.printStackTrace();
            resultVO.setStatus("6001");
        }

        return resultVO;

    }


    // 대여 반환
    @Override
    public RentalResponseVO sendRentalReturn(RentalReturnVO rentalReturnVO) {

        RentalResponseVO resultVO = new RentalResponseVO();
        HttpURLConnection conn = null;

        try {

            // 상품반환
            String lenderEmail = rentalMapper.selectLenderEmail(rentalReturnVO);
            logger.info(lenderEmail);
            rentalMapper.returnRental(rentalReturnVO);
            resultVO.setStatus("6000");


            /**
             * 리뷰메세지를 리뷰테이블에 적재
             * 리뷰테이블에 들어가는 평점은 ML 모델 API 에 리뷰메세지를 넣어서 추출한 값
             */

            /*
            URL url = new URL("http://54.180.64.59:5000/predict");
            conn = (HttpURLConnection)url.openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("text", rentalReturnVO.getReview());

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;

            while( (line = br.readLine()) != null) {
                sb.append(line);
            }

            JSONObject obj = new JSONObject(sb.toString());

            */


            reviewMapper.insertReview(rentalReturnVO.getId()
                                    , rentalReturnVO.getEmail()
                                    , rentalReturnVO.getGrade()
                                    , rentalReturnVO.getReview());

            // 평점 수정
            CalculateNewGradeVO calculateNewGradeVO = memberMapper.selectTradedAndGrade(lenderEmail);
            int traded = calculateNewGradeVO.getTraded();
            double userGrade = calculateNewGradeVO.getGrade();
            double newGrade = ( (traded * userGrade) + rentalReturnVO.getGrade() ) / (traded + 1);
            newGrade = Math.round(newGrade * 10) / 10.0;
            memberMapper.updateTradedAndGrade(lenderEmail, traded + 1, newGrade);

        } catch (SqlSessionException e) {
            e.printStackTrace();
            resultVO.setStatus("6001");
        } catch (Exception e) {
            e.printStackTrace();
            resultVO.setStatus("6001");
        }

        return resultVO;

    }

}
