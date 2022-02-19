package com.developers.legoapp;

import com.developers.legoapp.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ShareActionProvider;

public class RoboticaActivity extends Activity {
	private WebView mWebView;
	/**
	 * Dichiariamo l'attributo di classe url in cui salviamo l'indirizzo web che
	 * aprirà la webview
	 */
	private String url = "http://robotica.carloanti.it/";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_robotica);
		// carichiamo la webview dentro il layout specificato
		mWebView = (WebView) findViewById(R.id.webView1);
		mWebView.getSettings().setJavaScriptEnabled(true);
		mWebView.getSettings().setLoadsImagesAutomatically(true);
		// carichiamo finalmete la url
		mWebView.setWebViewClient(new WebViewClient());
		mWebView.loadUrl(url);
		mWebView.getSettings().setBuiltInZoomControls(true);

		mWebView.setWebViewClient(new WebViewClient() {
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				view.loadUrl(url);
				return true;
			}
		});

	}

	@SuppressLint("NewApi")
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.action_bar_share_menu, menu);
		MenuItem item = menu.findItem(R.id.menu_item_share);
		ShareActionProvider myShareActionProvider = (ShareActionProvider) item
				.getActionProvider();
		Intent myIntent = new Intent();
		myIntent.setAction(Intent.ACTION_SEND);
		myIntent.putExtra(Intent.EXTRA_TEXT, "Ho condiviso il sito dedicato alla robotica: http://robotica.carloanti.it/");
		myIntent.setType("text/plain");

		myShareActionProvider.setShareIntent(myIntent);

		return true;
	}
}