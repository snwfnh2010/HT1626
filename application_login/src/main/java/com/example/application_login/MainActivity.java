package com.example.application_login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn_register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setView();
        initView();
        setListener();

    }

    private void setListener() {
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,ReigisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        btn_register=(Button)findViewById(R.id.btn_reigster);
    }

    private void setView() {
        setContentView(R.layout.activity_main);
    }
}
