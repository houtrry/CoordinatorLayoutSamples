package com.houtrry.coordinatorlayoutsamples.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.houtrry.coordinatorlayoutsamples.R;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.houtrry.coordinatorlayoutsamples.R.id.toolbar;


public class Main6Activity extends AppCompatActivity {

    @BindView(toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        ButterKnife.bind(this);

        mToolbar.setTitle("测试CollapsingToolbarLayout");
//        mToolbar.setBackgroundColor(Color.TRANSPARENT);
        setSupportActionBar(mToolbar);

    }
}
