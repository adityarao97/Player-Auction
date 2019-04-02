package com.example.sunita.mini;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

import com.example.sunita.mini.Model.Player_info;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import static com.example.sunita.mini.Team3.player_NAME;
import static com.example.sunita.mini.Team3.player_price;

public class Team1 extends AppCompatActivity {

    //public static  final String player_NAME="com.example.sunita.mini.playername";
    //public static  final String player_price="com.example.sunita.mini.playerprice";
    DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("Team_info").child("CSK");

    Button gotodb;
    ListView details;
    ArrayList<String> resultArrayList= new ArrayList<String>();
    //List<Player_info> playerlist;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.team1_layout);

        gotodb= (Button) findViewById(R.id.team1db);
        details= (ListView) findViewById(R.id.lvdetailsteam1);

        //playerlist= new ArrayList<>();

        gotodb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Team1.this, UserPlayerPool.class);
                startActivity(intent);

                //listview pe click krne se owned_player khulega add krna
            }
        });
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Team1.this,android.R.layout.simple_list_item_1,resultArrayList);
        details.setAdapter(arrayAdapter);

        details.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent= new Intent(Team1.this,owned_player.class);
                startActivity(intent);

            }






        });


    }
}
