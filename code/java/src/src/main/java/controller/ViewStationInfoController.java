package controller;

import entity.bike.*;
import entity.station.Station;
import entity.station.StationList;

import java.util.ArrayList;
import java.util.List;

public class ViewStationInfoController extends BaseController {


  /**
   * This class controls the flow of view station info use case in our EcoBike project.
   *
   * @author tungbt
   */

  private Station curStation;
  private List<Bike> lstBike;

  public ViewStationInfoController(Station curStation) {
    this.curStation = curStation;
    lstBike = this.curStation.getBikeList();
  }

  public Station getCurStation() {
    return curStation;
  }

  /**
   * This method looks for station in a list using station id.
   *
   * @param stationId id of station
   * @return station
   */
  public Station getStationById(final String stationId) {
    List<Station> lstStation = StationList.getStationListInstance().getStationList();

    for (Station station : lstStation) {
      if (station.getStationId().equals(stationId)) {
        return station;
      }
    }
    return null;
  }

  /**
   * This method looks for bike in a list using bike code.
   *
   * @param bikeCode code of bike
   * @return bike
   */
  public Bike getBikeByCode(final String bikeCode) {
    for (Bike bike : lstBike) {
      if (bikeCode.equals(bike.getBikeCode())) {
        return bike;
      }
    }
    return null;
  }

}
