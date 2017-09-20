package com.houtrry.coordinatorlayoutsamples.utils;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;

/**
 * @author houtrry
 * @version $Rev$
 * @time 2017/9/13 10:04
 * @desc ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDesc $TODO$
 */

public class AnimateUtiils {

    private static Interpolator ACCELERATE_DECELERATE = new AccelerateDecelerateInterpolator();

    public static void scaleWithAlpha(View view, float scale, long duration, ViewPropertyAnimatorListener listener) {
        ViewCompat.animate(view).cancel();
        ViewCompat.animate(view).scaleX(scale).scaleY(scale).alpha(scale)
                .setInterpolator(ACCELERATE_DECELERATE).setDuration(duration)
                .setListener(listener).start();
    }

    public static void translationYWithAlpha(View view, float translationY, long duration, ViewPropertyAnimatorListener listener) {
        ViewCompat.animate(view).cancel();
        ViewCompat.animate(view).translationY(translationY).alpha(translationY == 0 ? 1.0f : 0.0f)
                .setInterpolator(ACCELERATE_DECELERATE).setDuration(duration)
                .setListener(listener).start();
    }

    public static void alpha(View view, float alpha, long duration) {
        ViewCompat.animate(view).cancel();
        ViewCompat.animate(view).alpha(alpha)
                .setInterpolator(ACCELERATE_DECELERATE).setDuration(duration).start();
    }

    public static void alpha(View view, float alpha, long duration, ViewPropertyAnimatorListener listener) {
        ViewCompat.animate(view).cancel();
        ViewCompat.animate(view).alpha(alpha)
                .setInterpolator(ACCELERATE_DECELERATE).setDuration(duration)
                .setListener(listener).start();
    }
}
