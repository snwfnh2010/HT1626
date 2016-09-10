package com.example.myapplicationtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by snwfnh on 2016/9/8.
 */
public class ItemActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setView();
    }

    private void setView() {
        setContentView(R.layout.activity_item_press);
    }
}
