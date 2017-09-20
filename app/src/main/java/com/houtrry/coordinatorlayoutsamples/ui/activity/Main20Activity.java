package com.houtrry.coordinatorlayoutsamples.ui.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.houtrry.coordinatorlayoutsamples.R;
import com.houtrry.coordinatorlayoutsamples.utils.AnimateUtiils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main20Activity extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener {

    private static final String TAG = Main20Activity.class.getSimpleName();

    @BindView(R.id.ll_titles)
    LinearLayout mLlTitles;
    @BindView(R.id.titles)
    FrameLayout mTitles;
    @BindView(R.id.appBarLayout)
    AppBarLayout mAppBarLayout;
    @BindView(R.id.toolbarTitle)
    TextView mToolbarTitle;

    private static final long ALPHA_ANIMATE_DURATION = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main20);
        ButterKnife.bind(this);

        initView();
        initEvent();
    }

    private void initView() {

    }

    private void initEvent() {
        mAppBarLayout.addOnOffsetChangedListener(this);
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        final int totalScrollRange = appBarLayout.getTotalScrollRange();
        final float progress = Math.abs(verticalOffset) * 1.0f / totalScrollRange;

        Log.d(TAG, "onOffsetChanged: orogress: " + progress);

        if (isShow(mLlTitles) && progress > 0.3f) {
            AnimateUtiils.alpha(mLlTitles, 0.0f, ALPHA_ANIMATE_DURATION);
        } else if (!isShow(mLlTitles) && progress <= 0.3f) {
            AnimateUtiils.alpha(mLlTitles, 1.0f, ALPHA_ANIMATE_DURATION);
        }

        if (isShow(mToolbarTitle) && progress < 0.9f) {
            AnimateUtiils.alpha(mToolbarTitle, 0.0f, ALPHA_ANIMATE_DURATION);
        } else if (!isShow(mToolbarTitle) && progress >= 0.9f) {
            AnimateUtiils.alpha(mToolbarTitle, 1.0f, ALPHA_ANIMATE_DURATION);
        }
    }

    private boolean isShow(View view) {
        return view.getAlpha() == 1.0f;
    }
}
