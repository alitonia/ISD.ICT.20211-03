package entity.bike;

public class Bike {
    private String bikeCode;
    private String licensePlateNumber;
    private boolean available = true;
    private int stationId;

    public Bike() {

    }

    public Bike(String bikeCode, String licensePlateNumber, boolean available, int stationId) {
        this.bikeCode = bikeCode;
        this.licensePlateNumber = licensePlateNumber;
        this.available = available;
        this.stationId = stationId;
    }


    public String getBikeCode() {
        return bikeCode;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public boolean isAvailable() {
        return available;
    }

    public int getStationId() {
        return stationId;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }
}