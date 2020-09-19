package com.guiabolso.seletiva.transactionmock.transaction.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@Tag("service")
@ExtendWith(MockitoExtension.class)
@DisplayName("Valida serviço gerador de descrição de transação")
public class DescriptionGeneratorServiceTest {

    private DescriptionGeneratorService descriptionGeneratorService;

    @BeforeEach
    public void setUp() {
        this.descriptionGeneratorService = new DescriptionGeneratorServiceImpl();
    }

    @Test
    @DisplayName("Deve criar uma descrição aleatória")
    public void shouldGenerateDescription() {
        String description = descriptionGeneratorService.generate(10, false, "");

        assertAll("description",
                () -> assertNotNull(description),
                () -> assertTrue(description.length() >= 10 && description.length() <= 60)
        );
    }

}
