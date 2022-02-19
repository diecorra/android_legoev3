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
public class BiciActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bici);

		ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
		ImageAdapter adapter = new ImageAdapter(this);
		viewPager.setAdapter(adapter);
	}

	public class ImageAdapter extends PagerAdapter {
		Context context;
		private int[] GalImages = new int[] { R.drawable.bicicletta0,
				R.drawable.bicicletta1, R.drawable.bicicletta2,
				R.drawable.bicicletta3, R.drawable.bicicletta4,
				R.drawable.bicicletta5, R.drawable.bicicletta6,
				R.drawable.bicicletta7, R.drawable.bicicletta8,
				R.drawable.bicicletta9, R.drawable.bicicletta10,
				R.drawable.bicicletta11, R.drawable.bicicletta12,
				R.drawable.bicicletta13, R.drawable.bicicletta14,
				R.drawable.bicicletta15, R.drawable.bicicletta16,
				R.drawable.bicicletta17, R.drawable.bicicletta18 };

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
				.parse("android.resource://com.developers.legoapp/drawable/bicicletta0");
		intent.putExtra(Intent.EXTRA_STREAM, imageUri);

		myShareActionProvider.setShareIntent(intent);

		return true;
	}

}