package com.example.sharan.take_away;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;

/**
 * Created by sharan on 28-Sep-16.
 */
public class Splashscreen extends AppCompatActivity {

   // ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        ImageView img=(ImageView)findViewById(R.id.imageView);
        Animation anim= AnimationUtils.loadAnimation(this, R.anim.anim_down);
        img.setAnimation(anim);
        //anim.start();



        Handler handler=new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run() {
                startActivity(new Intent(Splashscreen.this,MainActivity.class));
                finish();
            }
        },3000);
    }
}
