package com.houtrry.coordinatorlayoutsamples.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author houtrry
 * @version $Rev$
 * @time 2017/9/11 20:10
 * @desc ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDesc $TODO$
 */

public class ScrollBehavior extends CoordinatorLayout.Behavior<NestedScrollView> {

    public ScrollBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    /**
     * 判断什么情况下, child才需要处理滑动
     * @param coordinatorLayout
     * @param child
     * @param directTargetChild
     * @param target
     * @param nestedScrollAxes
     * @return
     */
    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, NestedScrollView child, View directTargetChild, View target, int nestedScrollAxes) {
        /**
         * 也就是竖直方向的滑动, child需要响应滑动
         */
        return (nestedScrollAxes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
    }

    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, NestedScrollView child, View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
        int scrollY = target.getScrollY();
        child.setScrollY(scrollY);
    }

    @Override
    public boolean onNestedFling(CoordinatorLayout coordinatorLayout, NestedScrollView child, View target, float velocityX, float velocityY, boolean consumed) {
        child.fling((int) velocityX);
        return super.onNestedFling(coordinatorLayout, child, target, velocityX, velocityY, consumed);
    }
}
