package com.developers.legoapp;

import com.developers.legoapp.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class Lezione5Activity extends Activity implements OnClickListener {

	public final static int GET_VALUE = 1;
	public static String VALUE = "value";

	final Context context = this;
	ImageButton btn6, btn1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lezione5);

		btn6 = (ImageButton) findViewById(R.id.button6);
		btn1 = (ImageButton) findViewById(R.id.imageButton1);

		btn1.setOnClickListener(this);
		btn6.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {

		case R.id.button6:
			Lezione5Activity.this.finish();

			break;
		case R.id.imageButton1:
			Intent intent = new Intent(this, DondoloActivity.class);
			startActivityForResult(intent, GET_VALUE);

			break;

		}

	}

}