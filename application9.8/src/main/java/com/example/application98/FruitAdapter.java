package com.example.application98;

import android.content.Context;
import android.support.v4.view.LayoutInflaterFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by snwfnh on 2016/9/8.
 */
public class FruitAdapter extends ArrayAdapter<Fruit> {
    private int resourceId;

    public FruitAdapter(Context context, int textViewResourceId, List<Fruit> objects) {
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Fruit fruit=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resourceId,null);
        ImageView fruitImage= (ImageView) view.findViewById(R.id.fruit_image);
        TextView fruitName= (TextView) view.findViewById(R.id.fruit_name);
        fruitImage.setImageResource(fruit.getImageId());
        fruitName.setText(fruit.getName());



        return view;
    }
}
