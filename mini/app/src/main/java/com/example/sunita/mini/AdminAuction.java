package com.example.sunita.mini;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
    String[] flname = new String[3];
    String flname2="";
    String flname3="";
    Double value;

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
        basePriceTextView.setText("Base Price : " + basePrice);

        bid1 = findViewById(R.id.bid1);
        bid2 = findViewById(R.id.bid2);
        bid3 = findViewById(R.id.bid3);

//Fetching values for bid1,bid2 and bid3
        for(int i = 0;i<3;i++){
            if(i==0){
                DatabaseReference myRef1 = FirebaseDatabase.getInstance().getReference("Team_info").child("CSK");
                myRef1.addValueEventListener(new ValueEventListener() {
                    @SuppressLint("LongLogTag")
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        value = dataSnapshot.child("bidAmount").getValue(Double.class);
                        bid1.setText(value + "");
                        flname[0] = dataSnapshot.child("playername").getValue(String.class);
                        Log.i("bidAmount and playername",value + " " + flname[0]);
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.i("Failed to read value.", "" + error.toException());
                    }
                });
            }
            else if(i==1){
                DatabaseReference myRef2 = FirebaseDatabase.getInstance().getReference("Team_info").child("RCB");
                myRef2.addValueEventListener(new ValueEventListener() {
                    @SuppressLint("LongLogTag")
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        value = dataSnapshot.child("bidAmount").getValue(Double.class);
                        bid2.setText(value + "");
                        flname[1] = dataSnapshot.child("playername").getValue(String.class);
                        Log.i("bidAmount and playername",value + " " + flname[1]);
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.i("Failed to read value.", "" + error.toException());
                    }
                });
            }
            else if(i==2){
                DatabaseReference myRef3 = FirebaseDatabase.getInstance().getReference("Team_info").child("KKR");
                myRef3.addValueEventListener(new ValueEventListener() {
                    @SuppressLint("LongLogTag")
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        value = dataSnapshot.child("bidAmount").getValue(Double.class);
                        bid3.setText(value + "");
                        flname[2] = dataSnapshot.child("playername").getValue(String.class);
                        Log.i("bidAmount and playername",value + " " + flname[2]);
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.i("Failed to read value.", "" + error.toException());
                    }
                });
            }
        }
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
            Bundle bundle = getIntent().getExtras();
            String str="";
            Intent intent=new Intent(AdminAuction.this,TeamDashboard.class);
            if(index==1){
                str="CSK";
                DatabaseReference myReference1 = FirebaseDatabase.getInstance().getReference("Team_info").child("CSK");
                Log.i("flname2 before",flname[0]);
                flname3 = flname[0] + "," + bundle.getString("fullName");
                Log.i("flname2 after",flname3);
                myReference1.child("playername").setValue(flname3);
                intent.putExtra("heading",str);
                startActivity(intent);
            }
            else if(index==2)
            {
                str="RCB";
                DatabaseReference myReference2 = FirebaseDatabase.getInstance().getReference("Team_info").child("RCB");
                Log.i("flname2 before",flname[1]);
                flname3 = flname[1] + "," + bundle.getString("fullName");
                Log.i("flname2 after",flname3);
                myReference2.child("playername").setValue(flname3);
                intent.putExtra("heading",str);
                startActivity(intent);
            }
            else if(index==3)
            {
                str="KKR";
                DatabaseReference myReference3 = FirebaseDatabase.getInstance().getReference("Team_info").child("KKR");
                Log.i("flname2 before",flname[2]);
                flname3 = flname[2] + "," + bundle.getString("fullName");
                Log.i("flname2 after",flname3);
                myReference3.child("playername").setValue(flname3);
                intent.putExtra("heading",str);
                startActivity(intent);
            }
//            flname="";
//            flname2="";
//            flname3="";
//            startActivity(intent);
        }
        else{
            Toast.makeText(getApplicationContext(),"One of the bidding amount was less than the base price re-enter and submit",Toast.LENGTH_SHORT).show();
        }
    }
}
