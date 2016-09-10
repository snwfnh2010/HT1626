package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_login;
    Button btn_register;
    Button btn_change;
    ImageView iv_image;
    ProgressBar pb_bar;
    EditText et_enterPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setView();
        initView();
        setListener();

    }

    private void setListener() {
       btn_login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast t=Toast.makeText(MainActivity.this,"Button被单击了",Toast.LENGTH_SHORT);
               t.show();
           }
       });
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });
        btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_image.setImageResource(R.drawable.ic_baidu);
                pb_bar.setVisibility(View.VISIBLE);
            }
        });
      et_enterPwd.setOnFocusChangeListener(new View.OnFocusChangeListener() {
          @Override
          public void onFocusChange(View v, boolean hasFocus) {
              if(et_enterPwd.getText().toString().trim().length()<4)
                  Toast.makeText(MainActivity.this,"密码长度不能小于4",Toast.LENGTH_SHORT).show();
          }
      });
    }

    private void initView() {
        btn_login=(Button) findViewById(R.id.btn_login);
        btn_register=(Button)findViewById(R.id.btn_register);
        iv_image=(ImageView)findViewById(R.id.iv_image);
        btn_change=(Button)findViewById(R.id.btn_change);
        pb_bar=(ProgressBar)findViewById(R.id.pb_bar);
        et_enterPwd=(EditText)findViewById(R.id.et_entryPwd);

    }

    private void setView() {

        setContentView(R.layout.activity_main);
    }
}
