package com.sohaeb.wia.Website;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.sohaeb.wia.R;
import com.sohaeb.wia.Website.Presenter.MyWebChromeClient;

/**
 * Created by may on 2017-07-03.
 */

public class openHTML extends AppCompatActivity implements MyWebChromeClient.ProgressListener {

//    public void openWebPage(String url) {
////        Uri webpage = Uri.parse(url);
////        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
////        if (intent.resolveActivity(getPackageManager()) != null) {
////            startActivity(intent);
////        }
//    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);

        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.indeterminateBar);

        WebView webView = (WebView) findViewById(R.id.browser);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.setWebChromeClient(new MyWebChromeClient(this));
        webView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {

                final Uri uri = request.getUrl();
//                 handleUri(uri);
                view.loadUrl(uri.toString());

                return true;
            }

            public boolean shouldOverrideUrlLoading(WebView view, String url) {

//                final Uri uri = Uri.parse(url);
//                return handleUri(uri);
                view.loadUrl(url);

                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(View.GONE);

            }
        });


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("url");

            webView.loadUrl(value);
        }

//        private boolean handleUri(final Uri uri) {
//            Log.i(TAG, "Uri =" + uri);
//            final String host = uri.getHost();
//            final String scheme = uri.getScheme();
//            // Based on some condition you need to determine if you are going to load the url
//            // in your web view itself or in a browser.
//            // You can use `host` or `scheme` or any part of the `uri` to decide.
//            if (/* any condition */) {
//                // Returning false means that you are going to load this url in the webView itself
//                return false;
//            } else {
//                // Returning true means that you need to handle what to do with the url
//                // e.g. open web page in a Browser
//                final Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                startActivity(intent);
//                return true;
//            }
//        }



        // 1 way:
        // add a HTML to strings.xml, then set it to text

//        TextView foo = (TextView)findViewById(R.id.foo);
//        foo.setMovementMethod(new ScrollingMovementMethod());
//
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
//            foo.setText(Html.fromHtml(getString(R.string.nice_html),Html.FROM_HTML_MODE_LEGACY));
//        } else {
//            foo.setText(Html.fromHtml(getString(R.string.nice_html)));
//        }
//
//        WebView webView = (WebView) findViewById(R.id.web_about);


        // 2 way
//        webView.loadData("<p style=\"line-height: normal;\"><strong style=\"color: #ff0000; font-size: 18pt;\"><span style=\"font-family: Arial, sans-serif;\"></span></strong><span style=\"font-family: Arial; font-size: 14pt;\">Established in 2010, The Windsor Islamic Council” (WIC) is an umbrella not-for-profit organization of the Islamic organizations, MosquesActivity, and centers in Windsor.&nbsp; The WIC serves the civic and community interests of local Canadian Muslims.</span></p><p style=\"line-height: normal;\">&nbsp;</p><p style=\"margin-left: 6.65pt; text-indent: -6.7pt;\"><b><i><span style=\"text-decoration: underline;\"><span style=\"font-size: 18.5pt; font-family: Arial; color: #fb0007;\">Our Vision</span></span></i></b><b><i><span style=\"font-size: 18.5pt; font-family: Arial; color: #fb0007;\">: </span></i></b><span style=\"font-size: 14pt; font-family: Arial;\">&nbsp;An exemplary Windsor Muslim Community that embodies the common Islamic &amp; Canadian values of community service, civic engagement, religious tolerance, respect of human dignity, and giving.</span></p><p style=\"line-height: normal;\">&nbsp;</p><p style=\"margin-left: 6.65pt; text-indent: -6.7pt;\"><b><i><span style=\"text-decoration: underline;\"><span style=\"font-size: 18.5pt; font-family: Arial; color: #fb0007;\">Our Mission</span></span></i></b><b><i><span style=\"font-size: 18.5pt; font-family: Arial; color: #fb0007;\">: </span></i></b><span style=\"font-size: 14pt; font-family: Arial;\">&nbsp;is to serve and promote the interests of the Muslim Community of Windsor by: (a) communicating its many contributions to society, (b) inspiring its members to reach their maximum individual and collective potential, and (c) building of collaborative partnerships with the broader society </span></p><p style=\"line-height: normal;\">&nbsp;</p><p style=\"margin-left: 6.65pt; text-indent: -6.7pt;\"><b><i><span style=\"text-decoration: underline;\"><span style=\"font-size: 18.5pt; font-family: Arial; color: #fb0007;\">Aims&nbsp;and&nbsp;Objectives</span></span></i></b></p><p style=\"line-height: normal;\">&nbsp;</p><p style=\"margin: 0cm 11.85pt 11.85pt 59.45pt; text-indent: -59.5pt;\"><span style=\"font-size: 14pt; font-family: Arial;\">1. To&nbsp;promote cooperation, consensus, and unity with regards to the affairs&nbsp;of the&nbsp;</span><span style=\"font-family: Arial; font-size: 14pt; text-indent: -59.5pt;\">Muslim Community of Windsor</span></p><p style=\"margin-left: 30.65pt; text-indent: -30.7pt;\"><span style=\"font-size: 14pt; font-family: Arial;\">2.&nbsp;To promote an enlightened view of Islam as a noble and tolerant religion among Muslims and fellow citizens of other faiths in &nbsp;Windsor and beyond</span></p><p style=\"margin-left: 30.65pt; text-indent: -30.7pt;\"><span style=\"font-size: 14pt; font-family: Arial;\">3. To&nbsp;promote a better&nbsp;understanding&nbsp;of&nbsp;Canadian Muslims as integral members of&nbsp;the&nbsp;wider&nbsp;Canadian&nbsp;family.</span></p><p style=\"margin-left: 30.65pt; text-indent: -30.7pt;\"><span style=\"font-size: 14pt; font-family: Arial;\">4.&nbsp;To&nbsp;advocate on behalf of the&nbsp;Muslim&nbsp;community&nbsp;against all forms of bigotry, discrimination, and Islamophobia</span></p><p style=\"margin-left: 30.65pt; text-indent: -30.7pt;\"><span style=\"font-size: 14pt; font-family: Arial;\">5. To highlight and promote the positive engagement and contributions of the Muslim Community in civic and societal activities that serve the better good of society,</span></p><p style=\"line-height: normal;\">&nbsp;</p><p style=\"margin-left: 30.65pt; text-indent: -30.7pt;\"><span style=\"font-size: 14pt; font-family: Arial;\">7.&nbsp;To&nbsp;foster&nbsp;collaborative partnerships with local community and civic institutions to serve the better&nbsp;good&nbsp;of&nbsp;society.</span></p><p style=\"margin-left: 30.65pt; text-indent: -30.7pt;\"><span style=\"font-size: 14pt; font-family: Arial;\">8. To coordinate and cooperate with other Canadian Muslim organizations on civil rights issues that matter to Canadian Muslims</span></p><p style=\"line-height: normal;\">&nbsp;</p><p style=\"margin-left: 30.65pt; text-indent: -30.7pt;\"><span style=\"font-size: 14pt; font-family: Arial;\">9. To support the positive engagement of Muslim youth in civic life.&nbsp;</span><span style=\"font-family: Helvetica;\">&nbsp;</span><span style=\"font-size: 14pt; font-family: Arial;\"></span></p><p style=\"line-height: normal;\">&nbsp;</p><p style=\"line-height: normal; text-align: center;\">&nbsp;</p>\n","text/html", "UTF-8");

        // 3rd way
//        webView.loadUrl("file:///android_asset/about.html");

        //4th way read from
//        InputStream is = null;
//        try {
//            is = getAssets().open("about.html");
//
//        int size = is.available();
//
//        byte[] buffer = new byte[size];
//        is.read(buffer);
//        is.close();
//
//        String str = new String(buffer);
////        str = str.replace("old string", "new string");
//
//         webView.loadData(str, );
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // 5th way
//        openWebPage("http://windsorislamiccouncil.com/index.php/wic-about-us");
    }


    @Override
    public void onUpdateProgress(int progressValue) {

    }
}


