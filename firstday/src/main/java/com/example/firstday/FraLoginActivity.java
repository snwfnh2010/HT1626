package com.example.firstday;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by snwfnh on 2016/9/7.
 */
public class FraLoginActivity extends AppCompatActivity {
    ListView mListView;
    EditText mEditText;
    Button mButton;
    int mPosition;
    List<String> mList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inti();
        setView();
        initView();
        setAdapter();
        setItemListener();
        
    }
    public void onClick(View view){
        String temp=mEditText.getText().toString();
        if(TextUtils.isEmpty(temp)){
            Toast.makeText(this,"用户名不可以为空",Toast.LENGTH_SHORT).show();
            return;
        }
        mList.add(temp);

        mListView.setAdapter(new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                new String[]{temp}
        ));
        mEditText.setText("");


    }

    private void inti() {
        mList=new ArrayList<>();
    }

    private void setItemListener() {
    }

    private void setAdapter() {
    }

    private void initView() {
        mEditText= (EditText) findViewById(R.id.username);
        mListView= (ListView) findViewById(R.id.lv_layout);
        mButton= (Button) findViewById(R.id.login);
    }

    private void setView() {
        setContentView(R.layout.activity_fralogin);
    }
}
