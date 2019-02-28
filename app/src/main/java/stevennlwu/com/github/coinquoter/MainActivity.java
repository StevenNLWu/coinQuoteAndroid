package stevennlwu.com.github.coinquoter;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
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
import model.Ticker;
import model.aListings;
import model.aTicker;


public class MainActivity extends AppCompatActivity {

    // event listener for the Top-menu-bar
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @SuppressLint("ResourceType")
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            // get value of “listPreferredItemHeight” attribute
            android.util.TypedValue value = new android.util.TypedValue();
            boolean b = getTheme().resolveAttribute(android.R.attr.listPreferredItemHeight, value, true);
            String s = TypedValue.coerceToString(value.type, value.data);
            android.util.DisplayMetrics metrics = new android.util.DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(metrics);
            int preferredHeight = (int) value.getDimension(metrics);

            // get the marginl, from pid to px
            float marginEnd = getResources().getDimension(R.dimen.image_marginEnd);
            Resources r = MainActivity.this.getResources();
            int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, marginEnd, r.getDisplayMetrics());

            // loop int for id
            int intId = 1;

            switch (item.getItemId()) {
                case R.id.navigation_all:

                /* ind Tablelayout defined in main.xml */
                TableLayout mainTable = findViewById(R.id.TableLayout_template);

                // remove all row except the header
                int childCount = mainTable.getChildCount();
                if (childCount > 1) {
                    mainTable.removeViews(1, childCount - 1);
                }

                // create a new row
                TableRow tbRow = new TableRow(MainActivity.this);

                // create a new RelativeLayout
                RelativeLayout rl =new RelativeLayout(MainActivity.this);

                // create a new Image
                ImageView image = new ImageView(MainActivity.this);
                image.setImageResource(R.drawable.btc);
                image.setId(intId);

                // create a new text
                TextView text = new TextView(MainActivity.this);
                text.setText("BTC (ETH) 300.44USD (24hr: -6.49)");
                text.setTextSize(TypedValue.COMPLEX_UNIT_SP,16);
                text.setGravity(Gravity.CENTER_VERTICAL );

                // set the text params
                RelativeLayout.LayoutParams txtParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
                txtParams.addRule(RelativeLayout.RIGHT_OF, intId);

                // set the image params
                RelativeLayout.LayoutParams imageParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.MATCH_PARENT);
                imageParams.setMargins(px,px,px,px);

                // add view component by component
                mainTable.addView(tbRow);

                tbRow.addView(rl);
                rl.addView(image, imageParams);
                rl.addView(text,txtParams);

                // set the text params
                //RelativeLayout.LayoutParams txtParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
                text.getLayoutParams().width= RelativeLayout.LayoutParams.MATCH_PARENT;
                text.getLayoutParams().height= RelativeLayout.LayoutParams.MATCH_PARENT;

                // set the RelativeLayout params
                rl.getLayoutParams().width= RelativeLayout.LayoutParams.MATCH_PARENT;
                rl.getLayoutParams().height= preferredHeight;

                // set the TableRow params
                tbRow.getLayoutParams().width= RelativeLayout.LayoutParams.MATCH_PARENT;
                tbRow.getLayoutParams().height= RelativeLayout.LayoutParams.MATCH_PARENT;

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
        this.aClient.getListing();
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
