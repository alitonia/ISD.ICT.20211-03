package entity.station;


import java.util.ArrayList;
import java.util.List;

public class StationList {
    private List<Station> lstStation;

    public StationList() {
        this.lstStation = new ArrayList<>();
    }

    public StationList(List<Station> lstStation) {
        this.lstStation = lstStation;
    }

}