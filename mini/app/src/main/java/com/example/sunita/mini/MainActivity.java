package com.example.sunita.mini;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);


        final Button admin=findViewById(R.id.btnadmin);
        Button user=findViewById(R.id.btnuser);
        Button createact=findViewById(R.id.btnsignup);

        admin.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View view) {
                                            startActivity(new Intent(MainActivity.this, Admin_login.class));
                                     }
                                 });

         user.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 startActivity(new Intent(MainActivity.this, UserLogin.class));
             }
         });

         createact.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 startActivity(new Intent(MainActivity.this,sign_up_activity.class));
             }
         });
                    }
                }





