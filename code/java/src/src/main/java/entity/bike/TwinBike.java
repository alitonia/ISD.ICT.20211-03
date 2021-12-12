package entity.bike;

public class TwinBike extends Bike{

  public TwinBike(String bikeCode, String licensePlateNumber, boolean available, int stationId) {
    super(bikeCode, licensePlateNumber, available, stationId);
    this.saddle = 2;
    this.pedal = 2;
    this.rearSeat = 1;
  }

  @Override
  public String getBikeType() {
    return "Twin Bike";
  }
}
