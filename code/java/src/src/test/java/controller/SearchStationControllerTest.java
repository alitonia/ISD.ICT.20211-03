package controller;

import entity.station.Station;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class SearchStationControllerTest {
    private SearchStationController searchStationController;
    private List<Station> lstStation;

    @BeforeEach
    void setUp() {
        searchStationController = new SearchStationController();
        Station station1 = new Station("ST1234", "HUST", "Dai Co Viet", 15, 50);
        Station station2 = new Station("ST1235", "NEU", "Tran Dai Nghia", 10, 40);
        Station station3 = new Station("ST1236", "FTU", "Chua Lang", 7, 30);
        lstStation = new ArrayList<>();
        lstStation.add(station1);
        lstStation.add(station2);
        lstStation.add(station3);

    }


    @Test
    void searchStation() {
        // name contains "HUST"
        assertEquals(1, searchStationController.searchStation("HUST", lstStation).size());
        assertEquals("HUST", searchStationController.searchStation("HUST", lstStation).get(0).getName());

        // name contains "U"
        assertEquals(3, searchStationController.searchStation("U", lstStation).size());

        // name contains "BK"
        assertEquals(0, searchStationController.searchStation("BK", lstStation).size());

        // blank input
        assertEquals(3, searchStationController.searchStation("", lstStation).size());


    }
}
