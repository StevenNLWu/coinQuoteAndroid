package model;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;

public class aTicker {

    private final long id;
    private final String name;
    private final String symbol;
    private final String websiteSlug;
    private final int rank;
    private final double circulating_supply;
    private final double total_supply;
    private final String max_supply;
    //private final JSONObject quotes;
    private HashMap<String, aQuotes> quotes = new HashMap<>();
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
        String strCurr = (object.getJSONObject("quotes").keys().next());
        this.quotes.put(strCurr, new aQuotes(object.getJSONObject("quotes").getJSONObject(strCurr)));
        this.last_updated= object.getLong("last_updated");
    }
}

