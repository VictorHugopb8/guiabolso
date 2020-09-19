package com.guiabolso.seletiva.transactionmock.transaction.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RequestDTO {
    @NonNull
    private Long userId;
    @NonNull
    private Integer year;
    @NonNull
    private Integer month;
}
