package com.houtrry.coordinatorlayoutsamples.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.houtrry.coordinatorlayoutsamples.utils.AnimateUtiils;

/**
 * @author houtrry
 * @version $Rev$
 * @time 2017/9/13 9:49
 * @desc ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDesc $TODO$
 */

public class ScaleUpArrowBehavior extends FloatingActionButton.Behavior {

    private static final String TAG = ScaleUpArrowBehavior.class.getSimpleName();
    private boolean mIsAnimatingOut = false;
    private boolean mIsAnimatingIn = false;

    public ScaleUpArrowBehavior() {
    }

    public ScaleUpArrowBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View directTargetChild, View target, int nestedScrollAxes) {
        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL;
    }


    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);

        if (dyConsumed > 0 && dyUnconsumed == 0 ) {
            Log.d(TAG, "onNestedScroll: 上滑中");
            hideFloatActionButtion(child);
        } else if (dyConsumed < 0 && dyUnconsumed == 0) {
            Log.d(TAG, "onNestedScroll: 下滑中");
            showFloatActionButtion(child);
        } else if (dyConsumed == 0 && dyUnconsumed > 0) {
            Log.d(TAG, "onNestedScroll: 到了底部, 还在上滑");
            hideFloatActionButtion(child);
        } else if (dyConsumed == 0 && dyUnconsumed < 0) {
            Log.d(TAG, "onNestedScroll: 到了顶部, 还在下滑");
            showFloatActionButtion(child);
        }
        Log.d(TAG, "onNestedScroll: dyConsumed: "+dyConsumed+", dyUnconsumed: "+dyUnconsumed);
    }

    private void showFloatActionButtion(View view){
        if (mIsAnimatingIn) {
            Log.d(TAG, "showFloatActionButtion: current is showing");
            return;
        }
        AnimateUtiils.scaleWithAlpha(view, 1.0f, 500, new ViewPropertyAnimatorListener() {
            @Override
            public void onAnimationStart(View view) {
                mIsAnimatingIn = true;
            }

            @Override
            public void onAnimationEnd(View view) {
                mIsAnimatingIn = false;
            }

            @Override
            public void onAnimationCancel(View view) {
                mIsAnimatingIn = false;
            }
        });
    }

    private void hideFloatActionButtion(View view){
        if (mIsAnimatingOut) {
            Log.e(TAG, "hideFloatActionButtion: current is hiding");
            return;
        }
        AnimateUtiils.scaleWithAlpha(view, 0.0f, 500, new ViewPropertyAnimatorListener() {
            @Override
            public void onAnimationStart(View view) {
                mIsAnimatingOut = true;
            }

            @Override
            public void onAnimationEnd(View view) {
                mIsAnimatingOut = false;
            }

            @Override
            public void onAnimationCancel(View view) {
                mIsAnimatingOut = false;
            }
        });
    }
}
