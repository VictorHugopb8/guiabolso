package com.guiabolso.seletiva.transactionmock.transaction.services;

import com.guiabolso.seletiva.transactionmock.transaction.dto.RequestDTO;
import com.guiabolso.seletiva.transactionmock.transaction.dto.TransactionDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class TransactionGeneratorServiceImpl implements TransactionGeneratorService {

    private final DescriptionGeneratorService descriptionGeneratorService;

    @Override
    public List<TransactionDTO> generate(List<RequestDTO> request, int transactionsQtd) {
        List<RequestDTO> requestTemp = new ArrayList<>(request);
        List<TransactionDTO> transactions = new ArrayList<>();

        if (request.size() >= 12) {
            request.forEach(data -> {
                int freq = (int) requestTemp.stream().filter(data2 -> data2.getYear().equals(data.getYear())).count();
                int trnValue = (int) (Math.random() * 10000);

                if (freq >= 12) {
                    int dayOfMonth = getAleatoryDayOfMonth(data.getMonth());
                    String duplicatedDescriptionTrn = "";
                    for (int num = 0; num < transactionsQtd; num++) {
                        boolean isDuplication = (num % 3 == 0 && num != 0);

                        // To generate the description that will be replied to anothers duplicated transactions
                        if (num == 3) {
                            duplicatedDescriptionTrn = descriptionGeneratorService
                                    .generate(transactionsQtd, false, "");
                        }
                        transactions.add(TransactionDTO.builder()
                                .data(LocalDate.of(data.getYear(), data.getMonth(), isDuplication
                                        ? dayOfMonth
                                        : getAleatoryDayOfMonth(data.getMonth())
                                ).toEpochDay())
                                .duplicated(num == 3)
                                .valor(isDuplication ? trnValue : trnValue * (num + 1))
                                .descricao(descriptionGeneratorService
                                        .generate(transactionsQtd, isDuplication, duplicatedDescriptionTrn))
                                .build()
                        );
                    }
                } else {
                    for (int num = 0; num < transactionsQtd; num++) {
                        transactions.add(buildTransaction(data, trnValue, num, transactionsQtd));
                    }
                }
            });
        } else {
            request.forEach(data -> {
                int trnValue = (int) (Math.random() * 100 + (Math.random() * 10));
                for (int num = 0; num < transactionsQtd; num++) {
                    transactions.add(buildTransaction(data, trnValue, num, transactionsQtd));
                }
            });
        }

        return transactions;
    }

    private TransactionDTO buildTransaction(RequestDTO data, int trnValue, int num, int transactionsQtd) {
        return TransactionDTO.builder()
            .data(LocalDate.of(data.getYear(), data.getMonth(), getAleatoryDayOfMonth(data.getMonth()))
                    .toEpochDay())
            .duplicated(false)
            .valor(trnValue * (num + 1))
            .descricao(descriptionGeneratorService
                    .generate(transactionsQtd, false, ""))
            .build();
    }

    private int getAleatoryDayOfMonth(int month) {
        if (month == 2) {
            return new Random().nextInt(28) + 1;
        }
        return new Random().nextInt(30) + 1;
    }
}
