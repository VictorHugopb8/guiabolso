package com.guiabolso.seletiva.transactionmock.transaction.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestDTO {
    @NonNull
    private Long userId;
    @NonNull
    private Integer year;
    @NonNull
    private Integer month;
}
