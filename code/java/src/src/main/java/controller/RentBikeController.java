package controller;

import java.util.Objects;

public class RentBikeController extends BaseController{
    boolean validateBikeBarCode(String barcode){
        if (barcode == null) {
            return false;
        }
        if(barcode.length()!=6){
            return false;
        }
        try {
            barcode = barcode.trim();
            long d = Long.parseLong(barcode);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
