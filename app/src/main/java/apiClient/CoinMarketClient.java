package apiClient;

import android.content.Context;
import android.net.Uri;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;
import stevennlwu.com.github.coinquoter.R;

public class CoinMarketClient {

    // url for calling API
    private static final String strApiProtocol  = "https";
    private static final String strApiURL = "pro-api.coinmarketcap.com";
    private static final String strApiVersion = "v1";
    private static final String strApiType = "cryptocurrency";

    // old version public API url
    //private static final String API_BASE_URL = "https://api.coinmarketcap.com/";
    //private static final String API_VERSION = "v2";

    private stevennlwu.com.github.coinquoter.MainActivity mainApp;
    private String strApiKey;

    // Instantiate the RequestQueue.
    RequestQueue queue;

    public CoinMarketClient(stevennlwu.com.github.coinquoter.MainActivity mainApp, Context mainWinContext)
    {
        this.mainApp = mainApp;
        this.queue = Volley.newRequestQueue(mainWinContext);
        this.strApiKey =  mainApp.getResources().getString(R.string.key);
    }

    public void getListing()
    {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(this.strApiProtocol)
                .authority(this.strApiURL)
                .appendPath(this.strApiVersion)
                .appendPath(this.strApiType)
                .appendPath("listings")
                .appendPath("latest")
                .appendQueryParameter("limit", "100");

        String url = builder.build().toString();

        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET
                                                                ,url
                                                                ,null
                                                                ,new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                // TODO Auto-generated method stub
                try {
                    String mJsonString = response.toString();
                    JsonParser parser = new JsonParser();
                    JsonElement mJson =  parser.parse(mJsonString);
                    Gson gson = new Gson();
                    model.Listings listings = gson.fromJson(mJson, model.Listings.class);

                    // call back to a function inside this class
                    callByGetListing(listings);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },
            new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub
            }
        })
        {
            /** Passing some request headers* */
            @Override
            public Map getHeaders() throws AuthFailureError {
                HashMap headers = new HashMap();
                headers.put("Content-Type", "application/json");
                headers.put("X-CMC_PRO_API_KEY", strApiKey);
                return headers;
            }
        };


        // Add JsonObjectRequest to the RequestQueue
        this.queue.add(jsObjRequest);
    }

    // call back to mainApp
    public void callByGetListing(model.Listings listings)
    {
        this.mainApp.callByGetListing(listings);
    }


    /*
    public void getTicker()
    {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(this.strApiProtocol)
                .authority(this.strApiURL)
                .appendPath(this.strApiVersion)
                .appendPath(this.strApiType)
                .appendPath("listings")
                .appendPath("latest")
                .appendQueryParameter("limit", "100");

        String url = builder.build().toString();


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
*/

}
