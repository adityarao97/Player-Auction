package com.example.sunita.mini;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class Team2 extends AppCompatActivity {


    Button gotodb;
    ListView details;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.team2_layout);

        gotodb= (Button) findViewById(R.id.team2db);
        details= (ListView) findViewById(R.id.lvdetailsteam2);

        gotodb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Team2.this,Unsold_player.class);
                startActivity(intent);

         // add listview functionality
            }
        });
    }
}
