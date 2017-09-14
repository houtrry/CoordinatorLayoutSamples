package com.houtrry.coordinatorlayoutsamples.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.houtrry.coordinatorlayoutsamples.R;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startAty(Class clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    public void test01(View view) {
        startAty(Main3Activity.class);
    }

    public void test02(View view) {
        startAty(Main2Activity.class);
    }

    public void test03(View view) {
        startAty(Main4Activity.class);
    }

    public void test05(View view) {
        startAty(Main5Activity.class);
    }

    public void test06(View view) {
        startAty(Main6Activity.class);
    }

    public void test07(View view) {
        startAty(Main7Activity.class);
    }

    public void test08(View view) {
        startAty(Main8Activity.class);
    }

    public void test09(View view) {
        startAty(Main9Activity.class);
    }

    public void test10(View view) {
        startAty(Main10Activity.class);
    }

    public void test11(View view) {
        startAty(Main11Activity.class);
    }

    public void test12(View view) {
        startAty(Main12Activity.class);
    }

    public void test13(View view) {
        startAty(Main13Activity.class);
    }

    public void test14(View view) {
        startAty(Main14Activity.class);
    }

    public void test15(View view) {
        startAty(Main15Activity.class);
    }

    public void test16(View view) {
        startAty(Main16Activity.class);
    }

    public void test17(View view) {
        startAty(Main17Activity.class);
    }
}
