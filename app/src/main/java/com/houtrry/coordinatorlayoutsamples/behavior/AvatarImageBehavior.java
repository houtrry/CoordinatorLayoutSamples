package com.houtrry.coordinatorlayoutsamples.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.houtrry.coordinatorlayoutsamples.utils.DensityUtils;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @author houtrry
 * @version $Rev$
 * @time 2017/9/19 17:40
 * @desc ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDesc $TODO$
 */

public class AvatarImageBehavior extends CoordinatorLayout.Behavior<CircleImageView> {

    private static final String TAG = AvatarImageBehavior.class.getSimpleName();

    private float mFinalX = 8f;
    private float mFinalY = 8f;
    private float mToolBarCriticalY = 0;

    private float mStartX = -1;

    private float mRadiusStart = 60;//开始的时候圆的半径60dp
    private float mRadiusEnd = 10;//开始的时候圆的半径15dp

    public AvatarImageBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        mFinalX = DensityUtils.dip2px(context, mFinalX);
        mFinalY = DensityUtils.dip2px(context, mFinalY);
        mRadiusStart = DensityUtils.dip2px(context, mRadiusStart);
        mRadiusEnd = DensityUtils.dip2px(context, mRadiusEnd);
        mToolBarCriticalY = mRadiusStart + mFinalY;
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, CircleImageView child, View dependency) {
        return dependency instanceof Toolbar;
    }


    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, CircleImageView child, View dependency) {
        Log.d(TAG, "onDependentViewChanged: (" + dependency.getX() + ", " + dependency.getY() + ") === (" + child.getX() + ", " + child.getY() + ")");
        final float dependencyY = dependency.getY();
        final float childY = child.getY();
        Log.d(TAG, "onDependentViewChanged: " + childY + "/" + dependencyY);
        if (dependencyY > mToolBarCriticalY) {
            float currentY = dependencyY - child.getMeasuredHeight() * 0.5f;
            Log.d(TAG, "onDependentViewChanged: currentY: " + currentY);
            child.setY(currentY);


            CoordinatorLayout.LayoutParams childLayoutParams = (CoordinatorLayout.LayoutParams) child.getLayoutParams();
            childLayoutParams.width = (int) (mRadiusStart * 2.0f);
            childLayoutParams.height = (int) (mRadiusStart * 2.0f);
            child.setLayoutParams(childLayoutParams);
        } else {
            float precent = dependencyY / mToolBarCriticalY;
            float progress = (dependencyY / mToolBarCriticalY * (mRadiusStart - mRadiusEnd) + mRadiusEnd) / mRadiusStart;
            Log.d(TAG, "onDependentViewChanged: precent: " + precent + ", progress: " + progress);
            CoordinatorLayout.LayoutParams childLayoutParams = (CoordinatorLayout.LayoutParams) child.getLayoutParams();
            float currentWidth = mRadiusEnd * 2 + (mRadiusStart - mRadiusEnd) * 2 * progress;
            childLayoutParams.width = Math.round(currentWidth);
            childLayoutParams.height = Math.round(currentWidth);
            child.setLayoutParams(childLayoutParams);
            child.setY(mFinalY);

            float currentX = mFinalX + (mStartX - mFinalX) * progress;
            Log.d(TAG, "onDependentViewChanged: mStartX: " + mStartX + ", width: " + childLayoutParams.width + ", currentWidth: " + currentWidth);
            Log.d(TAG, "onDependentViewChanged: currentX/X: " + currentX + "/" + child.getX() + ", mStartX: " + mStartX);
            child.setX(currentX);
        }
        return true;
    }

    private void maybeInitProperties(View child, View dependency) {
        if (mStartX == -1) {
            mStartX = child.getX();
        }
    }
}
