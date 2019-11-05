package com.inossem.myconstraintlayoutdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private String mTag = "activity_main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mTag);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setContentView(mTag);
    }

    public void show(View v) {

        String tag = (String) v.getTag();
        if ("layout4".equals(tag)) {
            Intent intent = new Intent(MainActivity.this, ConstraintCircleActivity.class);
            startActivity(intent);
            return;
        } else if ("layout8".equals(tag)) {
            Intent intent = new Intent(MainActivity.this, PlaceHolderActivity.class);
            startActivity(intent);
            return;
        } else if ("layout9".equals(tag)) {
            Intent intent = new Intent(MainActivity.this, ConstraintSetActivity.class);
            startActivity(intent);
            return;
        } else if ("layout10".equals(tag)) {
            Intent intent = new Intent(MainActivity.this, FlowActivity.class);
            startActivity(intent);
            return;

        }
        mTag = (String) v.getTag();
        setContentView(mTag);
    }

    @Override
    public void onBackPressed() {
        if (!mTag.equals("activity_main")) {
            mTag = "activity_main";
            setContentView(mTag);
        } else {
            super.onBackPressed();
        }
    }

//    public void showConstraintSetExample(View view) {
//        startActivity(new Intent(this, ConstraintSetExampleActivity.class));
//    }

    private void setContentView(String tag) {
        int id = getResources().getIdentifier(tag, "layout", getPackageName());
        setContentView(id);
    }
}
