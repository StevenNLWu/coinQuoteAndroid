package model;

import org.json.JSONException;
import org.json.JSONObject;

public class aListings {


    private long id;
    private String name;
    private String symbol;
    private String websiteSlug;

    public aListings(JSONObject object) throws JSONException {

        this.id= object.getLong("id");
        this.name= object.getString("name");
        this.symbol= object.getString("symbol");
        this.websiteSlug= object.getString("website_slug");
    }

}

