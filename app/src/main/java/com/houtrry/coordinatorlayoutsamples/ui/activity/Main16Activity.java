package com.houtrry.coordinatorlayoutsamples.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.houtrry.coordinatorlayoutsamples.R;
import com.houtrry.coordinatorlayoutsamples.adapter.ViewPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main16Activity extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main16);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        initToolBar();
        initViewPager();
    }

    private void initToolBar() {
        mToolbar.setTitle("结合ViewPager和ToolBar");
        mToolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(mToolbar);
    }

    private void initViewPager() {
        String[] titleStrings = new String[]{"主页", "微博", "相册"};
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), titleStrings);

        mViewPager.setAdapter(viewPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabTextColors(Color.GRAY, Color.WHITE);
    }

    @OnClick({R.id.floatingActionButton})
    public void clickFloatingActionBar(View view) {
        Snackbar.make(mFloatingActionButton, "天啊噜, 你竟然又打我!", Snackbar.LENGTH_SHORT).show();
    }
}
