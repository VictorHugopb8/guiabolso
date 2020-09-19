package com.guiabolso.seletiva.transactionmock.transaction.services;

@FunctionalInterface
public interface DescriptionGeneratorService {

    String generate(int transactionsQtd, boolean isDuplication, String duplicatedDescription);

}
