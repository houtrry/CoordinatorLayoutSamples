package com.houtrry.coordinatorlayoutsamples.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.houtrry.coordinatorlayoutsamples.R;
import com.houtrry.coordinatorlayoutsamples.adapter.CustomAdapter;
import com.houtrry.coordinatorlayoutsamples.utils.AnimateUtiils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main13Activity extends AppCompatActivity {

    private static final String TAG = Main13Activity.class.getSimpleName();

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.appBarLayout)
    AppBarLayout mAppBarLayout;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.floatingActionButton)
    FloatingActionButton mFloatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main13);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        initToolBar();
        initRecyclerView();
    }

    private void initToolBar() {
        mToolbar.setTitleTextColor(Color.WHITE);
        mToolbar.setTitle("返回到顶部");
        setSupportActionBar(mToolbar);
    }

    private void initRecyclerView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        List<String> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add("大漠孤烟直, " + i + " 长河落日圆");
        }
        CustomAdapter customAdapter = new CustomAdapter(data);
        mRecyclerView.setAdapter(customAdapter);
    }

    @OnClick(R.id.floatingActionButton)
    public void clickFloatActionButton(View view) {
        mRecyclerView.getLayoutManager().scrollToPosition(0);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        Log.d(TAG, "onWindowFocusChanged: hasFocus: "+hasFocus);
        hideFloatActionButton();
    }

    private boolean mHasHideFloatActionButton = false;
    private void hideFloatActionButton() {
        if (mHasHideFloatActionButton) {
            Log.e(TAG, "hideFloatActionButtion: current is hiding");
            return;
        }
        mHasHideFloatActionButton = true;
        AnimateUtiils.scaleWithAlpha(mFloatingActionButton, 0.0f, 1000, null);
    }
}
