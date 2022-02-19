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
public class SnoopyActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_snoopy);

		ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
		ImageAdapter adapter = new ImageAdapter(this);
		viewPager.setAdapter(adapter);
	}

	public class ImageAdapter extends PagerAdapter {
		Context context;
		private int[] GalImages = new int[] { R.drawable.snoopy0,
				R.drawable.snoopy1, R.drawable.snoopy2, R.drawable.snoopy3,
				R.drawable.snoopy4, R.drawable.snoopy5, R.drawable.snoopy6,
				R.drawable.snoopy7, R.drawable.snoopy8, R.drawable.snoopy9,
				R.drawable.snoopy10, R.drawable.snoopy11, R.drawable.snoopy12,
				R.drawable.snoopy13, R.drawable.snoopy14, R.drawable.snoopy15,
				R.drawable.snoopy16, R.drawable.snoopy17, R.drawable.snoopy18,
				R.drawable.snoopy19, R.drawable.snoopy20, R.drawable.snoopy21,
				R.drawable.snoopy22, R.drawable.snoopy23, R.drawable.snoopy24,
				R.drawable.snoopy25, R.drawable.snoopy26, R.drawable.snoopy27,
				R.drawable.snoopy28, R.drawable.snoopy29, R.drawable.snoopy31,
				R.drawable.snoopy32, R.drawable.snoopy33, R.drawable.snoopy34,
				R.drawable.snoopy35, R.drawable.snoopy36, R.drawable.snoopy37,
				R.drawable.snoopy38, R.drawable.snoopy39 };

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
				.parse("android.resource://com.developers.legoapp/drawable/snoopy0");
		intent.putExtra(Intent.EXTRA_STREAM, imageUri);

		myShareActionProvider.setShareIntent(intent);

		return true;
	}

}