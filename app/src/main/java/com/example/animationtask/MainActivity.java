package com.example.animationtask;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView left_1, left_2, road, right_1, right_2;
    ObjectAnimator animator_tree_1, animator_tree_2, animator_car,
            animator_tree_3, animator_tree_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        left_1 = findViewById(R.id.left_tree_1);
        left_2 = findViewById(R.id.left_tree_2);
        road = findViewById(R.id.road);
        right_1 = findViewById(R.id.right_tree_1);
        right_2 = findViewById(R.id.right_tree_2);

        animator_tree_1 = ObjectAnimator.ofFloat(left_1,
                "y", 800f, 1500f);
        animate(animator_tree_1);

        animator_tree_2 = ObjectAnimator.ofFloat(left_2,
                "y", 0f, 700f);
        animate(animator_tree_2);

        animator_tree_3 = ObjectAnimator.ofFloat(right_1,
                "y", 1000f, 1700f);
        animate(animator_tree_3);

        animator_tree_4 = ObjectAnimator.ofFloat(right_2,
                "y", 400f, 1100f);
        animate(animator_tree_4);

        animator_car = ObjectAnimator.ofFloat(road,
                "y", 1600f, 0f);
        animate(animator_car);
    }

    private void animate(ObjectAnimator animator){
        animator.setDuration(4000);
        animator.start();
        animator.setRepeatCount(100);
        animator.setRepeatMode(ValueAnimator.RESTART);
    }
}