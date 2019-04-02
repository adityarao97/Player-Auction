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


    DatabaseReference myRef1 = FirebaseDatabase.getInstance().getReference("Team_info").child("team1");
    DatabaseReference myRef2 = FirebaseDatabase.getInstance().getReference("Team_info").child("team2");
    DatabaseReference myRef3 = FirebaseDatabase.getInstance().getReference("Team_info").child("team3");

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


        if(!TextUtils.isEmpty(teamid) && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(teamname))
        {
           //String id=myRef.push().getKey();
           //String new==id;

            sign_up_info sgn_info=new sign_up_info(teamid,teamname,password);
            //myRef.child(id).setValue(sgn_info);
            myRef1.setValue(sgn_info);

            Toast.makeText(getApplicationContext(),"Signed In",Toast.LENGTH_LONG).show();
        }
        else
            Toast.makeText(getApplicationContext(),"Please Enter all the credintials",Toast.LENGTH_LONG).show();
    }
}
