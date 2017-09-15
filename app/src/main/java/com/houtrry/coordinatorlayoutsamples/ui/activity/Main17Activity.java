package com.houtrry.coordinatorlayoutsamples.ui.activity;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.houtrry.coordinatorlayoutsamples.R;
import com.houtrry.coordinatorlayoutsamples.adapter.ViewPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main17Activity extends AppCompatActivity {

    private static final String TAG = Main17Activity.class.getSimpleName();

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.headerImageView)
    ImageView mHeaderImageView;
    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.appBarLayout)
    AppBarLayout mAppBarLayout;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    @BindView(R.id.collapsingToolbarLayout)
    CollapsingToolbarLayout mCollapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main17);
        ButterKnife.bind(this);

        initView();

        initEvent();
    }

    private void initView() {
        initToolBar();
        initViewPager();
    }

    private void initToolBar() {
        mToolbar.setTitle("仿知乎效果--个人详情");
        mToolbar.setTitleTextColor(Color.WHITE);
        mToolbar.setNavigationIcon(R.mipmap.icon_arrow_left);
        setSupportActionBar(mToolbar);
    }

    private void initViewPager() {
        String[] titleStrings = new String[]{"个人主页", "信息详情"};
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), titleStrings);

        mViewPager.setAdapter(viewPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabTextColors(Color.GRAY, Color.WHITE);
    }

    private void initEvent() {
        //        mAppBarLayout.addOnOffsetChangedListener(new AppBarStateChangeListener() {
        //            @Override
        //            public void onStateChanged(AppBarLayout appBarLayout, State state) {
        //                if (state == State.EXPANDED) {
        //
        //                    //展开状态
        //                    Log.d(TAG, "onStateChanged: 展开状态");
        //                } else if (state == State.COLLAPSED) {
        //
        //                    //折叠状态
        //                    Log.d(TAG, "onStateChanged: 折叠状态");
        //                } else {
        //
        //                    //中间状态
        //                    Log.d(TAG, "onStateChanged: 中间状态");
        //                }
        //            }
        //        });

        final int dy = mCollapsingToolbarLayout.getScrimVisibleHeightTrigger() - mCollapsingToolbarLayout.getHeight();
        Log.d(TAG, "initEvent: dy: "+dy+", "+mCollapsingToolbarLayout.getScrimVisibleHeightTrigger()+"/"+mCollapsingToolbarLayout.getHeight());
        mAppBarLayout.addOnOffsetChangedListener((appBarLayout, verticalOffset) -> {
            boolean change = verticalOffset < mDy;
            Log.d(TAG, "onOffsetChanged:  "+verticalOffset+"/"+mDy);
            if (verticalOffset == -mCollapsingToolbarLayout.getHeight() + mToolbar.getHeight()) {
                //toolbar is collapsed here
                //write your code here
                Log.d(TAG, "onOffsetChanged: 天啊噜, 折叠了折叠了!");
            }
            if (mAppBarLayoutEXPANDED != change) {
                if (mAppBarLayoutEXPANDED) {
                    Log.d(TAG, "onOffsetChanged: 天啊噜, 展开了展开了!");

                    mHeaderImageView.setVisibility(View.VISIBLE);
                    animate(false);
//                        mTabLayout.setBackgroundColor(Color.TRANSPARENT);
                } else {
                    Log.d(TAG, "onOffsetChanged: 天啊噜, 折叠了折叠了!");
//                        mTabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                    mHeaderImageView.setVisibility(View.GONE);
                    animate(true);
                }
                mAppBarLayoutEXPANDED = change;
            }
        });
    }


    private boolean mAppBarLayoutEXPANDED = true;

    private int mDy = 0;
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        mDy = mCollapsingToolbarLayout.getScrimVisibleHeightTrigger() - mCollapsingToolbarLayout.getHeight();
        Log.d(TAG, "onWindowFocusChanged: mDy: "+mDy+", "+mCollapsingToolbarLayout.getScrimVisibleHeightTrigger()+"/"+mCollapsingToolbarLayout.getHeight());
    }

    private void animate(boolean isGone) {
        int colorFrom = Color.TRANSPARENT;
        int colorTo = getResources().getColor(R.color.colorPrimaryDark);
        ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), isGone?colorFrom:colorTo, isGone?colorTo:colorFrom);
        colorAnimation.setInterpolator(!isGone? new FastOutLinearInInterpolator()
                : new LinearOutSlowInInterpolator());
        colorAnimation.setEvaluator(new ArgbEvaluator());
        colorAnimation.setDuration(mCollapsingToolbarLayout.getScrimAnimationDuration()); // milliseconds
        colorAnimation.addUpdateListener(animator -> mTabLayout.setBackgroundColor((int) animator.getAnimatedValue()));
        colorAnimation.start();
    }
}
