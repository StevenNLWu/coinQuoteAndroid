package model;

import java.util.ArrayList;

public enum Listings {
    INSTANCE;

    private ArrayList<aListings> listOfListing;
    public ArrayList<aListings> getListOfListing() {
        return listOfListing;
    }

    // re-initialize the list
    public void resetList() {

        this.listOfListing = new ArrayList<aListings>();
    }

    // pass the full list to here
    public void setFullList(ArrayList<aListings> aList){
        this.listOfListing = aList;
    }

    public void addACoin(aListings aCoin)
    {
        if(this.listOfListing == null)
            this.resetList();

        this.listOfListing.add(aCoin);

    }


}
