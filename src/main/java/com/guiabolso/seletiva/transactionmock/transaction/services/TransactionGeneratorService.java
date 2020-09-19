package com.guiabolso.seletiva.transactionmock.transaction.services;

import com.guiabolso.seletiva.transactionmock.transaction.dto.RequestDTO;
import com.guiabolso.seletiva.transactionmock.transaction.dto.TransactionDTO;

import java.util.List;

@FunctionalInterface
public interface TransactionGeneratorService {
    List<TransactionDTO> generate(List<RequestDTO> request, int transactionsQtd);
}
