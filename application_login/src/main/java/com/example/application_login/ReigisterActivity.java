package com.example.application_login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by snwfnh on 2016/9/5.
 */
public class ReigisterActivity extends AppCompatActivity {
    EditText rePwd;
    EditText reRePwd;
    RadioGroup group;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setView();
        initView();
        setListener();
    }

    private void initView() {
        rePwd = (EditText) findViewById(R.id.et_enterRePwd);
        reRePwd = (EditText) findViewById(R.id.et_enterReRePwd);
        group=(RadioGroup)findViewById(R.id.rg_radioGroup);
    }

    private void setView() {
        setContentView(R.layout.activity_register);
    }

    private void setListener() {
        rePwd.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (rePwd.getText().toString().trim().length() < 6) {
                        Toast.makeText(ReigisterActivity.this, "密码长度不能小于六位", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        reRePwd.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (!reRePwd.getText().toString().trim().equals(rePwd.getText().toString().trim())) {
                        Toast.makeText(ReigisterActivity.this, "两次输入的密码不相等", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int radiobutton=group.getCheckedRadioButtonId();
            }
        });

    }
}
