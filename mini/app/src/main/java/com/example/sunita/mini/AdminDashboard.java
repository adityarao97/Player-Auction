package com.example.sunita.mini;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class AdminDashboard extends AppCompatActivity {

    Button playerPoolButton;
    Button searchButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_dashboard_layout);
        playerPoolButton = findViewById(R.id.playerPoolButton);
        searchButton = findViewById(R.id.searchButton);
    }

    public void playerPool(View view){
        Intent intent = new Intent(AdminDashboard.this,AdminPlayerPool.class);
        startActivity(intent);
    }

    public void search(View view){
        Intent intent = new Intent(AdminDashboard.this,SearchPlayers.class);
        startActivity(intent);
    }

}
