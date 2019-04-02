package com.example.sunita.mini;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sunita.mini.Model.sign_up_info;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class TeamDashboard extends AppCompatActivity {

    TextView headingText;
    EditText bidAmountEditText;
    Button sendBidButton;
    ListView listView;
    String[] arr={""};
    String teamList="";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.team_dashboard_layout);
        Bundle bundle = getIntent().getExtras();
        String heading = bundle.getString("heading");

        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("Team_info").child(heading);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                teamList = dataSnapshot.child("playername").getValue(String.class);
                Log.i("PlayerNames",teamList);
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.i( "message error", "error" );
            }
        });

        headingText = findViewById(R.id.headingText);
        bidAmountEditText = findViewById(R.id.bidAmountEditText);
        listView = findViewById(R.id.listView);

        ArrayList<String> list = new ArrayList<String>();
        arr = teamList.split(",");
        for(String ss: arr){
            list.add(ss);
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(arrayAdapter);

        headingText.setText(heading);
    }


   /* @Override
   protected void onStart() {
        super.onStart();
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                    sign_
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        })
    }*/

    public void send(View view){
        if(Double.parseDouble(bidAmountEditText.getText().toString())>0.0){
//            sign_up_info sui=new sign_up_info();
//            String b=sui.getId();
            DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("Team_info").child(headingText.getText().toString());
            myRef.child("bidAmount").setValue(Double.parseDouble(bidAmountEditText.getText().toString()));
//            if(headingText.getText().toString()=="CSK"){
//            }
 //           myRef.child("Team_info").setValue(bidAmountEditText);


            Toast.makeText(getApplicationContext(),"bidding amount set",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplicationContext(),"bidding amount is invalid try again",Toast.LENGTH_LONG).show();
        }
    }

    public void pool(View view){
        Intent intent = new Intent(TeamDashboard.this,UserPlayerPool.class);
        startActivity(intent);
    }
}
