package com.example.sharan.take_away;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by sharan on 28-Oct-16.
 */
public class SignUP extends Activity {

    DatabaseHelper databaseHelper=new DatabaseHelper(this);

    Button bb;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        bb= (Button) findViewById(R.id.button3);
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name=(EditText)findViewById(R.id.ed3);
                EditText email=(EditText)findViewById(R.id.ed);
                EditText uname=(EditText)findViewById(R.id.ed4);
                EditText password1=(EditText)findViewById(R.id.ed5);
                EditText password2=(EditText)findViewById(R.id.ed6);

                String namestr=name.getText().toString();
                String emailstr=email.getText().toString();
                String unamestr=uname.getText().toString();
                String passwordstr1=password1.getText().toString();
                String passwordstr2=password2.getText().toString();

                if(!passwordstr1.equals(passwordstr2))
                {
                    Toast pass=Toast.makeText(SignUP.this,"passwords dont match",Toast.LENGTH_SHORT);
                    pass.show();
                }

                else{
                    contact c=new contact();
                    c.setName(namestr);
                    c.setEmail(emailstr);
                    c.setUname(unamestr);
                    c.setPassword(passwordstr1);

                    databaseHelper.insertContact(c);
                    Toast pass1=Toast.makeText(SignUP.this,"Sign up complete!!",Toast.LENGTH_SHORT);
                    pass1.show();
                    Intent i = new Intent(SignUP.this,MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }

        });
    }

   /* public void onSignUpClick(View v)
    {
        if(v.getId()==R.id.button3)
        {

    }*/
}
