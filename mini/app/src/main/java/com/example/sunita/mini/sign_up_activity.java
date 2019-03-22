package com.example.sunita.mini;

import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class sign_up_activity extends AppCompatActivity {

    EditText edid=findViewById(R.id.signupteamid);
    EditText edpswd=findViewById(R.id.signupteampassword);
    EditText edname=findViewById(R.id.signupteamname);
    Button signup=findViewById(R.id.btnsign_up);

    public void signupteamlogin()
    {
        String id=edid.getText().toString().trim();
        String password=edpswd.getText().toString();
        String name=edname.getText().toString().trim();

        if(!TextUtils.isEmpty(id) || !TextUtils.isEmpty(password) || !TextUtils.isEmpty(name))
        {
           // String id1=databaseReference.push().getKey();
           // String pswd1=datbaseReference.push().getKey();
           //String nme=databaseReference.puch().getKey();

            Toast.makeText(getApplicationContext(),"signed in",Toast.LENGTH_LONG).show();
        }

        else
            Toast.makeText(getApplicationContext(),"plz enter all the credintials",Toast.LENGTH_LONG).show();
    }
        // add functionality of button

}
