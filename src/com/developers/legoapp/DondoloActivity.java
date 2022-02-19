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
public class DondoloActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dondolo);

		ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
		ImageAdapter adapter = new ImageAdapter(this);
		viewPager.setAdapter(adapter);
	}

	public class ImageAdapter extends PagerAdapter {
		Context context;
		private int[] GalImages = new int[] { R.drawable.dondolo0,
				R.drawable.dondolo1, R.drawable.dondolo2, R.drawable.dondolo3,
				R.drawable.dondolo4, R.drawable.dondolo5, R.drawable.dondolo6,
				R.drawable.dondolo7, R.drawable.dondolo8, R.drawable.dondolo9,
				R.drawable.dondolo10, R.drawable.dondolo11,
				R.drawable.dondolo12, R.drawable.dondolo13,
				R.drawable.dondolo14, R.drawable.dondolo15,
				R.drawable.dondolo16, R.drawable.dondolo17,
				R.drawable.dondolo18, R.drawable.dondolo19,
				R.drawable.dondolo20, R.drawable.dondolo21,
				R.drawable.dondolo22, R.drawable.dondolo23,
				R.drawable.dondolo24, R.drawable.dondolo25,
				R.drawable.dondolo26, R.drawable.dondolo27,
				R.drawable.dondolo28, R.drawable.dondolo29,
				R.drawable.dondolo30, R.drawable.dondolo31,
				R.drawable.dondolo32, R.drawable.dondolo33,
				R.drawable.dondolo34 };

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
				.parse("android.resource://com.developers.legoapp/drawable/dondolo0");
		intent.putExtra(Intent.EXTRA_STREAM, imageUri);

		myShareActionProvider.setShareIntent(intent);

		return true;
	}

}