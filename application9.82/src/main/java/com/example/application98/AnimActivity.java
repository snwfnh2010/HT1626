package com.example.application98;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by snwfnh on 2016/9/8.
 */
public class AnimActivity extends AppCompatActivity {
    private GridView gridView;
    private MyAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lists.add(R.drawable.ic_launcher);
        lists.add(R.drawable.ic_launcher);
        lists.add(R.drawable.ic_launcher);
       // this.gridView = (GridView) this.findViewById(R.id.);
        adapter = new MyAdapter();
        this.gridView.setAdapter(adapter);

        this.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int id, long arg3) {
                // TODO Auto-generated method stub
                MyAdapter ad = (MyAdapter) arg0.getAdapter();
                ad.setNotifyDataChange(id);
            }
        });
    }

    private List<Integer> lists = new ArrayList<Integer>();

    private class MyAdapter extends BaseAdapter {
        private int selectPic = -1;

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return lists.size();
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return lists.get(position);
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        public void setNotifyDataChange(int id) {
            selectPic = id;
            super.notifyDataSetChanged();
        }

        @SuppressLint("NewApi")
        @Override
        public View getView(int position, View view, ViewGroup arg2) {
            ImageView img = new ImageView(AnimActivity.this);
            img.setBackgroundResource(lists.get(position));
            if (selectPic == position) {

                Animation testAnim = AnimationUtils.loadAnimation(AnimActivity.this, R.anim.anim);

                img.startAnimation(testAnim);

            } else {
                // the rest
                img.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            }

            return img;
        }
    }
}
