package stevennlwu.com.github.coinquoter;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import apiClient.CoinMarketClient;
import model.Listings;

/*
 *
 *   Our App in here
 *
 */
public class MainActivity extends AppCompatActivity {

    private UiHandler uiHander;

    // event listener for the Top-menu-bar
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @SuppressLint("ResourceType")
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {


            switch (item.getItemId()) {
                case R.id.navigation_all:
                    clickAllButton();
                    return true;
                case R.id.navigation_save:
                    clickSaveButton();
                    return true;
                case R.id.navigation_setting:

                    return true;
            }
            return false;
        }
    };


    private CoinMarketClient aClient;

    /*
    *
    *   Our App starts in here
    *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.uiHander = new UiHandler(this);

        // calling CoinMarket API, get data to generate our App's first page
        this.aClient = new CoinMarketClient(this, this);
        this.aClient.getListing();

        // declare menu and add a event listener
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }


    /*
     *
     *   This function will be callbacked after calling coinMarket's API
     *
     */
    public void callByGetListing(model.Listings listings ) {
        this.uiHander.setListings(listings);
    }


    public void clickAllButton() {
        this.uiHander.displayAllAsset();
    }

    public void clickSaveButton() {
        this.uiHander.displaySaveAsset();
    }




}
