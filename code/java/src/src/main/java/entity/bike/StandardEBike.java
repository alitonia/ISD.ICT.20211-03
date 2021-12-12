package entity.bike;

public class StandardEBike extends StandardBike {

  private int battery;

  public StandardEBike(String bikeCode, String licensePlateNumber, boolean available,
      int stationId) {
    super(bikeCode, licensePlateNumber, available, stationId);
    this.battery = 100;
  }

  public StandardEBike(String bikeCode, String licensePlateNumber, boolean available,
      int stationId, int battery) {
    super(bikeCode, licensePlateNumber, available, stationId);
    this.battery = battery;
  }

  @Override
  public String getBikeType() {
    return "Standard Electric Bike";
  }
}
