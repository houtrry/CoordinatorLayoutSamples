package com.houtrry.coordinatorlayoutsamples.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * @author houtrry
 * @version $Rev$
 * @time 2017/9/14 19:23
 * @desc ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDesc $TODO$
 */

public class ZhihuPersonDetailBehavior extends CoordinatorLayout.Behavior {

    private static final String TAG = ZhihuPersonDetailBehavior.class.getSimpleName();

    public ZhihuPersonDetailBehavior() {
    }

    public ZhihuPersonDetailBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL;
    }

    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
        Log.d(TAG, "onNestedPreScroll: child: "+child+", target: "+target+", dx: "+dx+", dy: "+dy+", consumed: "+consumed);
    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
        Log.d(TAG, "onNestedPreScroll: child: "+child+", target: "+target+", dxConsumed: "+dxConsumed+", dyConsumed: "+dyConsumed+", dxUnconsumed: "+dxUnconsumed+", dyUnconsumed: "+dyUnconsumed);
    }
}
