package com.example.secondday;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemLongClickListener {
    List<String> mList;
    EditText mEditText;
    ListView mListView;
    MyAdapter mMyAdapter;
    int mPosition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
       setView();
        initView();
        itemListener();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.main,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_del:
                mList.remove(mPosition);
                mMyAdapter.notifyDataSetChanged();
                break;
            case R.id.menu_update:
                AlertDialog.Builder builder=new AlertDialog.Builder(this);
                builder.setTitle("这是修改对话框");
                final EditText editText=new EditText(this);
                editText.setHint("请输入修改后的内容");
                builder.setView(editText);
                builder.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String temp=editText.getText().toString();
                        if(TextUtils.isEmpty(temp))
                            return;
                        mList.set(mPosition,temp);
                        mMyAdapter.notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                break;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private void itemListener() {
        mListView.setOnItemLongClickListener(this);

    }

    public void onClick(View view){
        String temp=mEditText.getText().toString();
        if(TextUtils.isEmpty(temp)){
            Toast.makeText(this,"国家名称不可以为空",Toast.LENGTH_SHORT).show();
            return;
        }
        mList.add(temp);


        mMyAdapter.notifyDataSetChanged();
        mListView.setAdapter(mMyAdapter);
        mEditText.setText("");


    }

    private void init() {
        mList=new ArrayList<>();
        mMyAdapter=new MyAdapter();

    }

    private void initView() {
        mEditText= (EditText) findViewById(R.id.et_enterCountry);
        mListView= (ListView) findViewById(R.id.listView);
    }

    private void setView() {
        setContentView(R.layout.activity_list);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Toast t=Toast.makeText(this,position+"",Toast.LENGTH_SHORT);
        t.setGravity(Gravity.CENTER,0,0);
        t.show();
        mPosition=position;

        return false;
    }

    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {

            return mList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            View convertView =view;
            if(convertView==null) {
                LayoutInflater lf = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView=lf.inflate(android.R.layout.simple_list_item_1,null);
                registerForContextMenu(convertView);
            }
            TextView textView= (TextView) convertView.findViewById(android.R.id.text1);
            textView.setTextSize(40);
            textView.setTextColor(Color.RED);
            textView.setText(mList.get(position));

            return convertView;
        }
    }
}


