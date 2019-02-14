package stevennlwu.com.github.coinquoter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
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
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener;

    {
        mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

            @SuppressLint("ResourceType")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_all:

                    /* ind Tablelayout defined in main.xml */
                    TableLayout mainTable = findViewById(R.id.TableLayout);

                    // remove all row except the header
                        /*
                    int childCount = mainTable.getChildCount();
                    if (childCount > 1) {
                        mainTable.removeViews(1, childCount - 1);
                    }
                    */

                    // create a new row
                    TableRow tbRow = new TableRow(MainActivity.this);

                    // create a new RelativeLayout
                    RelativeLayout rl =new RelativeLayout(MainActivity.this);
                    rl.setBackgroundColor(2);

                    // create a new Image
                    ImageView image = new ImageView(MainActivity .this);
                    image.setImageResource(R.drawable.btc);
                    image.setId(2);

                    // set the image params

                        android.util.TypedValue value = new android.util.TypedValue();
                        boolean b = getTheme().resolveAttribute(android.R.attr.listPreferredItemHeight, value, true);
                        String s = TypedValue.coerceToString(value.type, value.data);
                        android.util.DisplayMetrics metrics = new android.util.DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(metrics);
                        float ret = value.getDimension(metrics);

                        TypedValue value = new TypedValue();
                        ((Activity)context).getTheme().resolveAttribute(android.R.attr.listPreferredItemHeight, value, true);

                    RelativeLayout.LayoutParams imageParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,  h);
                    imageParams.setMarginEnd((int) getResources().getDimension(R.dimen.image_marginEnd));
                    image.setLayoutParams(imageParams);

                    // add view component by component
                    rl.addView(image,imageParams);
                    tbRow.addView(rl);
                    mainTable.addView(tbRow);


                    /*
                    RelativeLayout.LayoutParams firstImageParams =  new RelativeLayout.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);

                    /*
                    int pixelsValue = 6; // margin in pixels
                    float d = MainActivity.this.getResources().getDisplayMetrics().density;
                    int margin = (int)(pixelsValue * d);
                    firstImageParams.setMarginEnd(margin);

                    tbRow.addView(rl);
                    mainTable.addView(tbRow);
                    */


                    // test add image
                        /*
                    RelativeLayout channel=new RelativeLayout(MainActivity.this);
                    channel.setBackgroundColor(2);
                    ImageView imageTest = new ImageView(MainActivity .this);
                    imageTest.setImageResource(R.drawable.btc);
                    imageTest.setId(2);
                    RelativeLayout.LayoutParams firstImageParams = new RelativeLayout.LayoutParams(
                            android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
                            android.view.ViewGroup.LayoutParams.WRAP_CONTENT);
                    firstImageParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
                    channel.addView(imageTest,firstImageParams);
                    tbRow.addView(channel);
                    mainTable.addView(tbRow);
                    */



                        // test can i do dynamical display
                        /*
                        TextView tv0 = new TextView(MainActivity.this);
                        tv0.setText(" Sl.No ");
                        tv0.setTextColor(Color.BLUE);
                        tbrow0.addView(tv0);

                        mainTable.addView(tbrow0);
                        */

                    return true;

                    case R.id.navigation_save:

                        return true;
                    case R.id.navigation_setting:

                        return true;
                }
                return false;
            }
        };
    }


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
