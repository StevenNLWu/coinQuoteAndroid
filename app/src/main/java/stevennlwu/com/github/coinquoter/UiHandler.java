package stevennlwu.com.github.coinquoter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Handler;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

    public void displayAllAsset()
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

                        // determinate the asset's name and its current price; create a textView to display the info
                        TextView text = new TextView(mainWinContext);
                        String strSlug = listings.getData().get(i).getSlug();
                        String strSymbol = listings.getData().get(i).getSymbol();
                        String strPrice =  String.format("%.2f USD", listings.getData().get(i).getQuote().getUSD().getPrice());
                        String strText = strSlug + " (" + strSymbol + ") " + strPrice ;
                        text.setText(strText);
                        text.setTextSize(TypedValue.COMPLEX_UNIT_SP,16);
                        text.setGravity(Gravity.CENTER_VERTICAL );

                        // determinate the value of 7d-price-change
                        TextView text2nd = new TextView(mainWinContext);
                        String str1D = String.format("7d %.2f",listings.getData().get(i).getQuote().getUSD().getPercent_change_7d());
                        Spannable span7d = new SpannableString(str1D + "%");
                        Double do7d =  listings.getData().get(i).getQuote().getUSD().getPercent_change_7d();
                        if( do7d <0) {
                            span7d.setSpan(new ForegroundColorSpan(Color.RED), 0, span7d.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                        }
                        else if(do7d >0){
                            str1D =  "24hr " + "+" + String.format("%.2f", + listings.getData().get(i).getQuote().getUSD().getPercent_change_24h()) + "%";
                            span7d = new SpannableString(str1D);
                            span7d.setSpan(new ForegroundColorSpan(Color.parseColor("#2e7d32")), 0, str1D.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                        }
                        text2nd.setText(span7d);
                        text2nd.append("  ");

                        // determinate the value of 24hr-price-change; create a textView to display the info
                        String str24Hr =  String.format("24hr %.2f",listings.getData().get(i).getQuote().getUSD().getPercent_change_24h());
                        Spannable span24Hr = new SpannableString(str24Hr + "%");
                        Double do24Hr =  listings.getData().get(i).getQuote().getUSD().getPercent_change_24h();
                        if( do24Hr <0) {
                            span24Hr.setSpan(new ForegroundColorSpan(Color.RED), 0, span24Hr.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                        }
                        else if(do24Hr >0){
                            str24Hr =  "24hr " + "+" + String.format("%.2f", + listings.getData().get(i).getQuote().getUSD().getPercent_change_24h()) + "%";
                            span24Hr = new SpannableString(str24Hr);
                            span24Hr.setSpan(new ForegroundColorSpan(Color.parseColor("#2e7d32")), 0, span24Hr.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                        }
                        text2nd.append(span24Hr);
                        text2nd.append("  ");

                        // determinate the value of 1Hr-price-change; add the info into the textView of text2nd
                        String str1Hr =  String.format("1hr %.2f",listings.getData().get(i).getQuote().getUSD().getPercent_change_1h());
                        Spannable span1Hr = new SpannableString(str1Hr + "%");
                        Double do1Hr =  listings.getData().get(i).getQuote().getUSD().getPercent_change_1h();
                        if( do1Hr <0) {
                            span1Hr.setSpan(new ForegroundColorSpan(Color.RED), 0, span1Hr.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                        }
                        else if(do1Hr >0){
                            str1Hr = "1hr " + "+" + String.format("%.2f", + listings.getData().get(i).getQuote().getUSD().getPercent_change_1h()) + "%";
                            span1Hr = new SpannableString(str1Hr);
                            span1Hr.setSpan(new ForegroundColorSpan(Color.parseColor("#2e7d32")), 0, span1Hr.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                        }
                        text2nd.append(span1Hr);
                        text2nd.setTextSize(TypedValue.COMPLEX_UNIT_SP,12);
                        text2nd.setGravity(Gravity.CENTER_VERTICAL );

                        // set the text params; determinate the text layout
                        RelativeLayout.LayoutParams txtParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                        txtParams.addRule(RelativeLayout.RIGHT_OF, i+1);
                        RelativeLayout.LayoutParams txt2ndParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                        txt2ndParams.addRule(RelativeLayout.RIGHT_OF, i+1);
                        txt2ndParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, text.getId());

                        // set the image params
                        RelativeLayout.LayoutParams imageParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.MATCH_PARENT);
                        imageParams.setMargins(px,px,px,px);

                        // add view component by component
                        mainTable.addView(tbRow);
                        tbRow.addView(rl);
                        rl.addView(image, imageParams);
                        rl.addView(text,txtParams);
                        rl.addView(text2nd,txt2ndParams);

                        // set the text params
                        text.getLayoutParams().width= RelativeLayout.LayoutParams.WRAP_CONTENT;
                        text.getLayoutParams().height= RelativeLayout.LayoutParams.MATCH_PARENT;
                        text2nd.getLayoutParams().width= RelativeLayout.LayoutParams.WRAP_CONTENT;
                        text2nd.getLayoutParams().height= RelativeLayout.LayoutParams.WRAP_CONTENT;

                        // set the RelativeLayout params
                        rl.getLayoutParams().width= RelativeLayout.LayoutParams.WRAP_CONTENT;
                        rl.getLayoutParams().height= preferredHeight;

                        // set the TableRow params
                        tbRow.getLayoutParams().width= RelativeLayout.LayoutParams.WRAP_CONTENT;
                        tbRow.getLayoutParams().height= RelativeLayout.LayoutParams.MATCH_PARENT;

                } // end of for-loop
            } // end of function run()
        }); // end of Runnable()
    }

    public void displaySaveAsset() {

        runOnUiThread(new Runnable(){
            @Override
            public void run(){
                /* get Tablelayout defined in main.xml */
                TableLayout mainTable = ((Activity) mainWinContext).findViewById(R.id.TableLayout_template);

                // remove all row except the header
                int childCount = mainTable.getChildCount();
                if (childCount > 1) {
                    mainTable.removeViews(1, childCount - 1);
                }

            } // end of function run()
        }); // end of Runnable()
    }
}
