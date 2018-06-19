package apiClient;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

import model.Listings;
import model.Ticker;
import model.aListings;
import model.aTicker;

public class CoinMarketClient {

    // url for calling API
    private static final String API_BASE_URL = "https://api.coinmarketcap.com/";
    private static final String API_VERSION = "v2";
    private stevennlwu.com.github.coinquoter.MainActivity mainApp;

    // Instantiate the RequestQueue.
    RequestQueue queue;

    public CoinMarketClient(stevennlwu.com.github.coinquoter.MainActivity mainApp, Context mainWinContext)
    {
        this.mainApp = mainApp;
        this.queue = Volley.newRequestQueue(mainWinContext);
    }

    public void getListing()
    {
        String url = this.API_BASE_URL + this.API_VERSION + "/" + "listings/";

        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET
                                                                ,url
                                                                ,null
                                                                ,new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                // TODO Auto-generated method stub
                try {
                        JSONArray array = response.getJSONArray("data");
                        Listings.INSTANCE.resetList(array.length());

                        for(int coinID = 0; coinID < array.length(); coinID++) {

                        JSONObject object = array.optJSONObject(coinID);
                        Listings.INSTANCE.addACoin(new aListings(object));
                    }
                    callByGetListing();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
                                                                , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub
            }
        });

        // Add JsonObjectRequest to the RequestQueue
        this.queue.add(jsObjRequest);
    }

    public void callByGetListing()
    {
        this.mainApp.callByGetListing();
    }

    public void getTicker()
    {
        String url = this.API_BASE_URL + this.API_VERSION + "/" + "ticker/";

        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET
                                                                ,url
                                                                ,null
                                                                ,new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                // TODO Auto-generated method stub
                try {
                        JSONObject jObject = response.getJSONObject("data");
                        Iterator<?> keys = jObject.keys();
                        Ticker.INSTANCE.resetList(jObject.length());

                        while (keys.hasNext()) {
                            String key = (String) keys.next();
                            JSONObject object = jObject.optJSONObject(key);
                            Ticker.INSTANCE.addATicker(new aTicker(object));
                        }

                    callByGetTicker();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
                                                                , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub
            }
        });

        // Add JsonObjectRequest to the RequestQueue
        this.queue.add(jsObjRequest);
    }
    public void callByGetTicker()
    {
        this.mainApp.callByGetTicker();
    }


}
