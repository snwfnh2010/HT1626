package com.example.secondday;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by snwfnh on 2016/9/9.
 */
public class RecyclerViewActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        setView();
        initView();
        initRecyclerView();
    }

    private void initView() {
        mRecyclerView= (RecyclerView) findViewById(R.id.recycler_view);
    }

    private void initRecyclerView() {
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager=new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        
    }

    private void init() {
        List<String> list=new ArrayList<>();
        for (int i=0;i<10;i++){
            list.add(i+"");
        }
        mAdapter=new MyAdapter(list);
    }
    class MyAdapter extends RecyclerView.Adapter<RecyclerViewActivity.MyAdapter.MyViewHolder>{
        List<String> mDateSet;
        public MyAdapter( List<String> list){
            mDateSet=list;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater= (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view=inflater.inflate(android.R.layout.simple_list_item_1,null);
            MyViewHolder mv=new MyViewHolder(view);



            return mv;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.tv.setText(mDateSet.get(position));

        }

        @Override
        public int getItemCount() {
            return mDateSet.size();
        }


        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView tv;
            public MyViewHolder(View itemView) {
                super(itemView);
                tv= (TextView) itemView.findViewById(android.R.id.text1);
            }
        }
    }

    private void setView() {
        setContentView(R.layout.activity_recyclerview);
    }


}
