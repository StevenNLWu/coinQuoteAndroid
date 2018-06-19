package model;

import java.util.ArrayList;

public enum Ticker {
    INSTANCE;

    private ArrayList<aTicker> listOfTicker;
    public ArrayList<aTicker> getListOfTicker() {
        return listOfTicker;
    }

    // re-initialize the list
    public void resetList(int size) {
        this.listOfTicker = new ArrayList<aTicker>(size);
    }

    // pass the full list to here
    public void setFullList(ArrayList<aTicker> aList){
        this.listOfTicker = aList;
    }

    public void addATicker(aTicker aTicker)
    {
        this.listOfTicker.add(aTicker);

    }


}
