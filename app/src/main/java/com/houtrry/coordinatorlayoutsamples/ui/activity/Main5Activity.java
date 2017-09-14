package com.houtrry.coordinatorlayoutsamples.ui.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.houtrry.coordinatorlayoutsamples.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main5Activity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.appBarLayout)
    AppBarLayout mAppBarLayout;
    @BindView(R.id.textView)
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        ButterKnife.bind(this);

        mToolbar.setTitle("测试AppBarLayout");
        setSupportActionBar(mToolbar);
    }
}
