package stevennlwu.com.github.coinquoter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayout;
import android.view.Gravity;
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

                    /* Create Grid */
                    GridLayout newGrid = new GridLayout(MainActivity.this);
                    newGrid.setRowCount(2);
                    newGrid.setColumnCount(4);

                    /* Create a coin image */
                    ImageView image = new ImageView(MainActivity.this);
                    image.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT
                            , ViewGroup.LayoutParams.MATCH_PARENT));
                    image.setBaselineAlignBottom(true);
                    GridLayout.LayoutParams GridParams = new GridLayout.LayoutParams();
                    GridParams.setMargins(6,6,6,6);
                    GridParams.columnSpec = GridLayout.spec(0, 1);
                    GridParams.rowSpec = GridLayout.spec(0, 2);
                    image.setLayoutParams(GridParams);
                    image.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.coinmarket,null));

                    /* Create a TextView  */
                    TextView text = new TextView(MainActivity.this);
                    RelativeLayout.LayoutParams Textparams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT
                            , RelativeLayout.LayoutParams.WRAP_CONTENT);
                    // Add all the rules you need
                    Textparams.addRule(RelativeLayout.ALIGN_PARENT_END, 1);
                    Textparams.addRule(RelativeLayout.ALIGN_PARENT_TOP, 1);
                    text.setGravity(Gravity.CENTER );
                    Textparams.setMargins(6,6,6,6);
                    text.setText("TEST");
                    GridParams.columnSpec = GridLayout.spec(0, 2);
                    GridParams.rowSpec = GridLayout.spec(0, 1);
                    // Once you are done set the LayoutParams to the layout
                    text.setLayoutParams(Textparams);

                    /* add all together */
                    newGrid.addView(image);
                    newGrid.addView(text);
                    newTRow.addView(newGrid);
                    mainTable.addView(newTRow);

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
