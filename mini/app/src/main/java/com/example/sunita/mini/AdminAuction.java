package com.example.sunita.mini;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class AdminAuction extends AppCompatActivity {

    TextView nameTextView;
    TextView basePriceTextView;
    EditText bid1;
    EditText bid2;
    EditText bid3;
    Button finalizeButton;
    String basePrice;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_auction);
        Bundle bundle = getIntent().getExtras();
        String fullName = bundle.getString("fullName");
        basePrice = bundle.getString("basePrice");
//        Toast.makeText(getApplicationContext(),fullName + " " + basePrice,Toast.LENGTH_LONG).show();
        nameTextView = findViewById(R.id.nameTextView);
        basePriceTextView = findViewById(R.id.basePriceTextView);
        nameTextView.setText("Name : " + fullName);
        basePriceTextView.setText(basePrice);
        bid1 = findViewById(R.id.bid1);
        bid2 = findViewById(R.id.bid2);
        bid3 = findViewById(R.id.bid3);
    }

    public void submit(View view){
//        double[] bidAmount = new double[3];
        ArrayList<Double> bidAmount = new ArrayList<Double>();
//        Double basePrice = Double.parseDouble(basePriceTextView.getText().toString());
//        Log.i("base",basePrice + "");
        bidAmount.add(Double.parseDouble(bid1.getText().toString()));
        bidAmount.add(Double.parseDouble(bid2.getText().toString()));
        bidAmount.add(Double.parseDouble(bid3.getText().toString()));
        if(Collections.min(bidAmount)>Double.parseDouble(basePrice)){
            Double maxVal = Collections.max(bidAmount);
            int index = bidAmount.indexOf(maxVal)+1;
            Toast.makeText(getApplicationContext(),"Team " + index + " Wins the auction",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(getApplicationContext(),"One of the bidding amount was less than the base price re-enter and submit",Toast.LENGTH_SHORT).show();
        }
    }
}
