package controller;

import entity.bike.Bike;

/**
 * This class controls the flow of the view bike info use case in this project
 *
 * @author tungbt
 */
public class ViewBikeInfoController extends BaseController {

  private Bike bike;

  public ViewBikeInfoController(Bike bike) {
    this.bike = bike;
  }


  public int getBikeSaddle() {
    return bike.getSaddle();
  }

  public int getBikePedal() {
    return bike.getPedal();
  }

  public int getBikeRearSeat() {
    return bike.getRearSeat();
  }

  public String getBikeType() {
    return bike.getBikeType();
  }

  public String getBikeCode() {
    return bike.getBikeCode();
  }

  public String getLicensePlateNumber() {
    return bike.getLicensePlateNumber();
  }

  public int getStationId() {
    return bike.getStationId();
  }


}
