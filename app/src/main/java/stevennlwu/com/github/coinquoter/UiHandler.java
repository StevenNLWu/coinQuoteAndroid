package stevennlwu.com.github.coinquoter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


import java.math.BigDecimal;

import model.Listings;

public class UiHandler {

    private final Handler handler;
    private Listings listings;
    private Context mainWinContext;

    public UiHandler(Context context)
    {
        this.handler = new Handler(context.getMainLooper());
        this.mainWinContext = context;
    }

    public void setListings( Listings listings)
    {
        this.listings = listings;
    }

    private void runOnUiThread(Runnable r)
    {
        handler.post(r);
    }

    public void screenInitial()
    {
        runOnUiThread(new Runnable(){
            @Override
            public void run(){

                // get value of “listPreferredItemHeight” attribute
                    TypedValue value = new TypedValue();
                    mainWinContext.getTheme().resolveAttribute(android.R.attr.listPreferredItemHeight, value, true);
                    DisplayMetrics metrics = new DisplayMetrics();
                    ((Activity) mainWinContext).getWindowManager().getDefaultDisplay().getMetrics(metrics);
                    int preferredHeight = (int) value.getDimension(metrics);

                    // get the margin, from pid to px
                    float marginEnd = mainWinContext.getResources().getDimension(R.dimen.image_marginEnd);
                    Resources r = mainWinContext.getResources();
                    int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, marginEnd, r.getDisplayMetrics());

                    /* get Tablelayout defined in main.xml */
                    TableLayout mainTable = ((Activity) mainWinContext).findViewById(R.id.TableLayout_template);

                    // remove all row except the header
                    int childCount = mainTable.getChildCount();
                    if (childCount > 1) {
                        mainTable.removeViews(1, childCount - 1);
                    }

                    // loop one asset by one asset; display one by one
                    int intloop = listings.getData().size();
                    for(int i=0; i<intloop; i++) {

                        // create a new row
                        TableRow tbRow = new TableRow(mainWinContext);

                        // create a new RelativeLayout
                        RelativeLayout rl =new RelativeLayout(mainWinContext);

                        // determinate the coin-image; if the resource don't exist, we simply use coinmarket.png
                        String strAssetSymbol = listings.getData().get(i).getSymbol().toLowerCase();
                        int intCheckResource = mainWinContext.getResources().getIdentifier(strAssetSymbol, "drawable", mainWinContext.getPackageName());
                        if (intCheckResource == 0 ){
                            strAssetSymbol = "coinmarket";
                        }
                        int imgaeId = mainWinContext.getResources().getIdentifier("drawable/"+strAssetSymbol, null, mainWinContext.getPackageName());

                        // create a new Image
                        ImageView image = new ImageView(mainWinContext);
                        image.setImageResource(imgaeId);
                        image.setId(i+1);

                        // determiinate the text context
                        String strSlug = listings.getData().get(i).getSlug();
                        String strSymbol = listings.getData().get(i).getSymbol();
                        String strPrice =  String.format("%.2f USD", listings.getData().get(i).getQuote().getUSD().getPrice());
                        String str24Hr =  String.format("24hr %.2f",listings.getData().get(i).getQuote().getUSD().getPercent_change_24h());
                        TextView text = new TextView(mainWinContext);

                        // create a new text
                        String strText = strSlug + " (" + strSymbol + ") " + strPrice + " (" + str24Hr + ")";
                        text.setText(strText);
                        text.setTextSize(TypedValue.COMPLEX_UNIT_SP,16);
                        text.setGravity(Gravity.CENTER_VERTICAL );

                        // set the text params
                        RelativeLayout.LayoutParams txtParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
                        txtParams.addRule(RelativeLayout.RIGHT_OF, i+1);

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

                } // end of for-loop
            } // end of function run()
        }); // end of Runnable()
    }
}
