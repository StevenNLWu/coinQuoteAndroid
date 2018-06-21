package model;

import org.json.JSONException;
import org.json.JSONObject;

public class aQuotes {

    private final double price;
    private final double dayVolume;
    private final double marketCap;
    private final double hourChange;
    private final double dayChange;
    private final double weekChange;

    public aQuotes(JSONObject object) throws JSONException {

        this.price= object.getDouble("price");
        this.dayVolume= object.getDouble("volume_24h");
        this.marketCap= object.getDouble("market_cap");
        this.hourChange= object.getDouble("percent_change_1h");
        this.dayChange= object.getInt("percent_change_24h");
        this.weekChange= object.getDouble("percent_change_7d");
    }

}

