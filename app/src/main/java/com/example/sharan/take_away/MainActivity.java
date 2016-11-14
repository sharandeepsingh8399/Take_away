package com.example.sharan.take_away;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper helper=new DatabaseHelper(this);
    Button b1,b2;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        b1= (Button) findViewById(R.id.button1);
        b2= (Button) findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,SignUP.class);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText a = (EditText) findViewById(R.id.ed);
                String str = a.getText().toString();
                EditText b = (EditText) findViewById(R.id.ed1);

                String pass = b.getText().toString();

                String password = helper.searchpass(str);
                if (pass.equals(password)) {
                    Intent i = new Intent(MainActivity.this, menu.class);
                    startActivity(i);
                } else {
                    Toast t = Toast.makeText(MainActivity.this, "passwords dont match", Toast.LENGTH_SHORT);
                    t.show();
                }
            }
        });

    }


   /* public void onButtonClick(View view)
    {
        if(view.getId()==R.id.button)
        {


        }
        if(view.getId()==R.id.button1)
        {

        }
    }*/
}
