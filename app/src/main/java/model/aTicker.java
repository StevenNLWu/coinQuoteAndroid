package model;

import org.json.JSONException;
import org.json.JSONObject;

public class aTicker {


    private long id;
    private String name;
    private String symbol;
    private String websiteSlug;
    private int rank;
    private double circulating_supply;
    private double total_supply;
    private double max_supply;
    private Object quotes;
    private long last_updated;

    public aTicker(JSONObject object) throws JSONException {

        this.id= object.getLong("id");
        this.name= object.getString("name");
        this.symbol= object.getString("symbol");
        this.websiteSlug= object.getString("website_slug");

        this.rank= object.getInt("rank");
        this.circulating_supply= object.getDouble("circulating_supply");
        this.total_supply= object.getDouble("total_supply");
        this.max_supply = object.getDouble("max_supply");

        this.quotes = object.getJSONObject("quotes");
        this.last_updated= object.getLong("last_updated");

    }

}

