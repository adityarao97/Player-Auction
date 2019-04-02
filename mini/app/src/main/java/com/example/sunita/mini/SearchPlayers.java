package com.example.sunita.mini;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SearchPlayers extends AppCompatActivity {

    EditText nameTextView;
    TextView resultTextView;
    Button searchButton = findViewById(R.id.searchButton);

    public void searchButton(View view){
        Button searchButton = (Button)findViewById(R.id.searchButton);
        searchButton.animate().alpha(1f).setDuration(500);
        Toast.makeText(getApplicationContext(),nameTextView.getText().toString(),Toast.LENGTH_LONG).show();
        String playerName = nameTextView.getText().toString();
        InputMethodManager mgr = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(nameTextView.getWindowToken(),0);
        int i = playerName.indexOf(' ');
        String[] words = playerName.split("\\W+");
        String finalStr = "https://cricapi.com/api/playerFinder?apikey=J064Y1WaUoUPLccdlFeX1Kg5w8i2&name=";
        for(int j=0;j<words.length;j++){
            finalStr+=words[j] + " ";
        }
        DownloadTask task = new DownloadTask();
        task.execute(finalStr);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_players);
        nameTextView = (EditText)findViewById(R.id.nameEditText);
        resultTextView = (TextView)findViewById(R.id.resultTextView);
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

                String message="";

                JSONObject jsonObject = new JSONObject(result);

                String infoPlayer = jsonObject.getString("data");

                Log.i("information",infoPlayer);

                JSONArray arr = new JSONArray(infoPlayer);

                for(int i=0;i<arr.length();i++){

                    JSONObject jsonPart = arr.getJSONObject(i);

                    String pid="";
                    String fullName="";
                    pid=jsonPart.getString("pid");
                    fullName=jsonPart.getString("fullName");
                    if(pid!="null" && fullName!="null") {
                        message += "Player ID " + ": " + pid + "\nFull Name " + ": " + fullName + "\n";
                    }
                    else{
                        message = "";
                        break;
                    }
                }

                if(message!=""){
                    resultTextView.setText(message + "\n");
                }
                else{
                    resultTextView.setText("Player Not Found");
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }

}
