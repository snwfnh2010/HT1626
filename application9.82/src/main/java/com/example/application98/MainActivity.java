package com.example.application98;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView mTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView= (TextView) findViewById(R.id.text5);
        mTextView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

           }
       });
    }
}
