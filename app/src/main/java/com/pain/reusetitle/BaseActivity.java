package com.pain.reusetitle;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by zhangty on 2017/2/27.
 */

public  class BaseActivity extends AppCompatActivity {
    protected TextView titleTextView;
    protected String title;
    protected int type=0;
    protected static final int TITLEBARONLYBACK=1;
    protected static final String TITLEDEFAULT="复用DEMO";
    protected LinearLayout rootLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.base_layout);
    }

    private void initTop() {
        initTitle();
        initIcon();
    }

    private void initIcon() {
        ImageView backButton= (ImageView) rootLayout.findViewById(R.id.im_back);
        ImageView menuButton=(ImageView) rootLayout.findViewById(R.id.im_other);
        switch (type){
            case TITLEBARONLYBACK:
                menuButton.setVisibility(View.GONE);
                break;
            default:
                backButton.setVisibility(View.GONE);
                menuButton.setVisibility(View.GONE);
                break;
        }
        if (backButton.getVisibility()!=View.GONE){
            backButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    BaseActivity.this.finish();
                }
            });
        }

    }

    private void initTitle() {
        if (title==null){
            title=TITLEDEFAULT;
        }
        titleTextView= (TextView) rootLayout.findViewById(R.id.title);
        titleTextView.setText(title);
    }

    protected void setActivityType(int type,String title){
        this.type=type;
        this.title=title;
    };
    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        setContentView(View.inflate(this,layoutResID,null));
    }

    @Override
    public void setContentView(View view) {
        rootLayout= (LinearLayout) findViewById(R.id.root_layout);
        if (rootLayout==null){
            return;
        }
        rootLayout.addView(view,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        initTop();
    }
}
