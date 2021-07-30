package com.example.proyectoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public class Ventana5 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana5);

    }

    private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            try {

                String apiKey = "3028328cf7734aeb7217b2843daa5f0";

                // Endpoint for Gjallarhorn
                String url = "https://www.bungie.net/platform/Destiny/Manifest/InventoryItem/1274330687/";

                URL obj = new URL(url);
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();

                try {
                    con.setRequestMethod("GET");
                } catch (ProtocolException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                // Set header
                con.setRequestProperty("X-API-KEY", apiKey);

                int responseCode = con.getResponseCode();
                System.out.println("\nSending 'GET' request to Bungie.Net : " + url);
                System.out.println("Response Code : " + responseCode);

                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                String response = "";

                while ((inputLine = in.readLine()) != null) {
                    response += inputLine;
                    System.out.println(response);
                }
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }




            protected void onPostExecute () {
                JsonParser parser = new JsonParser();
                JsonObject json = (JsonObject) parser.parse(response);

                System.out.println();
                System.out.println(json.getAsJsonObject("Response").getAsJsonObject("data").getAsJsonObject("inventoryItem").get("itemName"));


            }
        }
    }
}
