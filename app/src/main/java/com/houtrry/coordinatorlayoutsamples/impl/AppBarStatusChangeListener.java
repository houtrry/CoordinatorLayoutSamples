package com.houtrry.coordinatorlayoutsamples.impl;

import android.support.design.widget.AppBarLayout;
import android.util.Log;

/**
 * @author houtrry
 * @version $Rev$
 * @time 2017/9/15 16:22
 * @desc ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDesc $TODO$
 */

public abstract class AppBarStatusChangeListener implements AppBarLayout.OnOffsetChangedListener {

    private static final String TAG = AppBarStatusChangeListener.class.getSimpleName();

    public enum State {
        EXPANDED,
        COLLAPSED,
        IDLE
    }

    private State mCurrentState = State.IDLE;

    @Override
    public final void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        Log.d(TAG, "onStateChanged onOffsetChanged: : "+verticalOffset+", "+appBarLayout.getTotalScrollRange());
        if (verticalOffset == 0) {
            if (mCurrentState != State.EXPANDED) {
                onStateChanged(appBarLayout, State.EXPANDED);
            }
            mCurrentState = State.EXPANDED;
        } else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
            if (mCurrentState != State.COLLAPSED) {
                onStateChanged(appBarLayout, State.COLLAPSED);
            }
            mCurrentState = State.COLLAPSED;
        } else {
            if (mCurrentState != State.IDLE) {
                onStateChanged(appBarLayout, State.IDLE);
            }
            mCurrentState = State.IDLE;
        }

    }

    public abstract void onStateChanged(AppBarLayout appBarLayout, State state);
}
