package com.example.sunita.mini;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Team extends AppCompatActivity {

    TextView headingText;
    EditText bidAmountEditText;
    Button sendBidButton;
    ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.team_layout);
        Bundle bundle = getIntent().getExtras();
        String heading = bundle.getString("heading");

        headingText = findViewById(R.id.headingText);
        bidAmountEditText = findViewById(R.id.bidAmountEditText);
        listView = findViewById(R.id.listView);
        ArrayList<String> list = new ArrayList<String>();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        listView.setAdapter(arrayAdapter);

        headingText.setText(heading);
    }

    public void send(View view){
        if(Double.parseDouble(bidAmountEditText.getText().toString())>0.0){
            Toast.makeText(getApplicationContext(),"it works",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplicationContext(),"bidding amount is invalid try again",Toast.LENGTH_LONG).show();
        }
    }

    public void pool(View view){
        Intent intent = new Intent(Team.this,UserPlayerPool.class);
        startActivity(intent);
    }
}
