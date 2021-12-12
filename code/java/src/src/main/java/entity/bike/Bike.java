package entity.bike;

public class Bike {

  protected String bikeCode;
  protected String licensePlateNumber;
  protected boolean available = true;
  protected int stationId;
  protected int saddle;
  protected int pedal;
  protected int rearSeat;

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

  public int getSaddle() {
    return saddle;
  }

  public int getPedal() {
    return pedal;
  }

  public int getRearSeat() {
    return rearSeat;
  }

  public String getBikeType() {
    return null;
  }
}