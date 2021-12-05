package entity;

import entity.bike.Bike;
import entity.station.Station;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class StationTest {
    private Station station;

    @BeforeEach
    void setUp() {
        Bike bike1 = new Bike("1234", "29B1-0001", true, 0);
        Bike bike2 = new Bike("1235", "29B1-0002", true, 0);
        Bike bike3 = new Bike("1236", "29B1-0003", true, 0);

        List<Bike> bikeList = new ArrayList<>();
        bikeList.add(bike1);
        bikeList.add(bike2);
        bikeList.add(bike3);
        station = new Station("ST1234", "HUST", "Dai Co Viet", 15, 50, bikeList.size(), bikeList);
    }

    @Test
    void addBikeToStationTest1() throws Exception {
        int initialCapacity = station.getCapacity();
        station.addBike(new Bike("3113", "29B1-0001", true, 0));
        assertEquals(initialCapacity+1, station.getCapacity());
    }


    @Test
    void addBikeToStationTest2() {
        // check for exception when station is full
        int maxCapacity = station.getMaxCapacity();
        Exception exception = assertThrows(Exception.class, () -> {
            for (int i = station.getCapacity(); i < maxCapacity + 1; i++) {
                station.addBike(new Bike(String.valueOf(1234 + i), "29B1-0001", true, 0));
            }
        });
        String actualMessage = exception.getMessage();
        assertEquals("Station is full. Cannot add bike", actualMessage);
    }

    @Test
    void removeBikeTest() throws Exception {
        int initialCapacity = station.getCapacity();
        station.removeBike(station.getBikeList().get(0).getBikeCode());

        assertEquals(initialCapacity-1, station.getCapacity());
    }


    @Test
    void removeBikeTest2() throws Exception {
        // check for exception when station has no bikes left to remove
        Bike firstBike = station.getBikeList().get(0);
        station.removeBike(firstBike.getBikeCode());

        Exception exception = assertThrows(Exception.class, () -> {
            station.removeBike(firstBike.getBikeCode());
        });
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains("Bike not found in station"));
    }


}