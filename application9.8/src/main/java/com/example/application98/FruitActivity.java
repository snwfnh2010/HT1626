package com.example.application98;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by snwfnh on 2016/9/8.
 */
public class FruitActivity extends AppCompatActivity{
    private String[] fruit;
    private ListView mListView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        setView();
        initView();
        setAdapter();
    }

    private void initView() {
        mListView= (ListView) findViewById(R.id.list_view);
    }

    private void setAdapter() {
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(FruitActivity.this,
                android.R.layout.simple_list_item_1,fruit);
        mListView.setAdapter(adapter);
    }

    private void init() {
        fruit=new String[]{"Apple","Banana","Orange","Watermelon","Pear","Grape","Pineapple",
        "Strawberry","Cherry","Mango"};
    }

    private void setView() {
        setContentView(R.layout.activity_fruit);
    }
}
