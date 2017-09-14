package com.houtrry.coordinatorlayoutsamples.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.houtrry.coordinatorlayoutsamples.utils.AnimateUtiils;

/**
 * @author houtrry
 * @version $Rev$
 * @time 2017/9/13 14:00
 * @desc ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDesc $TODO$
 */

public class TranslationYUpArrowBehavior extends FloatingActionButton.Behavior {

    private static final String TAG = TranslationYUpArrowBehavior.class.getSimpleName();
    private boolean mIsAnimationUp = false;
    private boolean mIsAnimationDown = false;

    public TranslationYUpArrowBehavior() {
    }

    public TranslationYUpArrowBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View directTargetChild, View target, int nestedScrollAxes) {
        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL;
    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);

        if (dyConsumed > 0 && dyUnconsumed == 0) {
            Log.d(TAG, "onNestedScroll: 上滑中");
            downFloatActionButtion(child);
        } else if (dyConsumed < 0 && dyUnconsumed == 0) {
            Log.d(TAG, "onNestedScroll: 下滑中");
            upFloatActionButtion(child);
        } else if (dyConsumed == 0 && dyUnconsumed > 0) {
            Log.d(TAG, "onNestedScroll: 到了底部, 还在上滑");
            downFloatActionButtion(child);
        } else if (dyConsumed == 0 && dyUnconsumed < 0) {
            Log.d(TAG, "onNestedScroll: 到了顶部, 还在下滑");
            upFloatActionButtion(child);
        }
    }

    private void upFloatActionButtion(View child) {
        if (mIsAnimationUp) {
            Log.e(TAG, "upFloatActionButtion: current is Animation up");
            return;
        }
        AnimateUtiils.translationYWithAlpha(child, 0f, 500, new ViewPropertyAnimatorListener() {
            @Override
            public void onAnimationStart(View view) {
                mIsAnimationUp = true;
                if (mOnFloatActionListener != null) {
                    mOnFloatActionListener.display(true);
                }
            }

            @Override
            public void onAnimationEnd(View view) {
                mIsAnimationUp = false;
            }

            @Override
            public void onAnimationCancel(View view) {
                mIsAnimationUp = false;
            }
        });
    }

    private void downFloatActionButtion(FloatingActionButton child) {
        if (mIsAnimationDown) {
            Log.e(TAG, "upFloatActionButtion: current is Animation up");
            return;
        }
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) child.getLayoutParams();
        final float translationY = layoutParams.height+layoutParams.bottomMargin;
        AnimateUtiils.translationYWithAlpha(child, translationY, 500, new ViewPropertyAnimatorListener() {
            @Override
            public void onAnimationStart(View view) {
                mIsAnimationDown = true;
                if (mOnFloatActionListener != null) {
                    mOnFloatActionListener.display(false);
                }
            }

            @Override
            public void onAnimationEnd(View view) {
                mIsAnimationDown = false;
            }

            @Override
            public void onAnimationCancel(View view) {
                mIsAnimationDown = false;
            }
        });
    }

    private OnFloatActionListener mOnFloatActionListener;

    public void setOnFloatActionListener(OnFloatActionListener onFloatActionListener) {
        mOnFloatActionListener = onFloatActionListener;
    }

    public interface OnFloatActionListener {
        void display(boolean isShow);
    }


    public static <V extends View> TranslationYUpArrowBehavior from(V view) {
        ViewGroup.LayoutParams params = view.getLayoutParams();
        if (!(params instanceof CoordinatorLayout.LayoutParams)) {
            throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        }
        CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) params).getBehavior();
        if (!(behavior instanceof TranslationYUpArrowBehavior)) {
            throw new IllegalArgumentException(
                    "The view is not associated with TranslationYUpArrowBehavior");
        }
        return (TranslationYUpArrowBehavior) behavior;
    }
}
