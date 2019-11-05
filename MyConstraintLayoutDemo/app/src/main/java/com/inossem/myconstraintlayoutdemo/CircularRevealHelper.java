package com.inossem.myconstraintlayoutdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewAnimationUtils;

import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;

public class CircularRevealHelper  extends ConstraintHelper {
    public CircularRevealHelper(Context context) {
        this(context , null);
    }

    public CircularRevealHelper(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CircularRevealHelper(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public void updatePostLayout(ConstraintLayout container) {
        super.updatePostLayout(container);
        int[] referencedIds = getReferencedIds();
        for (int referencedId : referencedIds) {

            View view = container.getViewById(referencedId);
            double radius = (int )Math.hypot(view.getWidth(), view.getHeight());

            ViewAnimationUtils.createCircularReveal(view, 0, 0, 0f, (float) radius)
                    .setDuration(2000L)
                    .start();
        }
    }

}
