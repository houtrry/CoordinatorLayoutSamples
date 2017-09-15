package com.houtrry.coordinatorlayoutsamples.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.houtrry.coordinatorlayoutsamples.R;
import com.houtrry.coordinatorlayoutsamples.adapter.ViewPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main18Activity extends AppCompatActivity {

    @BindView(R.id.imageView)
    ImageView mImageView;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.appBarLayout)
    AppBarLayout mAppBarLayout;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    @BindView(R.id.floatingActionButton)
    FloatingActionButton mFloatingActionButton;
    @BindView(R.id.collapsingToolbarLayout)
    CollapsingToolbarLayout mCollapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main18);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        initToolBar();
        initViewPager();
    }

    private void initToolBar() {
        mToolbar.setNavigationIcon(R.mipmap.icon_arrow_left);
//        mToolbar.setTitleMarginStart(0);
        setSupportActionBar(mToolbar);
    }

    private void initViewPager() {
        String[] titleStrings = new String[]{"个人主页", "信息详情"};
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), titleStrings);

        mViewPager.setAdapter(viewPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabTextColors(Color.GRAY, Color.WHITE);
    }
}
