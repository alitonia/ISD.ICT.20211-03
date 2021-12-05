package controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RentBikeControllerTest {
    private RentBikeController rentBikeController;
    @BeforeEach
    void setUp() {
        rentBikeController = new RentBikeController();
    }

    @ParameterizedTest
    @CsvSource({
            "123456, true",
            "abc123, false",
            "123, false",
            "1234567, false",
            ", false",
    })
    void validateBikeBarCode(String barcode, boolean expected) {
        boolean isValid = rentBikeController.validateBikeBarCode(barcode);
        assertEquals(expected, isValid);
    }
}