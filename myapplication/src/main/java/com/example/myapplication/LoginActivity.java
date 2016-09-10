package com.example.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by snwfnh on 2016/9/7.
 */
public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setView();
    }

    private void setView() {
        setContentView(R.layout.activity_login);
    }
}
