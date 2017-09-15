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

public abstract class AppBarStateChangeListener implements AppBarLayout.OnOffsetChangedListener {

    private static final String TAG = AppBarStateChangeListener.class.getSimpleName();

    public enum State {
        EXPANDED,
        COLLAPSED,
        IDLE
    }

    private State mCurrentState = State.IDLE;

    @Override
    public final void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        Log.d(TAG, "onStateChanged onOffsetChanged: : "+verticalOffset+", "+appBarLayout.getTotalScrollRange());
//        if (verticalOffset == 0) {
//            if (mCurrentState != State.EXPANDED) {
//                onStateChanged(appBarLayout, State.EXPANDED);
//            }
//            mCurrentState = State.EXPANDED;
//        } else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
//            if (mCurrentState != State.COLLAPSED) {
//                onStateChanged(appBarLayout, State.COLLAPSED);
//            }
//            mCurrentState = State.COLLAPSED;
//        } else {
//            if (mCurrentState != State.IDLE) {
//                onStateChanged(appBarLayout, State.IDLE);
//            }
//            mCurrentState = State.IDLE;
//        }



        if (verticalOffset == 0) {
            if (mCurrentState != State.EXPANDED) {
                mCurrentState = State.EXPANDED;//修改状态标记为展开
//                collapsingToolbarLayout.setTitle("EXPANDED");//设置title为EXPANDED
                Log.d(TAG, "onOffsetChanged: 已经展开");
            }
        } else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
            if (mCurrentState != State.COLLAPSED) {
//                collapsingToolbarLayout.setTitle("");//设置title不显示
//                playButton.setVisibility(View.VISIBLE);//隐藏播放按钮
                mCurrentState = State.COLLAPSED;//修改状态标记为折叠
                Log.d(TAG, "onOffsetChanged: 已经折叠");
            }
        } else {
            if (mCurrentState != State.IDLE) {
                if(mCurrentState == State.COLLAPSED){
//                    playButton.setVisibility(View.GONE);//由折叠变为中间状态时隐藏播放按钮
                    Log.d(TAG, "onOffsetChanged: 开始展开");
                } else if (mCurrentState == State.EXPANDED) {
                    Log.d(TAG, "onOffsetChanged: 开始折叠");
                }
//                collapsingToolbarLayout.setTitle("INTERNEDIATE");//设置title为INTERNEDIATE
                mCurrentState = State.IDLE;//修改状态标记为中间
            }
        }
    }

    public abstract void onStateChanged(AppBarLayout appBarLayout, State state);
}
