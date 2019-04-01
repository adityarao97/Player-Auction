package com.example.sunita.mini;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sunita.mini.Model.sign_up_info;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class sign_up_activity extends AppCompatActivity {

    EditText edid;
    EditText edpswd;
    EditText edname;
    Button signup;


   DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("Team_info");

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        edid = findViewById(R.id.signupteamid);
        edpswd = findViewById(R.id.signupteampassword);
        edname = findViewById(R.id.signupteamname);
        signup = findViewById(R.id.btnsign_up);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signupteamlogin();
            }
        });

    }

    public void signupteamlogin() {
        String teamid = edid.getText().toString().trim();
        String password = edpswd.getText().toString();
        String teamname = edname.getText().toString().trim();


        if(!TextUtils.isEmpty(teamid) || !TextUtils.isEmpty(password) || !TextUtils.isEmpty(teamname))
        {
           String id=myRef.push().getKey();

            sign_up_info sgn_info=new sign_up_info(id,teamid,teamname,password);
            myRef.child(id).setValue(sgn_info);

            Toast.makeText(getApplicationContext(),"signed in",Toast.LENGTH_LONG).show();
        }

        else
            Toast.makeText(getApplicationContext(),"plz enter all the credintials",Toast.LENGTH_LONG).show();


    }
}
