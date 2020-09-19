package com.guiabolso.seletiva.transactionmock.transaction.v1;

import com.guiabolso.seletiva.transactionmock.exceptions.InvalidUserIdException;
import com.guiabolso.seletiva.transactionmock.exceptions.RequestHasNoElementsException;
import com.guiabolso.seletiva.transactionmock.transaction.dto.RequestDTO;
import com.guiabolso.seletiva.transactionmock.transaction.dto.TransactionDTO;
import com.guiabolso.seletiva.transactionmock.transaction.services.ListTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/transactions")
public class TransactionController {

    private final ListTransactionService listTransactionService;

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TransactionDTO> list(@RequestBody @NonNull List<RequestDTO> request) throws RequestHasNoElementsException, InvalidUserIdException {
        return listTransactionService.list(request);
    }

}
