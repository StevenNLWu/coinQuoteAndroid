package stevennlwu.com.github.coinquoter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import apiClient.CoinMarketClient;

public class MainActivity extends AppCompatActivity {

   private CoinMarketClient aClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.aClient = new CoinMarketClient(this);
        this.getList();

    }

    private void getList()
    {
       this.aClient.getListing();

    }
}
