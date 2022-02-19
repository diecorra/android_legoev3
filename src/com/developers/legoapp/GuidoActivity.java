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
public class GuidoActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activitiy_guido);

		ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
		ImageAdapter adapter = new ImageAdapter(this);
		viewPager.setAdapter(adapter);
	}

	public class ImageAdapter extends PagerAdapter {
		Context context;
		private int[] GalImages = new int[] { R.drawable.guido53,
				R.drawable.guido1, R.drawable.guido2, R.drawable.guido3,
				R.drawable.guido4, R.drawable.guido5, R.drawable.guido6,
				R.drawable.guido7, R.drawable.guido8, R.drawable.guido9,
				R.drawable.guido10, R.drawable.guido11, R.drawable.guido12,
				R.drawable.guido14, R.drawable.guido15, R.drawable.guido16,
				R.drawable.guido17, R.drawable.guido18, R.drawable.guido19,
				R.drawable.guido20, R.drawable.guido21, R.drawable.guido22,
				R.drawable.guido23, R.drawable.guido24, R.drawable.guido25,
				R.drawable.guido26, R.drawable.guido27, R.drawable.guido28,
				R.drawable.guido29, R.drawable.guido30, R.drawable.guido31,
				R.drawable.guido32, R.drawable.guido33, R.drawable.guido36,
				R.drawable.guido37, R.drawable.guido38, R.drawable.guido39,
				R.drawable.guido40, R.drawable.guido41, R.drawable.guido42,
				R.drawable.guido43, R.drawable.guido45, R.drawable.guido46,
				R.drawable.guido47, R.drawable.guido48, R.drawable.guido49,
				R.drawable.guido50, R.drawable.guido51, R.drawable.guido52,
				R.drawable.guido53, R.drawable.guido54, R.drawable.guido55 };

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
				.parse("android.resource://com.developers.legoapp/drawable/guido53");
		intent.putExtra(Intent.EXTRA_STREAM, imageUri);

		myShareActionProvider.setShareIntent(intent);

		return true;
	}

}