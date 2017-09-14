package com.houtrry.coordinatorlayoutsamples.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.houtrry.coordinatorlayoutsamples.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main4Activity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        ButterKnife.bind(this);

        mToolbar.setTitle("测试一下Toolbar");
        mToolbar.setSubtitle("这是副标题");
        mToolbar.setLogo(R.mipmap.ic_launcher_round);
        setSupportActionBar(mToolbar);
    }
}
