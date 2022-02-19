package com.developers.legoapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageButton;

public class RicercaActivity extends Activity implements OnClickListener {

	public final static int GET_VALUE = 1;
	public static String VALUE = "value";

	ImageButton btn1, btn2, btn6;
	private WebView mWebView;
	private static EditText ed;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ricerca);
		// carichiamo la webview dentro il layout specificato
		mWebView = (WebView) findViewById(R.id.webView1);
		mWebView.getSettings().setJavaScriptEnabled(true);
		mWebView.getSettings().setLoadsImagesAutomatically(true);
		ed = (EditText) findViewById(R.id.editText1);
		ed.setWidth(150);
		ed.setSingleLine(true);
		ed.setHorizontallyScrolling(false);

		btn1 = (ImageButton) findViewById(R.id.button1);
		btn2 = (ImageButton) findViewById(R.id.button2);
		btn6 = (ImageButton) findViewById(R.id.imageButton1);

		btn2.setOnClickListener(this);
		btn1.setOnClickListener(this);
		btn6.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			String input = ed.getText().toString();
			String url = "http://www.1000steine.com/brickset/images/" + input
					+ "-1.jpg";
			// carichiamo finalmete la url
			mWebView.getSettings().setBuiltInZoomControls(true);
			mWebView.setWebViewClient(new WebViewClient());
			mWebView.loadUrl(url);
			mWebView.setWebViewClient(new WebViewClient() {
				public boolean shouldOverrideUrlLoading(WebView view, String url) {
					view.loadUrl(url);
					return true;
				}
			});
			break;
		case R.id.button2:
			String input1 = ed.getText().toString();
			String url1 = "http://www.1000steine.com/brickset/images/" + input1
					+ "-1.jpg";
			Intent sharingIntent = new Intent(
					android.content.Intent.ACTION_SEND);

			sharingIntent.setType("text/plain");

			String shareBody = "Condivido il robot " + input1 + " : " + url1;
			sharingIntent
					.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
			startActivity(Intent.createChooser(sharingIntent, "Condividi"));

			break;
		case R.id.imageButton1:
			RicercaActivity.this.finish();

			break;

		}

	}
}
