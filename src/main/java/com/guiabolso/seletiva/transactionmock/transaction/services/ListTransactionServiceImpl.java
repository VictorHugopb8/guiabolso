package com.guiabolso.seletiva.transactionmock.transaction.services;

import com.guiabolso.seletiva.transactionmock.exceptions.InvalidUserIdException;
import com.guiabolso.seletiva.transactionmock.exceptions.RequestHasNoElementsException;
import com.guiabolso.seletiva.transactionmock.transaction.dto.RequestDTO;
import com.guiabolso.seletiva.transactionmock.transaction.dto.TransactionDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ListTransactionServiceImpl implements ListTransactionService {

    private final TransactionGeneratorService generatorService;

    @Override
    public List<TransactionDTO> list(List<RequestDTO> request) throws RequestHasNoElementsException, InvalidUserIdException {
        if (request.size() == 0) {
            throw new RequestHasNoElementsException();
        }
        for (RequestDTO requestDTO : request) {
            if (requestDTO.getUserId() < 1000 || requestDTO.getUserId() > 100000000) {
                throw new InvalidUserIdException();
            }
        }
        return generatorService.generate(request, (int) (Math.random() * 10 + 6));
    }
}
