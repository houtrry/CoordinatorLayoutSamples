package com.houtrry.coordinatorlayoutsamples.ui.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.houtrry.coordinatorlayoutsamples.R;
import com.houtrry.coordinatorlayoutsamples.adapter.CustomAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main19Activity extends AppCompatActivity {


    private static final String TAG = Main19Activity.class.getSimpleName();
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.headerImageView)
    ImageView mHeaderImageView;
    @BindView(R.id.tv_attention_number)
    TextView mTvAttentionNumber;
    @BindView(R.id.btn_attention)
    Button mBtnAttention;
    @BindView(R.id.collapsingToolbarLayout)
    CollapsingToolbarLayout mCollapsingToolbarLayout;
    @BindView(R.id.appBarLayout)
    AppBarLayout mAppBarLayout;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.ll_attentions)
    LinearLayout mLlAttentions;
    private int mAppBarLayoutMeasuredHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main19);
        ButterKnife.bind(this);
        initView();

        initEvent();
    }

    private void initView() {
        initToolBar();
        initRecycler();
    }

    private void initToolBar() {
        mToolbar.setTitle("仿知乎专栏页");
        mToolbar.setNavigationIcon(R.mipmap.icon_arrow_left);
        mToolbar.setNavigationOnClickListener(v -> finish());
        setSupportActionBar(mToolbar);
    }

    private void initRecycler() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        List<String> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add("大漠孤烟直, " + i + " 长河落日圆");
        }
        CustomAdapter customAdapter = new CustomAdapter(data);
        mRecyclerView.setAdapter(customAdapter);
    }

    private void initEvent() {
        mAppBarLayout.addOnOffsetChangedListener(mOnOffsetChangedListener);
    }

    private AppBarLayout.OnOffsetChangedListener mOnOffsetChangedListener = new AppBarLayout.OnOffsetChangedListener() {

        @Override
        public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
            final boolean change = verticalOffset < mDy;
            if (mAppBarLayoutEXPANDED != change) {
                if (mAppBarLayoutEXPANDED) {
                    Log.d(TAG, "onOffsetChanged: 天啊噜, 展开了展开了!");
                    animate(false);
                } else {
                    Log.d(TAG, "onOffsetChanged: 天啊噜, 折叠了折叠了!");
                    animate(true);
                }
                mAppBarLayoutEXPANDED = change;
            }
        }
    };


    private boolean mAppBarLayoutEXPANDED = true;

    private int mDy = 0;

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        mDy = mCollapsingToolbarLayout.getScrimVisibleHeightTrigger() - mCollapsingToolbarLayout.getHeight();
        Log.d(TAG, "onWindowFocusChanged: mDy: " + mDy + ", " + mCollapsingToolbarLayout.getScrimVisibleHeightTrigger() + "/" + mCollapsingToolbarLayout.getHeight());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mAppBarLayout.removeOnOffsetChangedListener(mOnOffsetChangedListener);
        mHeaderImageView.animate().cancel();
        mLlAttentions.animate().cancel();
    }

    private void animate(boolean isGone) {
        mHeaderImageView.animate().cancel();
        mLlAttentions.animate().cancel();
        mHeaderImageView.animate().setDuration(mCollapsingToolbarLayout.getScrimAnimationDuration()).alpha(isGone?0.0f:1.0f).start();
        mLlAttentions.animate().setDuration(mCollapsingToolbarLayout.getScrimAnimationDuration()).alpha(isGone?0.0f:1.0f).start();
    }
}
