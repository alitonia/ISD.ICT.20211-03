package java.entity;

import entity.Rental;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RentalTest {
    private Rental rental;

    @BeforeEach
    void setUp() {
        rental = new Rental();
    }

    @ParameterizedTest
    @CsvSource
            ({
                    "1986-04-08 01:30, 1986-04-08 13:30, 200000",
                    "1986-04-08 01:30, 1986-04-08 13:29, 190000",
                    "1986-04-08 01:30, 1986-04-08 01:30, 80000",
                    "1986-04-08 01:30, 1986-04-08 13:44, 200000",
                    "1986-04-08 01:30, 1986-04-08 13:45, 202000",
                    "1986-04-08 01:30, 1986-04-08 13:45, 202000",
            })
    void validateRent(String startTime, String endTime, long amount) {
        long rtVal = rental.calculateRent(startTime, endTime);
        assertEquals(amount, rtVal);
    }

    @ParameterizedTest
    @CsvSource
            ({
                    "1986-04-08 01:30, 1986-04-08 13:30, 200000, 0",
                    "1986-04-08 01:30, 1986-04-08 13:30, 200001, 1",
                    "1986-04-08 01:30, 1986-04-08 13:30, 199999, 0",
            })
    void validateRefund(String startTime, String endTime, long paid, long amount) {
        long rtVal = rental.calculateRefund(startTime, endTime, paid);
        assertEquals(amount, rtVal);
    }
}
