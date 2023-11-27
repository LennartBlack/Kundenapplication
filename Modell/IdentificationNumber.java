package Modell;

import java.util.ArrayList;
abstract class IdentificationNumber {
    private static ArrayList<Integer> idList = new ArrayList<>();


    public Integer getNewID(){
    idList.add(idList.size());
     return idList.get(idList.size() - 1);
    }

}
