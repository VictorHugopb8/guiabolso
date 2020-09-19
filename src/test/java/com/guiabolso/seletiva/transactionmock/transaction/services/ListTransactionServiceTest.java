package com.guiabolso.seletiva.transactionmock.transaction.services;

import com.guiabolso.seletiva.transactionmock.exceptions.InvalidUserIdException;
import com.guiabolso.seletiva.transactionmock.exceptions.RequestHasNoElementsException;
import com.guiabolso.seletiva.transactionmock.transaction.dto.RequestDTO;
import com.guiabolso.seletiva.transactionmock.transaction.dto.TransactionDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static com.guiabolso.seletiva.transactionmock.builders.RequestBuilder.createRequestDTO;
import static com.guiabolso.seletiva.transactionmock.builders.TransactionBuilder.createTransactionList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

@Tag("service")
@ExtendWith(MockitoExtension.class)
@DisplayName("Valida serviço de listagem de transações")
public class ListTransactionServiceTest {

    @Mock
    private TransactionGeneratorService transactionGeneratorService;

    private ListTransactionService listTransactionService;

    @BeforeEach
    public void setUp() {
        this.listTransactionService = new ListTransactionServiceImpl(transactionGeneratorService);
    }

    @Test
    @DisplayName("Deve retornar transações, em lista, com sucesso")
    public void shouldGenerateTransactions() throws InvalidUserIdException, RequestHasNoElementsException {

        when(transactionGeneratorService.generate(anyList(), anyInt())).thenReturn(createTransactionList(10));
        List<RequestDTO> dtoList = new ArrayList<>();
        for (int num = 0; num < 10; num++) {
            dtoList.add(createRequestDTO((long) (num + 1) * 1000 + 1));
        }
        List<TransactionDTO> transactions = listTransactionService.list(dtoList);

        assertAll("transactions",
                () -> assertNotNull(transactions),
                () -> assertTrue(transactions.size() > 0)
        );
    }
}
