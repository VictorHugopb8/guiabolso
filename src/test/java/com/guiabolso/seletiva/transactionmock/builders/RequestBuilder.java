package com.guiabolso.seletiva.transactionmock.builders;

import com.guiabolso.seletiva.transactionmock.transaction.dto.RequestDTO;

import java.util.Random;

public class RequestBuilder {

    public static RequestDTO createRequestDTO(Long userId) {
        int yearRndm = new Random().nextInt(2020) + 1;
        int genRandom = (int) (Math.random() * 10);
        return RequestDTO.builder()
                .userId(userId)
                .month(genRandom == 1 ? 1 : genRandom + 2)
                .year(yearRndm)
                .build();
    }

}
