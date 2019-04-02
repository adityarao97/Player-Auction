package com.example.sunita.mini;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.Math.floor;


public class AdminPlayerStats extends AppCompatActivity {

    TextView ageTextView;
    TextView profileTextView;
    TextView fullNameTextView;
    TextView roleTextView;
    TextView basePriceTextView;
    Button auctionButton;

    ImageView bgImage;
    TextView b10;
    TextView b5w;
    TextView b4w;
    TextView bSR;
    TextView bEcon;
    TextView bAve;
    TextView bBBM;
    TextView bBBI;
    TextView bWkts;
    TextView bRuns;
    TextView bBalls;
    TextView bInns;
    TextView bMat;

    TextView t50;
    TextView t100;
    TextView tSt;
    TextView tCt;
    TextView t6s;
    TextView t4s;
    TextView tSR;
    TextView tBF;
    TextView tAve;
    TextView tHS;
    TextView tRuns;
    TextView tNO;
    TextView tInns;
    TextView tMat;
    double bp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_stats);
        profileTextView = findViewById(R.id.profileTextView);
        fullNameTextView = findViewById(R.id.fullNameTextView);
        ageTextView = findViewById(R.id.ageTextView);
        roleTextView = findViewById(R.id.roleTextView);
        basePriceTextView = findViewById(R.id.basePriceTextView);
        auctionButton= findViewById(R.id.auctionButton);

        b10 = findViewById(R.id.b10);
        b5w = findViewById(R.id.b5w);
        b4w = findViewById(R.id.b4w);
        bSR = findViewById(R.id.bSR);
        bEcon = findViewById(R.id.bEcon);
        bAve = findViewById(R.id.bAve);
        bBBM = findViewById(R.id.bBBM);
        bBBI = findViewById(R.id.bBBI);
        bWkts = findViewById(R.id.bWkts);
        bRuns = findViewById(R.id.bRuns);
        bBalls = findViewById(R.id.bBalls);
        bInns = findViewById(R.id.bInns);
        bMat = findViewById(R.id.bMat);

        t50 = findViewById(R.id.t50);
        t100 = findViewById(R.id.t100);
        tSt = findViewById(R.id.tSt);
        tCt = findViewById(R.id.tCt);
        t6s = findViewById(R.id.t6s);
        t4s = findViewById(R.id.t4s);
        tSR = findViewById(R.id.tSR);
        tBF = findViewById(R.id.tBF);
        tAve = findViewById(R.id.tAve);
        tHS = findViewById(R.id.tHS);
        tRuns = findViewById(R.id.tRuns);
        tNO = findViewById(R.id.tNO);
        tInns = findViewById(R.id.tInns);
        tMat = findViewById(R.id.tMat);


        Bundle bundle = getIntent().getExtras();
        String pid = bundle.getString("pid");
//        Toast.makeText(getApplicationContext(),pid,Toast.LENGTH_LONG).show();
        DownloadTask task = new DownloadTask();
        task.execute("https://cricapi.com/api/playerStats?apikey=J064Y1WaUoUPLccdlFeX1Kg5w8i2&pid=" + pid);
    }

    public void auction(View view){
//        Toast.makeText(getApplicationContext(),"Clicked",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(AdminPlayerStats.this,AdminAuction.class);
        intent.putExtra("fullName",fullNameTextView.getText().toString());
        intent.putExtra("basePrice",bp + "");
        startActivity(intent);
    }

    public  class DownloadTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {

            String result = "";
            URL url;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL(urls[0]);
                try {
                    urlConnection = (HttpURLConnection) url.openConnection();
                    InputStream in = urlConnection.getInputStream();
                    InputStreamReader reader = new InputStreamReader(in);
                    int data=reader.read();
                    while(data!=-1){
                        char current = (char)data;
                        result+=current;
                        data=reader.read();
                    }
                    return result;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            try {

                JSONObject jsonObject = new JSONObject(result);

                String fullNamePlayer = jsonObject.getString("fullName");
                fullNameTextView.setText(fullNamePlayer);
                Log.i("fullname",fullNamePlayer);

                String profilePlayer = jsonObject.getString("profile");
                profileTextView.setText("Profile : " + profilePlayer);
                Log.i("profile",profilePlayer);

                String agePlayer = jsonObject.getString("currentAge");
                ageTextView.setText("Age : " + agePlayer);

                String rolePlayer = jsonObject.getString("playingRole");
                roleTextView.setText("Role : " + rolePlayer);

                JSONObject dataObject = jsonObject.getJSONObject("data");
                JSONObject bowlingObject = dataObject.getJSONObject("bowling");
                JSONObject t20BowlingObject = bowlingObject.getJSONObject("T20Is");
                String bowlingStat = t20BowlingObject.getString("Ave");
                Log.i("bowlinger",bowlingStat);
                b10.setText("10 runs : " + t20BowlingObject.getString("10"));
                b5w.setText("5 wickets : " + t20BowlingObject.getString("5w"));
                b4w.setText("4 wickets : " + t20BowlingObject.getString("4w"));
                bSR.setText("Strike Rate : " + t20BowlingObject.getString("SR"));
                bEcon.setText("Economy : " + t20BowlingObject.getString("Econ"));
                bAve.setText("Average : " + t20BowlingObject.getString("Ave"));
                bBBM.setText("BBM : " + t20BowlingObject.getString("BBM"));
                bBBI.setText("BBI : " + t20BowlingObject.getString("BBI"));
                bWkts.setText("Wickets : " + t20BowlingObject.getString("Wkts"));
                bRuns.setText("Runs : " + t20BowlingObject.getString("Runs"));
                bBalls.setText("Balls : " + t20BowlingObject.getString("Balls"));
                bInns.setText("Innings : " + t20BowlingObject.getString("Inns"));
                bMat.setText("Matches : " + t20BowlingObject.getString("Mat"));

                JSONObject battingObject = dataObject.getJSONObject("batting");
                JSONObject t20battingObject = battingObject.getJSONObject("T20Is");
                t50.setText("50s : " + t20battingObject.getString("50"));
                t100.setText("100s : " + t20battingObject.getString("100"));
                tSt.setText("St : " + t20battingObject.getString("St"));
                tCt.setText("Ct : " + t20battingObject.getString("Ct"));
                t6s.setText("6s : " + t20battingObject.getString("6s"));
                t4s.setText("4s : " + t20battingObject.getString("4s"));
                tSR.setText("Strike Rate : " + t20battingObject.getString("SR"));
                tBF.setText("BF : " + t20battingObject.getString("BF"));
                tAve.setText("Average : " + t20battingObject.getString("Ave"));
                tHS.setText("HS : " + t20battingObject.getString("HS"));
                tRuns.setText("Runs : " + t20battingObject.getString("Runs"));
                tNO.setText("NO Balls : " + t20battingObject.getString("NO"));
                tInns.setText("Innings : " + t20battingObject.getString("Inns"));
                tMat.setText("Matches : " + t20battingObject.getString("Mat"));

                String basePrice = "";
                double val1 = Double.parseDouble(t20battingObject.getString("Runs"))*0.5;
                double val2 = Double.parseDouble(t20BowlingObject.getString("Wkts"))*100;
                bp = floor((val1+val2)*1000);
                basePriceTextView.setText("Base Price : " + bp);

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }

}
