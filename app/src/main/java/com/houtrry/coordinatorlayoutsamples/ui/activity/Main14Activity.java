package com.houtrry.coordinatorlayoutsamples.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.houtrry.coordinatorlayoutsamples.R;
import com.houtrry.coordinatorlayoutsamples.adapter.CustomAdapter;
import com.houtrry.coordinatorlayoutsamples.behavior.TranslationYUpArrowBehavior;
import com.houtrry.coordinatorlayoutsamples.utils.AnimateUtiils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main14Activity extends AppCompatActivity {

    private static final String TAG = Main14Activity.class.getSimpleName();
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.appBarLayout)
    AppBarLayout mAppBarLayout;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.button1)
    Button mButton1;
    @BindView(R.id.button2)
    Button mButton2;
    @BindView(R.id.button3)
    Button mButton3;
    @BindView(R.id.button4)
    Button mButton4;
    @BindView(R.id.floatingActionButton)
    FloatingActionButton mFloatingActionButton;
    @BindView(R.id.tabs)
    LinearLayout mTabs;
    private BottomSheetBehavior mBottomSheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main14);
        ButterKnife.bind(this);
        initView();
        initEvent();
    }

    private void initView() {
        initToolBar();
        initRecyclerView();
    }

    private void initToolBar() {
        mToolbar.setTitle("仿知乎效果");
        mToolbar.setTitleTextColor(Color.WHITE);
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

    private void initEvent() {
        mBottomSheetBehavior = BottomSheetBehavior.from(mTabs);
        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        TranslationYUpArrowBehavior translationYUpArrowBehavior = TranslationYUpArrowBehavior.from(mFloatingActionButton);
        translationYUpArrowBehavior.setOnFloatActionListener(isShow -> {
            if (isShow) {
                mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            } else {
                mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }
        });
    }

    @OnClick(R.id.floatingActionButton)
    public void clickFloatingActionButton(View view) {
        Snackbar.make(view, "我就来看看", Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
//        hideFloatingActionButton();
//        showTabs();
    }

    private boolean mHasShowTabs = false;
    private void showTabs() {
        if (mHasShowTabs) {
            Log.e(TAG, "showTabs: tabs has show");
            return;
        }
        mHasShowTabs = true;
        if (mBottomSheetBehavior == null) {
            mBottomSheetBehavior = BottomSheetBehavior.from(mTabs);
        }
        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
    }

    private boolean mHasHideFloatingActionButton = false;
    private void hideFloatingActionButton() {
        if (mHasHideFloatingActionButton) {
            Log.e(TAG, "hideFloatingActionButton: ");
            return;
        }
        mHasHideFloatingActionButton = true;
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) mFloatingActionButton.getLayoutParams();
        AnimateUtiils.translationYWithAlpha(mFloatingActionButton, layoutParams.height + layoutParams.bottomMargin, 300, null);
    }
}
