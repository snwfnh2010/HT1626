package com.example.application98;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

/**
 * Created by snwfnh on 2016/9/9.
 */
public class HobbyActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
   private TextView mTextView;
    private CheckBox cb1;
    private CheckBox cb2;
    private CheckBox cb3;
    private CheckBox cb4;
    private StringBuilder mStringBuilder;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        setView();
        initView();
        setFaceType();
        setListener();



    }

    private void setListener() {
        cb1.setOnCheckedChangeListener(this);
        cb2.setOnCheckedChangeListener(this);
        cb3.setOnCheckedChangeListener(this);
        cb4.setOnCheckedChangeListener(this);
    }

    private void setFaceType() {
        AssetManager am=getAssets();
        Typeface tf=Typeface.createFromAsset(am,"font/STXINGKA.TTF");
        mTextView.setTypeface(tf);
    }

    private void initView() {
        mTextView= (TextView) findViewById(R.id.textview_hobby);
        cb1= (CheckBox) findViewById(R.id.cb_eat);
        cb2= (CheckBox) findViewById(R.id.cb_drink);
        cb3= (CheckBox) findViewById(R.id.cb_play);
        cb4= (CheckBox) findViewById(R.id.cb_happy);

    }

    private void init() {
        mStringBuilder=new StringBuilder();
    }

    private void setView() {
        setContentView(R.layout.activity_hobby);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        String temp=buttonView.getText().toString();
        if(isChecked)
            mStringBuilder.append(temp);
        else
            mStringBuilder.delete(mStringBuilder.indexOf(temp),mStringBuilder.indexOf(temp)+temp.length());
        if (mStringBuilder.length()==0)
            mTextView.setText("兴趣爱好");
        else
            mTextView.setText(mStringBuilder.toString());

    }
}
