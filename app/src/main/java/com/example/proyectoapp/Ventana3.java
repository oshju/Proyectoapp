package com.example.proyectoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ventana3 extends AppCompatActivity {

    Button botonleer;
    TextView txtdatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.botonleer=findViewById(R.id.botonleer);
        this.txtdatos=findViewById(R.id.txtdatos);

    }

    public void leerServicio(View view) {
        try {
            String url = "https://webapidepartamento.azurewebsites.net/api/departamento";//cambiar
            new HttpAsyncTask().execute(url);
        } catch (Exception e) {
// manage exceptions
            txtdatos.setText(e.getMessage());
        }
    }




    private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(urls[0]);

            try {
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(3);
                nameValuePairs.add(new BasicNameValuePair("numero", "99"));
                nameValuePairs.add(new BasicNameValuePair("nombre", "88"));
                nameValuePairs.add(new BasicNameValuePair("localidad", "77"));


                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                // Execute HTTP Post Request
                HttpResponse response = httpclient.execute(httppost);

            } catch (ClientProtocolException e) {
                // TODO Auto-generated catch block
            } catch (IOException e) {
                // TODO Auto-generated catch block
            }
            return "Executed";
            // return recuperarContenido(urls[0]);
        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {


        }
    }
}