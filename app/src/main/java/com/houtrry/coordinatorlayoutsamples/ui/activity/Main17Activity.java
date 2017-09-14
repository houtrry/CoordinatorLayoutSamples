package com.houtrry.coordinatorlayoutsamples.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.houtrry.coordinatorlayoutsamples.R;
import com.houtrry.coordinatorlayoutsamples.adapter.ViewPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main17Activity extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main17);
        ButterKnife.bind(this);

        initView();
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
}
