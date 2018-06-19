package model;

import org.json.JSONException;
import org.json.JSONObject;

public class aListings {


    private final long id;
    private final String name;
    private final String symbol;
    private final String websiteSlug;

    public aListings(JSONObject object) throws JSONException {

        this.id= object.getLong("id");
        this.name= object.getString("name");
        this.symbol= object.getString("symbol");
        this.websiteSlug= object.getString("website_slug");
    }

}

