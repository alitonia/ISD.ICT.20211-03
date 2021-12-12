package entity.bike;

public class StandardBike extends Bike {

  public StandardBike(String bikeCode, String licensePlateNumber, boolean available,
      int stationId) {
    super(bikeCode, licensePlateNumber, available, stationId);
    this.saddle = 1;
    this.pedal = 1;
    this.rearSeat = 1;
  }

  @Override
  public String getBikeType() {
    return "Standard Bike";
  }

}
