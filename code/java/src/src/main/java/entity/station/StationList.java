package entity.station;


import java.util.ArrayList;
import java.util.List;

import entity.station.Station;

public class StationList {

  private List<Station> lstStation;
  private static StationList StationListInstance;


  public StationList() {
    this.lstStation = new ArrayList<>();
  }

  public StationList(List<Station> lstStation) {
    this.lstStation = lstStation;
  }

  public void addStation(Station station) {

  }

  public static StationList getStationListInstance() {
    if (StationListInstance == null) {
      StationListInstance = new StationList();
    }
    return StationListInstance;
  }

  public List<Station> getStationList() {
    return lstStation;
  }


}
