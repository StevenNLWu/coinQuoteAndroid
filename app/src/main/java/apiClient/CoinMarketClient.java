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

import java.util.ArrayList;

import model.CoinList;

public class CoinMarketClient {

    // url for calling API
    private static final String API_BASE_URL = "https://api.coinmarketcap.com/";
    private static final String API_VERSION = "v2";
    private static final String API_ENDPOINT = "listings";
    private String url = API_BASE_URL + API_VERSION + "/" + API_ENDPOINT + "/";
    public ArrayList<CoinList> listOfListing= new ArrayList<model.CoinList>();

    // Instantiate the RequestQueue.
    RequestQueue queue;

    public CoinMarketClient(Context mainWinContext)
    {
        this.queue = Volley.newRequestQueue(mainWinContext);
    }

    public void getListing()
    {
        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET,
                                                                this.url,
                                                                null,
                                                                new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                // TODO Auto-generated method stub
                try {
                    JSONArray array = response.getJSONArray("data");
                    for(int coinID = 0; coinID < array.length(); coinID++)
                    {
                        JSONObject object = array.optJSONObject(coinID);
                        listOfListing.add(new CoinList(object));
                    }

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
}