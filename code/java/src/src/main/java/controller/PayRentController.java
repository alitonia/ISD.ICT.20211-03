package controller;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PayRentController extends BaseController{
    boolean validateCardInfo(HashMap<String, String> info){
        return false;
    }

    boolean validateName(String name){
        if(name == null){
            return false;
        }
        String patternString = "^[a-zA-Z0-9\\s]*$";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    boolean validateCardNumber(String cardNumber){
        if(cardNumber == null){
            return false;
        }
        String[] tokens = cardNumber.split("_");
        if(tokens.length != 3) return false;

        String className = tokens[0];
        String patternString = "^[a-zA-Z0-9\\s]*$";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(className);
        if(!matcher.matches()) return false;

        String groupName =  tokens[1];
        patternString = "group[0-9]*$";
        pattern = Pattern.compile(patternString);
        matcher = pattern.matcher(groupName);
        if(!matcher.matches()) return false;

        String year =  tokens[2];
        patternString = "[0-9]{4}";
        pattern = Pattern.compile(patternString);
        matcher = pattern.matcher(year);
        if(!matcher.matches()) return false;

        return true;

    }

    boolean validateCardSecurityCode(String securityCode){
        if(securityCode == null){
            return false;
        }
        if(securityCode.length() != 3){
            return false;
        }
        String patternString = "[0-9]*$";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(securityCode);
        return matcher.matches();
    }

    boolean validateExpirationDate(String expirationDate){
        if(expirationDate == null){
            return false;
        }
        if(expirationDate.length() != 4){
            return false;
        }
        try {
            String month = expirationDate.substring(0, 2);
            int d = Integer.parseInt(month);
            if(d <= 0 || d > 12){
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        try {
            String year = expirationDate.substring(2, 4);
            int d = Integer.parseInt(year);
            if(d < (Calendar.getInstance().get(Calendar.YEAR)%100)){
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
