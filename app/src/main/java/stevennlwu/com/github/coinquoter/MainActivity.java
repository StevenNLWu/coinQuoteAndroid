package stevennlwu.com.github.coinquoter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;
import apiClient.CoinMarketClient;
import model.Listings;
import model.Ticker;
import model.aListings;
import model.aTicker;

public class MainActivity extends AppCompatActivity {

   private CoinMarketClient aClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.aClient = new CoinMarketClient(this, this);
        this.aClient.getTicker();
    }

    public void callByGetListing() {
        ArrayList<aListings> listOfListing = Listings.INSTANCE.getListOfListing();
    }

    public void callByGetTicker(){
        ArrayList<aTicker> listOfListing = Ticker.INSTANCE.getListOfTicker();
    }

}
