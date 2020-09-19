package com.guiabolso.seletiva.transactionmock.transaction.services;

import com.guiabolso.seletiva.transactionmock.exceptions.InvalidUserIdException;
import com.guiabolso.seletiva.transactionmock.exceptions.RequestHasNoElementsException;
import com.guiabolso.seletiva.transactionmock.transaction.dto.RequestDTO;
import com.guiabolso.seletiva.transactionmock.transaction.dto.TransactionDTO;

import java.util.List;

@FunctionalInterface
public interface ListTransactionService {
    List<TransactionDTO> list(List<RequestDTO> request) throws RequestHasNoElementsException, InvalidUserIdException;
}
