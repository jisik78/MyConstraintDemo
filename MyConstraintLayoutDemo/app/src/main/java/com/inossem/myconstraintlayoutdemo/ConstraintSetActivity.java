package com.inossem.myconstraintlayoutdemo;

import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

public class ConstraintSetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout9);
    }

    public void onClick(View view) {

        TransitionManager.beginDelayedTransition((ViewGroup) view); //  动画效果，不加则没有缓慢移动动画效果   API19开始就有了

        ConstraintSet set = new ConstraintSet();
        set.clone((ConstraintLayout) LayoutInflater.from(ConstraintSetActivity.this).inflate(R.layout.layout9_2, null));
        set.applyTo((ConstraintLayout) view);

    }
}
