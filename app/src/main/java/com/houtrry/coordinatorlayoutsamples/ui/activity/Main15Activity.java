package com.houtrry.coordinatorlayoutsamples.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.houtrry.coordinatorlayoutsamples.R;
import com.houtrry.coordinatorlayoutsamples.adapter.ViewPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main15Activity extends AppCompatActivity {

    @BindView(R.id.imageView)
    ImageView mImageView;
    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    @BindView(R.id.floatingActionButton)
    FloatingActionButton mFloatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main15);
        ButterKnife.bind(this);
        initView();

        initEvent();
    }

    private void initView() {
        initViewPager();
    }

    private void initViewPager() {
        String[] titleStrings = new String[]{"主页", "微博", "相册"};
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), titleStrings);

        mViewPager.setAdapter(viewPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void initEvent() {

    }
}
