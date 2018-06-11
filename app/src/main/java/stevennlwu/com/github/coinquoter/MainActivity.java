package stevennlwu.com.github.coinquoter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import apiClient.CoinMarketClient;
import model.CoinList;

public class MainActivity extends AppCompatActivity {

   private CoinMarketClient aClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.aClient = new CoinMarketClient(this, this);
        this.getList();

    }

    private void getList() {
        this.aClient.getListing();
    }

    public void testCallback() {
        ArrayList<CoinList> listOfCoin = model.ListOfCoinList.INSTANCE.getListOfListing();



    }

}
