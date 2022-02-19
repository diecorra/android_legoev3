package com.developers.legoapp;

import com.developers.legoapp.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class LezioniRoboticaActivity extends Activity implements
		OnClickListener {

	public final static int GET_VALUE = 1;
	public static String VALUE = "value";

	ImageButton btn1, btn2, btn3, btn4, btn5, btn6;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lezioni);
		btn1 = (ImageButton) findViewById(R.id.button1);
		btn2 = (ImageButton) findViewById(R.id.button2);
		btn3 = (ImageButton) findViewById(R.id.button3);
		btn4 = (ImageButton) findViewById(R.id.button4);
		btn5 = (ImageButton) findViewById(R.id.button5);
		btn6 = (ImageButton) findViewById(R.id.button6);

		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		btn4.setOnClickListener(this);
		btn5.setOnClickListener(this);
		btn6.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			Intent intent = new Intent(this, Lezione1Activity.class);
			startActivityForResult(intent, GET_VALUE);

			break;

		case R.id.button2:
			Intent intent1 = new Intent(this, Lezione2Activity.class);
			startActivityForResult(intent1, GET_VALUE);

			break;

		case R.id.button3:
			Intent intent2 = new Intent(this, Lezione3Activity.class);
			startActivityForResult(intent2, GET_VALUE);

			break;

		case R.id.button4:
			Intent intent3 = new Intent(this, Lezione4Activity.class);
			startActivityForResult(intent3, GET_VALUE);

			break;

		case R.id.button5:
			Intent intent4 = new Intent(this, Lezione5Activity.class);
			startActivityForResult(intent4, GET_VALUE);

			break;
		case R.id.button6:
			LezioniRoboticaActivity.this.finish();

			break;
		}

	}
}