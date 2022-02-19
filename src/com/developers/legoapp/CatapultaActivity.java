package com.developers.legoapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ShareActionProvider;

@SuppressLint("NewApi")
public class CatapultaActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_catapulta);

		ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
		ImageAdapter adapter = new ImageAdapter(this);
		viewPager.setAdapter(adapter);
	}

	public class ImageAdapter extends PagerAdapter {
		Context context;
		private int[] GalImages = new int[] { R.drawable.catapulta0,
				R.drawable.catapulta1, R.drawable.catapulta2,
				R.drawable.catapulta3, R.drawable.catapulta4,
				R.drawable.catapulta5, R.drawable.catapulta6,
				R.drawable.catapulta7, R.drawable.catapulta8,
				R.drawable.catapulta9, R.drawable.catapulta10,
				R.drawable.catapulta11, R.drawable.catapulta13,
				R.drawable.catapulta14, R.drawable.catapulta15,
				R.drawable.catapulta16, R.drawable.catapulta17,
				R.drawable.catapulta18, R.drawable.catapulta19,
				R.drawable.catapulta20, R.drawable.catapulta21,
				R.drawable.catapulta22, R.drawable.catapulta23,
				R.drawable.catapulta24, R.drawable.catapulta25,
				R.drawable.catapulta26, R.drawable.catapulta27,
				R.drawable.catapulta28, R.drawable.catapulta29,
				R.drawable.catapulta30, R.drawable.catapulta32,
				R.drawable.catapulta33, R.drawable.catapulta34,
				R.drawable.catapulta35, R.drawable.catapulta36,
				R.drawable.catapulta37, R.drawable.catapulta38,
				R.drawable.catapulta39, R.drawable.catapulta40,
				R.drawable.catapulta41, R.drawable.catapulta42,
				R.drawable.catapulta43, R.drawable.catapulta44,
				R.drawable.catapulta45, R.drawable.catapulta46,
				R.drawable.catapulta47, R.drawable.catapulta48,
				R.drawable.catapulta49, R.drawable.catapulta50,
				R.drawable.catapulta51, R.drawable.catapulta52,
				R.drawable.catapulta53, R.drawable.catapulta54,
				R.drawable.catapulta55, R.drawable.catapulta56,
				R.drawable.catapulta57, R.drawable.catapulta58,
				R.drawable.catapulta59, R.drawable.catapulta60,
				R.drawable.catapulta61 };

		ImageAdapter(Context context) {
			this.context = context;
		}

		@Override
		public int getCount() {
			return GalImages.length;
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			return view == ((ImageView) object);
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			ImageView imageView = new ImageView(context);
			int padding = context.getResources().getDimensionPixelSize(
					R.dimen.activity_horizontal_margin);
			imageView.setPadding(padding, padding, padding, padding);
			imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
			imageView.setImageResource(GalImages[position]);
			((ViewPager) container).addView(imageView, 0);
			return imageView;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			((ViewPager) container).removeView((ImageView) object);
		}
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.action_bar_share_menu, menu);
		MenuItem item = menu.findItem(R.id.menu_item_share);
		ShareActionProvider myShareActionProvider = (ShareActionProvider) item
				.getActionProvider();
		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.setType("image/*");

		Uri imageUri = Uri
				.parse("android.resource://com.developers.legoapp/drawable/catapulta0");
		intent.putExtra(Intent.EXTRA_STREAM, imageUri);

		myShareActionProvider.setShareIntent(intent);

		return true;
	}

}