package entity.bike;

public class TwinEBike extends TwinBike {

  private int battery;

  public TwinEBike(String bikeCode, String licensePlateNumber, boolean available, int stationId) {
    super(bikeCode, licensePlateNumber, available, stationId);
    this.battery = 100;
  }

  public TwinEBike(String bikeCode, String licensePlateNumber, boolean available, int stationId,
      int battery) {
    super(bikeCode, licensePlateNumber, available, stationId);
    this.battery = battery;
  }

  @Override
  public String getBikeType() {
    return "Twin Electric Bike";
  }
}
