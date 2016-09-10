package com.example.secondday;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by snwfnh on 2016/9/6.
 */
public class DrawerLayoutActivity extends AppCompatActivity {
    ListView mListView;
    TextView mTextView;

//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setView();
//        initView();
//        setAdapter();
//        setItemListener();
//    }

    private void setItemListener() {
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mTextView.setText(((TextView) view).getText().toString());
            }
        });
    }

    private void setAdapter() {
        mListView.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                new String[]{"ABC", "DEF", "HIJ"}));
    }


//    private void initView() {
//        mListView= (ListView) findViewById(R.id.lv_drawerLayout);
//        mTextView= (TextView) findViewById(R.id.tv_showText);
//    }
//
//    private void setView() {
//        setContentView(R.layout.activity_drawer);
//    }
}
