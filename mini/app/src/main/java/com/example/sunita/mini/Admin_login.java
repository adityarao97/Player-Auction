package com.example.sunita.mini;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Admin_login extends AppCompatActivity {

   EditText edid;
   EditText edpswd;
   Button login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_login);

         edid= (EditText) findViewById(R.id.adminid);
         edpswd= (EditText) findViewById(R.id.adminpassword);
         login= (Button) findViewById(R.id.btnlogin);

         login.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 saveuserlogin();
             }
         });
    }

    public void saveuserlogin() {
        String id = edid.getText().toString().trim();
        String password = edpswd.getText().toString();

        if ((id.equals("auctioner")) && (password.equals("ipl2020"))) {
            Intent intent = new Intent(Admin_login.this, Player_pool.class);
            startActivity(intent);
        } else {
            Toast.makeText(Admin_login.this, "wrong credentials", Toast.LENGTH_LONG).show();
        }


    }
}
