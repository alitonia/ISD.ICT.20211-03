package controller;

import entity.station.Station;

import java.util.ArrayList;
import java.util.List;

/**
 * This class controls the flow of
 * search station use cases in our EcoBike project.
 */
public class SearchStationController {
    /**
     * get station by name.
     *
     * @param stationName Name of the station
     * @return list of found station
     */
    public List<Station> searchStation(String stationName, List<Station> lstStation) {


        List<Station> lstFoundStation = new ArrayList<>();
        for (Station station : lstStation) {
            if ((station.getName() != null && !station.getName().isEmpty()
                    && station.getName().toLowerCase().
                    contains(stationName.toLowerCase()))) {
                lstFoundStation.add(station);
            }
        }
        return lstFoundStation;
    }
}