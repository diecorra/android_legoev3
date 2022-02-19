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
public class RallyActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rally);

		ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
		ImageAdapter adapter = new ImageAdapter(this);
		viewPager.setAdapter(adapter);
	}

	public class ImageAdapter extends PagerAdapter {
		Context context;
		private int[] GalImages = new int[] { R.drawable.mrally0,
				R.drawable.mrally1, R.drawable.mrally2, R.drawable.mrally3,
				R.drawable.mrally4, R.drawable.mrally5, R.drawable.mrally6,
				R.drawable.mrally7, R.drawable.mrally8, R.drawable.mrally9,
				R.drawable.mrally10, R.drawable.mrally11, R.drawable.mrally12,
				R.drawable.mrally13, R.drawable.mrally14, R.drawable.mrally15,
				R.drawable.mrally16, R.drawable.mrally17, R.drawable.mrally18,
				R.drawable.mrally19, R.drawable.mrally20, R.drawable.mrally21,
				R.drawable.mrally22, R.drawable.mrally23, R.drawable.mrally24,
				R.drawable.mrally25, R.drawable.mrally26, R.drawable.rally27,
				R.drawable.rally28 };

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
				.parse("android.resource://com.developers.legoapp/drawable/mrally0");
		intent.putExtra(Intent.EXTRA_STREAM, imageUri);

		myShareActionProvider.setShareIntent(intent);

		return true;
	}

}