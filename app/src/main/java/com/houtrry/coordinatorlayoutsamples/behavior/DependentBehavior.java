package com.houtrry.coordinatorlayoutsamples.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

/**
 * @author houtrry
 * @version $Rev$
 * @time 2017/9/11 19:49
 * @desc ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDesc $TODO$
 */


public class DependentBehavior extends CoordinatorLayout.Behavior<View> {
    public DependentBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     *
     * @param parent
     * @param child         需要随dependency变化而变化的View
     * @param dependency    这里是被依赖.
     * @return
     */
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof ImageView;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        final int offset = dependency.getTop() - child.getTop();
        ViewCompat.offsetTopAndBottom(child, offset);
        return true;
    }
}
