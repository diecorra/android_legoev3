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
public class GruActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gru);

		ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
		ImageAdapter adapter = new ImageAdapter(this);
		viewPager.setAdapter(adapter);
	}

	public class ImageAdapter extends PagerAdapter {
		Context context;
		private int[] GalImages = new int[] { R.drawable.gru16,
				R.drawable.gru1, R.drawable.gru2, R.drawable.gru3,
				R.drawable.gru4, R.drawable.gru5, R.drawable.gru6,
				R.drawable.gru7, R.drawable.gru8, R.drawable.gru9,
				R.drawable.gru10, R.drawable.gru11, R.drawable.gru12,
				R.drawable.gru13, R.drawable.gru14, R.drawable.gru15,
				R.drawable.gru16, R.drawable.gru17 };

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
				.parse("android.resource://com.developers.legoapp/drawable/gru16");
		intent.putExtra(Intent.EXTRA_STREAM, imageUri);

		myShareActionProvider.setShareIntent(intent);

		return true;
	}

}