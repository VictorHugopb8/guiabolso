package com.guiabolso.seletiva.transactionmock.builders;

import com.guiabolso.seletiva.transactionmock.transaction.dto.TransactionDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TransactionBuilder {

    public static List<TransactionDTO> createTransactionList(int listSize) {
        List<TransactionDTO> transactions = new ArrayList<>();
        for (int i = 0; i < listSize; i++) {
            transactions.add(createTransaction(i));
        }
        return transactions;
    }
    public static TransactionDTO createTransaction(int trnNum) {
        return TransactionDTO.builder()
                .valor(trnNum)
                .descricao("abcdef " + trnNum)
                .data(LocalDate.now().toEpochDay())
                .duplicated(false)
                .build();
    }

}
