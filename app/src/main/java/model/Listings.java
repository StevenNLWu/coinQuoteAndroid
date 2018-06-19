package model;

import java.util.ArrayList;

public enum Listings {
    INSTANCE;

    private ArrayList<aListings> listOfListing;
    public ArrayList<aListings> getListOfListing() {
        return listOfListing;
    }

    // re-initialize the list
    public void resetList(int size) {

        this.listOfListing = new ArrayList<aListings>(size);
    }

    // pass the full list to here
    public void setFullList(ArrayList<aListings> aList){
        this.listOfListing = aList;
    }

    public void addACoin(aListings aCoin)
    {
        this.listOfListing.add(aCoin);
    }


}
