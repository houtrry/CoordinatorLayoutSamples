package com.houtrry.coordinatorlayoutsamples.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.houtrry.coordinatorlayoutsamples.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main11Activity extends AppCompatActivity {

    private static final String TAG = Main11Activity.class.getSimpleName();

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.appBarLayout)
    AppBarLayout mAppBarLayout;
    @BindView(R.id.toggleButton)
    Button mToggleButton;
    @BindView(R.id.tab1)
    Button mTab1;
    @BindView(R.id.tab2)
    Button mTab2;
    @BindView(R.id.tab3)
    Button mTab3;
    @BindView(R.id.tab4)
    Button mTab4;
    @BindView(R.id.tab_layout)
    LinearLayout mTabLayout;
    private BottomSheetBehavior<LinearLayout> mBottomSheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        mToolbar.setTitle("测试bottom_sheet_behavior");
        mToolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(mToolbar);

        mBottomSheetBehavior = BottomSheetBehavior.from(mTabLayout);
        /**
         * 注意: 25.0.1需要使用BottomSheetBehavior.setPeekHeight(0)或者在xml中使用app:behavior_peekHeight="0dp", 否则的话, setState没有效果.
         * sdk24时需要使用app:behavior_hideable="true" 这个待确定
         */
        //        mBottomSheetBehavior.setPeekHeight(0);
    }

    @OnClick({R.id.toggleButton, R.id.tab1, R.id.tab2, R.id.tab3, R.id.tab4})
    public void onClick(View view) {
        final int viewId = view.getId();
        if (viewId == R.id.toggleButton) {
            toggleBottom();
        } else {
            showToast(((Button) view).getText().toString().trim());
        }
    }

    private void toggleBottom() {
        final int currentState = mBottomSheetBehavior.getState();
        Log.d(TAG, "toggleBottom: currentState: "+currentState);
        if (currentState == BottomSheetBehavior.STATE_EXPANDED) {
            Log.d(TAG, "toggleBottom: current state is STATE_EXPANDED(3), toggle to STATE_COLLAPSED(4)");
            mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        } else if (currentState == BottomSheetBehavior.STATE_COLLAPSED) {
            Log.d(TAG, "toggleBottom: current state is STATE_COLLAPSED(4), toggle to STATE_EXPANDED(3)");
            mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        }
        final int newState = mBottomSheetBehavior.getState();
        Log.d(TAG, "toggleBottom: newState: "+newState);

//        if (mBottomSheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
//            mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
//        } else if (mBottomSheetBehavior.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
//            mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
//        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


}
