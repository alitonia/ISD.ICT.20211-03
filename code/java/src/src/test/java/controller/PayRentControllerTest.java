package controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PayRentControllerTest {
    private PayRentController payRentController;
    @BeforeEach
    void setUp() {
        payRentController = new PayRentController();
    }

    @ParameterizedTest
    @CsvSource
            ({
                    "TRINH THU HAI, true",
                    "TRINH HAI, true",
                    "Group 3, true",
                    "!@HAI, false",
                    ", false",
            })
    void validateName(String name, boolean expected) {
        boolean isValid = payRentController.validateName(name);
        assertEquals(expected, isValid);
    }

    @ParameterizedTest
    @CsvSource
            ({
                    "ict_group3_2021, true",
                    "ict group03 2021, false",
                    "ict_groupXYZ_2021, false",
                    "ict_group05_abcd, false",
                    ", false",
            })
    void validateCardNumber(String cardNumber, boolean expected) {
        boolean isValid = payRentController.validateCardNumber(cardNumber);
        assertEquals(expected, isValid);
    }

    @ParameterizedTest
    @CsvSource
            ({
                    "123, true",
                    "1234, false",
                    "12, false",
                    "1ab, false",
                    ", false",
            })
    void validateCardSecurityCode(String securityCode, boolean expected) {
        boolean isValid = payRentController.validateCardSecurityCode(securityCode);
        assertEquals(expected, isValid);
    }

    @ParameterizedTest
    @CsvSource
            ({
                    "1125, true",
                    "1/25, false",
                    "112025, false",
                    "1325, false",
                    ", false",
            })
    void validateExpirationDate(String expirationDate, boolean expected) {
        boolean isValid = payRentController.validateExpirationDate(expirationDate);
        assertEquals(expected, isValid);
    }
}