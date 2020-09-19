package com.guiabolso.seletiva.transactionmock.transaction.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {
    private String descricao;       //"string(10, 60)"
    private Long data;              //"long(timestamp)"
    private Integer valor;          //"integer(-9.999.999, 9.999.999)"
    private Boolean duplicated;     //"boolean"
}
