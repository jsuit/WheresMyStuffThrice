package com.example.wheresmystuff.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.example.wheresmystuff.R;

public class SplashScreen extends Activity {

	public static final String PARAM_RESULT = "result";
	private Intent nextActivity;
	private String result = "not set", name = "david";
	private int resultImage = 0, retries = 0, currTotal = 0;
	private Animation curAnim;
	private ImageView resultImageView;
	private int images[] = { R.drawable.wheresmystuffimage };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		final SplashScreen ss = this;

		resultImageView = (ImageView) this.findViewById(R.id.splash_image);
		resultImageView.setBackgroundResource(images[0]);

		// TextView text = (TextView)
		// this.findViewById(R.id.result_value_label);
		// text.setText(getResult());
		final splashPresenter myPresenter = new splashPresenter(this);
		Thread mSplashThread = new Thread() {
			@Override
			public void run() {
				synchronized (this) {

					try {
						myPresenter.flipAnimate();
						wait(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				finish();
				Intent intent = new Intent();
				intent.setClass(ss, MainActivity.class);
				startActivity(intent);
			}
		};

		mSplashThread.start();
	}

	public void setResult(String result) {
		this.result = result;
	}

	public ImageView getImageView() {
		return resultImageView;
	}

	public int[] getImages() {
		return images;
	}

}