package model;

import java.util.ArrayList;

public enum ListOfCoinList {
    INSTANCE;

    private ArrayList<CoinList> listOfListing;
    public ArrayList<CoinList> getListOfListing() {
        return listOfListing;
    }

    // re-initialize the list
    public void resetList() {

        this.listOfListing = new ArrayList<CoinList>();
    }

    // pass the full list to here
    public void setFullList(ArrayList<CoinList> aList){
        this.listOfListing = aList;
    }

    public void addACoin(CoinList aCoin)
    {
        if(this.listOfListing == null)
            this.resetList();

        this.listOfListing.add(aCoin);

    }


}
