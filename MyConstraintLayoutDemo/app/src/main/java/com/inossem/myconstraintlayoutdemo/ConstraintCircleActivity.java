package com.inossem.myconstraintlayoutdemo;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import de.hdodenhof.circleimageview.CircleImageView;

public class ConstraintCircleActivity extends AppCompatActivity {

    private CircleImageView iv1;
    private CircleImageView iv2;
    private CircleImageView iv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout4);

        iv1 = findViewById(R.id.cir1);
        iv2 = findViewById(R.id.cir2);
        iv3 = findViewById(R.id.cir3);


        final ValueAnimator valueAnimator2 = ValueAnimator.ofFloat(0f, 1f);
        valueAnimator2.setDuration(10000L);
        valueAnimator2.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator2.setInterpolator(new LinearInterpolator());

        final ValueAnimator valueAnimator3 = ValueAnimator.ofFloat(0f, 1f);
        valueAnimator3.setDuration(2000L);
        valueAnimator3.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator3.setInterpolator(new LinearInterpolator());

        valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                ConstraintLayout.LayoutParams layoutParam = (ConstraintLayout.LayoutParams) iv2.getLayoutParams();
                layoutParam.circleAngle = 45 + animation.getAnimatedFraction() * 360;
                iv3.requestLayout();
            }
        });


        valueAnimator3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                ConstraintLayout.LayoutParams layoutParam = (ConstraintLayout.LayoutParams) iv3.getLayoutParams();
                layoutParam.circleAngle = 270 + animation.getAnimatedFraction() * 360;
                iv3.requestLayout();
            }
        });

        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueAnimator2.start();
                valueAnimator3.start();
            }
        });
    }
}
