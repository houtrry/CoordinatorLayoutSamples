package com.houtrry.coordinatorlayoutsamples;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.houtrry.coordinatorlayoutsamples.adapter.CustomAdapter;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main8Activity extends AppCompatActivity {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.appBarLayout)
    AppBarLayout mAppBarLayout;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.ll_bottom)
    LinearLayout mLlBottom;
    @BindView(R.id.floatingActionButton)
    FloatingActionButton mFloatingActionButton;
    @BindView(R.id.collapsingToolbarLayout)
    CollapsingToolbarLayout mCollapsingToolbarLayout;
    private MyHandler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        ButterKnife.bind(this);


        initView();
        initData();
        initEvent();
    }

    private void initView() {
        mToolbar.setTitle("风萧萧兮易水寒");
        mCollapsingToolbarLayout.setTitle("壮士一去兮不复还");
        /**
         * 设置展开后, 文字的颜色
         */
        mCollapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
//        mCollapsingToolbarLayout.setTitleEnabled(false);
        /**
         * 设置合起来时, Title的背景色
         */
        mCollapsingToolbarLayout.setContentScrimColor(Color.YELLOW);
        /**
         * 设置合起来时, Title的文字的颜色
         */
        mCollapsingToolbarLayout.setCollapsedTitleTextColor(Color.GREEN);

        mCollapsingToolbarLayout.setStatusBarScrimColor(Color.TRANSPARENT);
        setSupportActionBar(mToolbar);
        initRecycler();

    }

    private void initRecycler() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        List<String> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add("大漠孤烟直, " + i + " 长河落日圆");
        }
        CustomAdapter customAdapter = new CustomAdapter(data);
        mRecyclerView.setAdapter(customAdapter);

        mSwipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        mHandler.sendEmptyMessage(STOP_REFRESHING);
                    }
                }).start();
            }
        });

    }

    private void initData() {
        mHandler = new MyHandler(this);
    }

    private void initEvent() {
        mFloatingActionButton.setOnClickListener(v -> Toast.makeText(this, "天啊噜, 有人点击按钮啦!", Toast.LENGTH_SHORT).show());
    }

    public void stopRefresh() {
        mSwipeRefreshLayout.setRefreshing(false);
    }

    private static final int STOP_REFRESHING = 817;

    private static class MyHandler extends Handler {
        private static final String TAG = MyHandler.class.getSimpleName();
        private WeakReference<Main8Activity> mMainActivityWeakReference;

        public MyHandler(Main8Activity mainActivity) {
            mMainActivityWeakReference = new WeakReference<>(mainActivity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Main8Activity mainActivity = mMainActivityWeakReference.get();
            if (mainActivity == null || mainActivity.isFinishing()) {
                Log.e(TAG, "handleMessage: mainActivity: " + mainActivity);
                return;
            }
            switch (msg.what) {
                case STOP_REFRESHING: {
                    mainActivity.stopRefresh();
                    break;
                }
            }
        }
    }
}
