package com.houtrry.coordinatorlayoutsamples.ui.activity;

import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;

import com.houtrry.coordinatorlayoutsamples.R;

public class Main9Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        findViewById(R.id.depentent).setOnClickListener(v -> ViewCompat.offsetTopAndBottom(v, 5));
    }
}
