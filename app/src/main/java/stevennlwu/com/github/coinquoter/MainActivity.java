package stevennlwu.com.github.coinquoter;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

import apiClient.CoinMarketClient;
import model.Listings;
import model.Ticker;
import model.aListings;
import model.aTicker;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {

    // event listener for the Top-menu-bar
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_all:


                    /* Find Tablelayout defined in main.xml */
                    TableLayout mainTable = findViewById(R.id.TableLayout);

                    /* Create a new row to be added. */
                    //TableRow newTRow = new TableRow(MainActivity.this);
                    //newTRow.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT
                    //                                                , TableRow.LayoutParams.MATCH_PARENT));
                    //newTRow.requestLayout();

                    /* Create image */
                    //ImageView image = new ImageView(MainActivity.this);
                    //ViewGroup.MarginLayoutParams marginParams = new ViewGroup.MarginLayoutParams(image.getLayoutParams());
                    //image.setPadding(6, 6, 6, 6);
                    //RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(marginParams);
                    //image.setLayoutParams(layoutParams);
                    //image.requestLayout();

                    /* add all together */
                    //newTRow.addView(image);
                    //mainTable.addView(newTRow);


                    TableRow row = new TableRow(MainActivity.this);
                    row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT));


                    ImageView image = new ImageView(MainActivity.this);
                    image.setImageResource(R.drawable.btc);
                    image.setPadding(6, 6, 6, 6);
                    image.setId(2);

                    RelativeLayout relativeLayout = new RelativeLayout(MainActivity.this);



/*
                    TypedValue outValue = new TypedValue();
                    MainActivity.this.getTheme().resolveAttribute(android.R.attr.listPreferredItemHeight, outValue, true);
                    cardView.setBackgroundResource(outValue.resourceId);
                    */

                    relativeLayout.addView(image);
                    row.addView(relativeLayout);
                    mainTable.addView(row);

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
