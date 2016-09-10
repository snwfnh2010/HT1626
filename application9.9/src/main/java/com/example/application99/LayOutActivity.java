package com.example.application99;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by snwfnh on 2016/9/9.
 */
public class LayOutActivity extends Activity {
    MyLayOut mMyLayOut;
    TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setView();
        initView();
        setOnListener();
    }

    private void setOnListener() {
       mMyLayOut.setonClick(new MyLayOut.ICoallBack() {
           @Override
           public void onClickButton(String s) {
               mTextView.setText(s);
           }
       });

    }

    private void initView() {
        mMyLayOut= (MyLayOut) findViewById(R.id.mylayout);
        mTextView= (TextView) findViewById(R.id.text_my);
    }

    private void setView() {
        setContentView(R.layout.activity_mylayout);
    }
}
