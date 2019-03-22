package com.example.sunita.mini;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sunita.mini.Model.Player_info;

import java.util.ArrayList;
import java.util.List;

public class Team3 extends AppCompatActivity {

    public static  final String player_NAME="com.example.sunita.mini.playername";
    public static  final String player_price="com.example.sunita.mini.playerprice";


    Button gotodb;
   ListView details;
    List<Player_info> playerlist;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.team3_layout);

        playerlist= new ArrayList<>();
        gotodb= (Button) findViewById(R.id.team3db);
        details= (ListView) findViewById(R.id.lvdetailsteam3);

        gotodb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Team3.this,Unsold_player.class);
                startActivity(intent);
            }
        });

        details.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Player_info p_info= playerlist.get(i);
                Intent intent=new Intent(getApplicationContext(),owned_player.class);

                intent.putExtra(player_NAME,p_info.getName());
                intent.putExtra(player_price,p_info.getBaseprice());

                startActivity(intent);
            }
        });
    }
}
