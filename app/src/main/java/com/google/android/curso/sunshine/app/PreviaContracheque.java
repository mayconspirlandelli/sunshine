package com.google.android.curso.sunshine.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;


public class PreviaContracheque extends ActionBarActivity {

    private static final String LOG_TAG = PreviaContracheque.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previa_contracheque);

        WebView webView = (WebView) findViewById(R.id.webview);
        final String mimeType = "text/html";
        final String encoding = "UTF-8";
        webView.loadDataWithBaseURL("", previaGetHtml(), mimeType, encoding, "");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_previa_contracheque, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public String previaGetHtml() {

        String url = "http://www.ufrgs.br/progesp/progesp-1/paginas/previa-do-contracheque";
        String resultado = "";

        try {
            DefaultHttpClient client = new DefaultHttpClient();
            HttpGet vGet = new HttpGet(url);
            HttpResponse response = client.execute(vGet);
            String content = EntityUtils.toString(response.getEntity());
            Document document = Jsoup.parse(content);
            Elements elements = document.select("div#content-core");
            resultado = elements.toString();
        }
        catch (IOException e ) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }
}
