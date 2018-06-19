package model;

import org.json.JSONException;
import org.json.JSONObject;

public class aTicker {


    private final long id;
    private final String name;
    private final String symbol;
    private final String websiteSlug;
    private final int rank;
    private final double circulating_supply;
    private final double total_supply;
    private final String max_supply;
    private final JSONObject quotes;
    //private HashMap<String, aQuotes> quotes;
    private final long last_updated;

    public aTicker(JSONObject object) throws JSONException {

        this.id= object.getLong("id");
        this.name= object.getString("name");
        this.symbol= object.getString("symbol");
        this.websiteSlug= object.getString("website_slug");
        this.rank= object.getInt("rank");
        this.circulating_supply= object.getDouble("circulating_supply");
        this.total_supply= object.getDouble("total_supply");
        this.max_supply =object.getString("max_supply");

        this.quotes  =object.getJSONObject("quotes");
        //aQuotes test =  new aQuotes(object.getJSONObject("quotes"));
        //this.quotes = new HashMap<String, aQuotes>().put(object.getJSONObject("quotes").keys().next(), test);

        this.last_updated= object.getLong("last_updated");

}

}

