package com.developers.legoapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

@SuppressLint("NewApi")
public class MainActivity extends Activity implements OnClickListener {

	public final static int GET_VALUE = 1;
	public static String VALUE = "value";

	Button btn1, btn3, btn4;
	ImageButton btn6;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btn1 = (Button) findViewById(R.id.button1);
		btn3 = (Button) findViewById(R.id.button3);
		btn4 = (Button) findViewById(R.id.button4);
		btn6 = (ImageButton) findViewById(R.id.imageButton1);

		btn1.setOnClickListener(this);
		btn3.setOnClickListener(this);
		btn4.setOnClickListener(this);
		btn6.setOnClickListener(this);
		// Font path
		String fontPath = "fonts/Lego.ttf";

		// Loading Font Face
		Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);

		// Applying font
		btn1.setTypeface(tf);
		btn3.setTypeface(tf);
		btn4.setTypeface(tf);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			Intent intent = new Intent(this, LezioniRoboticaActivity.class);
			startActivityForResult(intent, GET_VALUE);

			break;

		case R.id.button3:
			Intent intent2 = new Intent(this, RoboticaActivity.class);
			startActivityForResult(intent2, GET_VALUE);

			break;

		case R.id.button4:
			Intent intent3 = new Intent(this, RicercaActivity.class);
			startActivityForResult(intent3, GET_VALUE);

			break;
		case R.id.imageButton1:
			Intent sharingIntent = new Intent(
					android.content.Intent.ACTION_SEND);

			sharingIntent.setType("text/plain");

			String shareBody = "Scarica l'app MOC EV3: https://play.google.com/store/apps/details?id=com.developers.legoapp&hl=it ";
			sharingIntent
					.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
			startActivity(Intent.createChooser(sharingIntent,
					"Consiglia l'app !"));

			break;
		}
	}

	@Override
	public void onBackPressed() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("ATTENZIONE !");
		builder.setMessage("Sei sicuro di voler uscire dall'app ?")
				.setCancelable(false)
				.setPositiveButton("Si", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						MainActivity.this.finish();
					}
				})
				.setNegativeButton("No", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {

						dialog.cancel();
					}
				});
		AlertDialog alert = builder.create();
		alert.show();

	}
}
