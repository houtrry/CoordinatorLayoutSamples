package com.houtrry.coordinatorlayoutsamples.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

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

    private float mFinalX = 50f;
    public AvatarImageBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, CircleImageView child, View dependency) {
        return dependency instanceof Toolbar;
    }


    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, CircleImageView child, View dependency) {
        Log.d(TAG, "onDependentViewChanged: ("+dependency.getX()+", "+dependency.getY()+") === ("+child.getX()+", "+child.getY()+")");
        final float dependencyY = dependency.getY();
        final float childY = child.getY();
        Log.d(TAG, "onDependentViewChanged: "+childY+"/"+dependencyY);
        if (childY > 50) {
            child.setY(dependencyY - child.getMeasuredHeight() * 0.5f);
        } else {

            float precent = dependencyY/50f;
            child.setX(child.getX());
        }
        return true;
    }
}
