package com.developers.legoapp;

//importiamo tutte le librerie necessarie
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
public class AltalenaActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// impostiamo che il contenuto della classe farà riferimento ad il file
		// xml
		setContentView(R.layout.activity_altalena);

		// dichiariamo un nuovo oggetto di tipo ViewPager
		ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);

		// dichiariamo un nuovo oggetto di tipo ImageAdapter per creare la
		// galleria con le immagini
		ImageAdapter adapter = new ImageAdapter(this);
		viewPager.setAdapter(adapter);
	}

	public class ImageAdapter extends PagerAdapter {
		Context context;
		// inizializziamo un array che contiene tutte le immagini
		private int[] GalImages = new int[] { R.drawable.altalena0,
				R.drawable.altalena1, R.drawable.altalena2,
				R.drawable.altalena3, R.drawable.altalena4,
				R.drawable.altalena5, R.drawable.altalena6,
				R.drawable.altalena7, R.drawable.altalena8,
				R.drawable.altalena9, R.drawable.altalena10,
				R.drawable.altalena11, R.drawable.altalena12,
				R.drawable.altalena13, R.drawable.altalena14,
				R.drawable.altalena15, R.drawable.altalena16,
				R.drawable.altalena17, R.drawable.altalena18,
				R.drawable.altalena19, R.drawable.altalena20,
				R.drawable.altalena21, R.drawable.altalena22,
				R.drawable.altalena23 };

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

	// alla pressione del tasto menu si potranno condividere le immagini
	// principali
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.action_bar_share_menu, menu);
		MenuItem item = menu.findItem(R.id.menu_item_share);
		ShareActionProvider myShareActionProvider = (ShareActionProvider) item
				.getActionProvider();
		// creazione di un intent
		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.setType("image/*");

		// andiamo a selezionare l'immagine principale della galleria
		Uri imageUri = Uri
				.parse("android.resource://com.developers.legoapp/drawable/altalena0");
		// condividiamo l'immagine
		intent.putExtra(Intent.EXTRA_STREAM, imageUri);

		myShareActionProvider.setShareIntent(intent);

		return true;
	}

}