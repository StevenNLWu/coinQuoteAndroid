package stevennlwu.com.github.coinquoter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.ArrayList;

import apiClient.CoinMarketClient;
import model.Listings;
import model.Ticker;
import model.aListings;
import model.aTicker;

public class MainActivity extends AppCompatActivity {

    // event listener for the Top-menu-bar
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_all:

                    /* Find Tablelayout defined in main.xml */
                    TableLayout mainTable = (TableLayout) findViewById(R.id.TableLayout);

                    /* Create a new row to be added. */
                    TableRow newTRow = new TableRow(MainActivity.this);
                    newTRow.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT
                                                                      , TableRow.LayoutParams.MATCH_PARENT));
                    ViewGroup tRow = newTRow;

                    mainTable.addView(tRow);

                    return true;

                case R.id.navigation_save:

                    return true;
                case R.id.navigation_setting:

                    return true;
            }
            return false;
        }
    };


    private CoinMarketClient aClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // declare menu
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // for CoinMarket API
        this.aClient = new CoinMarketClient(this, this);
        this.aClient.getTicker();
    }

    public void callByGetListing() {
        ArrayList<aListings> listOfListing = Listings.INSTANCE.getListOfListing();
    }


    public void callByGetTicker() {

        ArrayList<aTicker> listOfListing = Ticker.INSTANCE.getListOfTicker();

        // default first page is "All Asset"
        this.mOnNavigationItemSelectedListener.onNavigationItemSelected(((BottomNavigationView) findViewById(R.id.navigation)).getMenu().getItem(0));

        // for UI Thread
       /* new Handler(Looper.getMainLooper()).post(new Runnable() {

            public void run() {

            }
        });
        */

    }
}
