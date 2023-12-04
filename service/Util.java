package service;

public class Util {
    public static String convertNullToBusinessLanguage(String value){
        if(value==null){
            return "Kein Wert vorhanden.";
        }
        return value;
    }
    public static String convertBooleanToBusinessLanguage(boolean value){
        if(value){
            return "Abonniert";
        } else{
            return "Kein Abonnent";
        }
    }
}
