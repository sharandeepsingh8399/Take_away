package com.example.sharan.take_away;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class menu extends AppCompatActivity {

    ImageView iview1,iview2,iview3,iview4,iview5,iview6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        iview1= (ImageView) findViewById(R.id.iv1);
        iview2= (ImageView) findViewById(R.id.iv2);
        iview3= (ImageView) findViewById(R.id.iv3);
        iview4= (ImageView) findViewById(R.id.iv4);
        iview5= (ImageView) findViewById(R.id.iv5);
        iview6= (ImageView) findViewById(R.id.iv6);

        iview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(menu.this,dis.class);
                startActivity(i);
            }
        });

        iview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(menu.this,dis.class);
                startActivity(i);
            }
        });

        iview3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(menu.this,dis.class);
                startActivity(i);
            }
        });

        iview4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(menu.this,dis.class);
                startActivity(i);
            }
        });

        iview5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(menu.this,dis.class);
                startActivity(i);
            }
        });

        iview6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(menu.this,dis.class);
                startActivity(i);
            }
        });
    }
}
