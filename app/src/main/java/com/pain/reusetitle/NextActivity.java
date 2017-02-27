package com.pain.reusetitle;

import android.os.Bundle;

public class NextActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setActivityType(this.TITLEBARONLYBACK,"Next页面");
        setContentView(R.layout.activity_next);
    }
}
