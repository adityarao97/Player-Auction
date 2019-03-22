package com.example.sunita.mini;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class Team3 extends AppCompatActivity {

    Button gotodb;
   ListView details;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.team3_layout);

        gotodb= (Button) findViewById(R.id.team3db);
        details= (ListView) findViewById(R.id.lvdetailsteam3);

        gotodb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Team3.this,Unsold_player.class);
                startActivity(intent);
            }
        });
    }
}
