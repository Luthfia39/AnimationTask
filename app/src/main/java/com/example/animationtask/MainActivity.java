package com.example.animationtask;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{
    ImageView left_1, left_2, road, right_1, right_2;
    TextView letsGoTxt;
    ObjectAnimator animator_tree_1, animator_tree_2, animator_car,
            animator_tree_3, animator_tree_4, text_scaleX, text_scaleY;
    AnimatorSet animatorObject = new AnimatorSet();
    AnimatorSet animatorText = new AnimatorSet();
    AnimatorSet animatorSet = new AnimatorSet();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialization
        left_1 = findViewById(R.id.left_tree_1);
        left_2 = findViewById(R.id.left_tree_2);
        road = findViewById(R.id.road);
        right_1 = findViewById(R.id.right_tree_1);
        right_2 = findViewById(R.id.right_tree_2);
        letsGoTxt = findViewById(R.id.lets_go);

        // animate the tree to swipe down
        animator_tree_1 = ObjectAnimator.ofFloat(left_1,
                "y", 800, 1500);
        animateObject(animator_tree_1);

        animator_tree_2 = ObjectAnimator.ofFloat(left_2,
                "y", 0, 700);
        animateObject(animator_tree_2);

        animator_tree_3 = ObjectAnimator.ofFloat(right_1,
                "y", 1000, 1700);
        animateObject(animator_tree_3);

        animator_tree_4 = ObjectAnimator.ofFloat(right_2,
                "y", 400, 1100);
        animateObject(animator_tree_4);

        // animate the car to swipe up
        animator_car = ObjectAnimator.ofFloat(road,
                "y", 1200, (-200));
        animateObject(animator_car);

        // setting trees and car animator to play together
        animatorObject.play(animator_tree_1).with(animator_tree_2).with(animator_tree_3)
                .with(animator_tree_4).with(animator_car);

        // animator to scale the text
        text_scaleX = ObjectAnimator.ofFloat(letsGoTxt, "scaleX", 0, 2);
        animateText(text_scaleX);
        text_scaleY = ObjectAnimator.ofFloat(letsGoTxt, "scaleY", 0, 2);
        animateText(text_scaleY);
        animatorText.play(text_scaleX).with(text_scaleY);

        // setting objects (trees and car) animator to start after text animator end
        animatorSet.play(animatorObject).after(animatorText);
        // start the animator
        animatorSet.start();
    }

    // function for setting the object animator
    private void animateObject(ObjectAnimator animator){
        animator.setDuration(4000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.RESTART);
    }

    // function for setting the text animator
    private void animateText(ObjectAnimator animator){
        animator.setDuration(8000);
        animator.setRepeatCount(1);
        animator.setRepeatMode(ValueAnimator.REVERSE);
    }
}