package com.houtrry.coordinatorlayoutsamples.behavior;


import android.support.design.widget.CoordinatorLayout;
import android.view.View;

/**
 * @author houtrry
 * @version $Rev$
 * @time 2017/9/11 10:35
 * @desc
 * 在自定义Behavior的时候，我们需要关心的两组四个方法，为什么分为两组呢？看一下下面两种情况
 *
 *    某个view监听另一个view的状态变化，例如大小、位置、显示状态等
 *    某个view监听CoordinatorLayout里的滑动状态
 * 对于第一种情况，我们关心的是：
 *    layoutDependsOn和onDependentViewChanged方法，
 * 对于第二种情况，我们关心的是：
 *    onStartNestedScroll和onNestedPreScroll方法。
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDesc $TODO$
 */

public class CustomBehavior extends CoordinatorLayout.Behavior {
    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        return super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, nestedScrollAxes);
    }

    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
    }
}
