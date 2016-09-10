package com.example.application99;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Created by snwfnh on 2016/9/9.
 */
public class MyLayOut extends LinearLayout {
    

    public interface ICoallBack{
        public void onClickButton(String s);
    }


    ICoallBack mIcallBack = null;


    public void setonClick(ICoallBack iBack)
    {
        mIcallBack = iBack;
    }


    private Context mContext;


    public MyLayOut(Context context) {
        super(context);
        mContext=context;
        this.addView(CreateLayout());
    }

    private View CreateLayout() {
        LinearLayout layout = new LinearLayout(mContext);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT , LayoutParams.WRAP_CONTENT);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setLayoutParams(params);

        final EditText edit = new EditText(mContext);
        LayoutParams editParams = new LayoutParams(LayoutParams.FILL_PARENT , LayoutParams.WRAP_CONTENT);
        edit.setLayoutParams(editParams);

        Button button = new Button(mContext);
        LayoutParams btpParams = new LayoutParams(LayoutParams.WRAP_CONTENT , LayoutParams.WRAP_CONTENT);
        button.setLayoutParams(btpParams);
        button.setText("点击获取");

        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

               mIcallBack.onClickButton(edit.getText().toString());
            }
        });

        layout.addView(edit);
        layout.addView(button);

        return layout;

    }


}
