package com.example.myapplicationtest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by snwfnh on 2016/9/7.
 */
public class PhoneCallActivity extends AppCompatActivity {
    private EditText mEditText;
    private Button mButton;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setView();
        initView();
        setOnListener();
    }

    private void setOnListener() {
        mButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber=mEditText.getText().toString();
                if(phoneNumber.trim().length()!=0){
                    Intent phoneIntent=new Intent(String.valueOf(PhoneCallActivity.this),
                            Uri.parse("tel:"+phoneNumber));
                    startActivity(phoneIntent);
                }else {
                    Toast.makeText(PhoneCallActivity.this,"不能输入为空",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void initView() {
        mEditText= (EditText) findViewById(R.id.edit1);
        mButton= (Button) findViewById(R.id.btn_ok);
    }

    private void setView() {
        setContentView(R.layout.phonecall);
    }
}
