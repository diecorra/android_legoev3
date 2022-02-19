package com.developers.legoapp;

import com.developers.legoapp.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class Lezione3Activity extends Activity implements OnClickListener {

	public final static int GET_VALUE = 1;
	public static String VALUE = "value";

	final Context context = this;
	ImageButton btn1, btn2, btn6;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lezione3);

		btn1 = (ImageButton) findViewById(R.id.button1);
		btn2 = (ImageButton) findViewById(R.id.button2);
		btn6 = (ImageButton) findViewById(R.id.button6);

		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn6.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			Intent intent = new Intent(this, CatapultaActivity.class);
			startActivityForResult(intent, GET_VALUE);

			break;

		case R.id.button2:
			Intent intent1 = new Intent(this, SnoopyActivity.class);
			startActivityForResult(intent1, GET_VALUE);

			break;

		case R.id.button6:
			Lezione3Activity.this.finish();

			break;

		}

	}

}