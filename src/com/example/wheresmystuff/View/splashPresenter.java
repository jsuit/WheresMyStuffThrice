package com.example.wheresmystuff.View;

import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

public class splashPresenter {
	private Animation curAnim;
	private SplashScreen s;
	private ScaleAnimation shrink;
	
	public splashPresenter(SplashScreen sc) {
		// TODO Auto-generated constructor stub
		s = sc;
		curAnim = new ScaleAnimation(1, 0, 1, 1,
				Animation.RELATIVE_TO_SELF, (float) 0.5,
				Animation.RELATIVE_TO_SELF, (float) .5);
	}


	public void flipAnimate() {
		
		pflipAnimate(s.getImageView(), s.getImages(), 0, 10, true);
	
	}

	
	private void pflipAnimate(final ImageView imageView, final int images[],
			final int imageIndex, final int iterations, final boolean isShrunk) {

		if (iterations > 0) {
			
			ScaleAnimation shrink = new ScaleAnimation(1, 0, 1, 1,
					Animation.RELATIVE_TO_SELF, (float) 0.5,
					Animation.RELATIVE_TO_SELF, (float) .5);
			ScaleAnimation expand = new ScaleAnimation(0, 1, 1, 1,
					Animation.RELATIVE_TO_SELF, (float) 0.5,
					Animation.RELATIVE_TO_SELF, (float) .5);

			if (isShrunk) {
				curAnim = expand;
				imageView.setBackgroundResource(images[0]);
			} else {
				curAnim = shrink;
				imageView.setBackgroundResource(images[0]);
			}

			curAnim.setDuration(300);

			imageView.setAnimation(curAnim);

			curAnim.setAnimationListener(new AnimationListener() {
				public void onAnimationEnd(Animation animation) {
					Log.d("during flipAnimate", "i = something");
					int newIndex = imageIndex;
					if (isShrunk) {
						if (imageIndex == 1) {
							newIndex = 0;
						} else {
							newIndex = 1;
						}
					}

					pflipAnimate(imageView, images, newIndex, iterations - 1,
							!isShrunk);
				}

				public void onAnimationRepeat(Animation animation) {
					// TODO Auto-generated method stub
				}

				public void onAnimationStart(Animation animation) {
					// TODO Auto-generated method stub
				}
				
			});
			
		}
	}
}
