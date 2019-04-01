package com.example.sunita.mini;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserLogin extends AppCompatActivity {

    EditText edid;
    EditText edpswd;
    EditText edname;
    Button login;
    
   // private FirebaseAuth mAuth=FirebaseAuth.getInstance();;

    //DatabaseReference myRef = FirebaseDatabase.getInstance().getReference();
    //DatabaseReference ref = myRef.child("Team_info").child("password");
    //DatabaseReference ref1 = myRef.child("Team_info").child("teamid");

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_login);


        edid=findViewById(R.id.teamid);
        edpswd=findViewById(R.id.teampassword);
        edname=findViewById(R.id.teamname);
        login=findViewById(R.id.btnteamlogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveteamlogin();
            }
        });
    }

    public void saveteamlogin() {
        String id = edid.getText().toString().trim();
        String password = edpswd.getText().toString();
        String name = edname.getText().toString().trim();

      if((id.equals("firstteam")) && (password.equals("first_team")) &&  (name.equals("CSK")))
       {
           Toast.makeText(getApplicationContext(),"Welcome CSK",Toast.LENGTH_LONG).show();
           Intent intent= new Intent(UserLogin.this,Team1.class);
           startActivity(intent);
       }

       else if((id.equals("secondteam")) && (password.equals("second_team")) &&  (name.equals("RCB")))
       {
           Toast.makeText(getApplicationContext(),"Welcome RCB",Toast.LENGTH_LONG).show();
           Intent intent= new Intent(UserLogin.this,Team2.class);
           startActivity(intent);
       }

       else if((id.equals("thirdteam")) && (password.equals("third_team")) &&  (name.equals("KKR")))
       {
           Toast.makeText(getApplicationContext(),"Welcome KKR",Toast.LENGTH_LONG).show();
           Intent intent= new Intent(UserLogin.this,Team3.class);
           startActivity(intent);
       }
        else
            Toast.makeText(getApplicationContext(),"wrong credentials",Toast.LENGTH_LONG).show();
    }
        // Read from the database

}




