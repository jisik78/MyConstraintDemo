package com.inossem.myconstraintlayoutdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Placeholder;

import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

public class PlaceHolderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout8);
    }

    public void onClick(View v) {
        TransitionManager.beginDelayedTransition((ViewGroup) v.getParent());   //  动画效果，不加则没有缓慢移动动画效果
        Placeholder placeholder = findViewById(R.id.placeholder);
        placeholder.setContentId(v.getId());

    }
}
