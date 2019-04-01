package com.example.sunita.mini;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class UserPlayerPool extends AppCompatActivity {


    ListView resultListView;
    ArrayList<String> resultArrayList= new ArrayList<String>();
    ArrayList<String> pidArrayList = new ArrayList<String>();

    public void viewAll(View view){
        Button viewAllButton = (Button)findViewById(R.id.viewAllButton);
        UserPlayerPool.DownloadTask task = new UserPlayerPool.DownloadTask();
        task.execute("https://cricapi.com/api/fantasySquad?apikey=J064Y1WaUoUPLccdlFeX1Kg5w8i2&unique_id=1034809");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_player_pool);
        resultListView = (ListView)findViewById(R.id.lvunsold);
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

                String squad = jsonObject.getString("squad");

                Log.i("information",squad);

                JSONArray arr = new JSONArray(squad);

                for(int i=0;i<arr.length();i++){

                    JSONObject jsonPart = arr.getJSONObject(i);
                    //String pid="";
                    String players="";
                    //pid=jsonPart.getString("pid");
                    players=jsonPart.getString("players");
                    JSONArray arr2 = new JSONArray(players);
                    Log.i("players",players);
                    for(int j=0;j<arr2.length();j++){
                        JSONObject jsonPart2 = arr2.getJSONObject(j);
                        String names="";
                        String pids="";
                        names=jsonPart2.getString("name");
                        pids=jsonPart2.getString("pid");
                        Log.i("names",names);
                        Log.i("pid",pids);
                        resultArrayList.add(names);
                        pidArrayList.add(pids);
                    }
                }

                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(UserPlayerPool.this,android.R.layout.simple_list_item_1,resultArrayList);
                resultListView.setAdapter(arrayAdapter);
                resultListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                        Toast.makeText(getApplicationContext(),pidArrayList.get(position), Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(UserPlayerPool.this, UserPlayerStatistics.class);
                        intent.putExtra("pid",pidArrayList.get(position));
                        startActivity(intent);
                    }
                });

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }






}
