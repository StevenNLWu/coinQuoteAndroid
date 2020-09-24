package stevennlwu.com.github.coinquoter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import apiClient.CoinMarketClient;

/*
 *
 *   Our App in here
 *
 */
public class MainActivity extends AppCompatActivity {

    private UiHandler uiHander;
    private BottomNavigationView navigation;
    private CoinMarketClient aClient;
    private SwipeRefreshLayout swipeRefresh;

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

    // find out which current item of Navigation is selected
    private int getCheckedItem(BottomNavigationView navigationView) {
        Menu menu = navigationView.getMenu();
        for (int i = 0; i < menu.size(); i++) {
            MenuItem item = menu.getItem(i);
            if (item.isChecked()) {
                return i;
            }
        }
        return -1;
    }

    /*
    *
    *   Our App starts in here
    *
     */

    public void getMembers(java.util.concurrent.Callable<Void> callbackWithMembers){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getMembers(new java.util.concurrent.Callable<Void>() {

                    public Void call() {
                       // myParamMethod();
                        return null;
                    }
                }
        );



        this.uiHander = new UiHandler(this);

        // calling CoinMarket API, get data to generate our App's first page
        this.aClient = new CoinMarketClient(this, this);
        this.aClient.getListing();

        // declare menu and add a event listener
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // for swipe-to-refresh
        swipeRefresh = findViewById(R.id.swiperefresh_items);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh( ) {
                // refresh action
                // mOnNavigationItemSelectedListener.onNavigationItemSelected();
                aClient.getListing();
                int intId = getCheckedItem(navigation);
                mOnNavigationItemSelectedListener.onNavigationItemSelected(navigation.getMenu().getItem(intId));

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(swipeRefresh.isRefreshing()) {
                            swipeRefresh.setRefreshing(false);
                        }
                    }
                }, 5000);   // in ms

            }
        });
    }


    /*
     *
     *   This function will be callbacked after calling coinMarket's API
     *
     */
    public void callByGetListing(model.Listings listings ) {
        this.uiHander.setListings(listings);
        this.uiHander.displayAllCrypto();
    }


    public void clickAllButton() {
        this.uiHander.displayAllCrypto();
    }

    public void clickSaveButton() {
        this.uiHander.displayMyCrypto();
    }




}
