package com.guiabolso.seletiva.transactionmock.transaction.services;

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
import static org.junit.jupiter.api.Assertions.*;

@Tag("service")
@ExtendWith(MockitoExtension.class)
@DisplayName("Valida serviço gerador de transação")
public class TransactionGeneratorServiceTest {

    @Mock
    private DescriptionGeneratorService descriptionGeneratorService;

    private TransactionGeneratorService transactionGeneratorService;

    @BeforeEach
    public void setUp() {
        this.transactionGeneratorService = new TransactionGeneratorServiceImpl(descriptionGeneratorService);
    }

    @Test
    @DisplayName("Deve gerar 100 transações")
    public void shouldGenerateTransactions() {
        List<RequestDTO> dtoList = new ArrayList<>();
        int trnNumPerMonth = 10;
        for (int num = 0; num < trnNumPerMonth; num++) {
            dtoList.add(createRequestDTO((long) trnNumPerMonth * 1000));
        }
        List<TransactionDTO> transactions = transactionGeneratorService.generate(dtoList, trnNumPerMonth);

        assertAll("transactions",
                () -> assertNotNull(transactions),
                () -> assertEquals(100, transactions.size())
        );
    }
}
