package com.houtrry.coordinatorlayoutsamples;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.houtrry.coordinatorlayoutsamples.adapter.CustomAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main12Activity extends AppCompatActivity {

    @BindView(R.id.btnShowBottomSheetDialog)
    Button mBtnShowBottomSheetDialog;
    private BottomSheetDialog mBottomSheetDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main12);
        ButterKnife.bind(this);
        initBottomSheetDialog();
    }

    private void initBottomSheetDialog() {
        mBottomSheetDialog = new BottomSheetDialog(this);
        View view = LayoutInflater.from(this).inflate(R.layout.layout_recycler, null,false);
        mBottomSheetDialog.setContentView(view);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        List<String> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add("大漠孤烟直, " + i + " 长河落日圆");
        }
        CustomAdapter customAdapter = new CustomAdapter(data);
        recyclerView.setAdapter(customAdapter);
        refreshBehaviorState();
    }

    @OnClick(R.id.btnShowBottomSheetDialog)
    public void onClick(View view) {
        showBottomSheetDialog();
    }

    private void showBottomSheetDialog() {
        if (mBottomSheetDialog == null) {
            initBottomSheetDialog();
        }
        if (mBottomSheetDialog.isShowing()) {
            mBottomSheetDialog.dismiss();
        } else {
            mBottomSheetDialog.show();
        }
    }

    private void refreshBehaviorState() {
        FrameLayout bottomSheet = (FrameLayout) mBottomSheetDialog.getDelegate().findViewById(R.id.design_bottom_sheet);
        BottomSheetBehavior mBehavior = BottomSheetBehavior.from(bottomSheet);
        mBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                    mBottomSheetDialog.cancel();
                    mBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
    }
}
