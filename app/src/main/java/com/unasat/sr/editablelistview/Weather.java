package com.unasat.sr.editablelistview;

import android.os.AsyncTask;

import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Weather extends AsyncTask<String,Void,String> {

    @Override
    protected String doInBackground(String... urls) {

        String result = "";
        URL url;
        HttpURLConnection urlConnection = null;

        try{

            url = new URL(urls[0]);

            urlConnection = (HttpURLConnection) url.openConnection();

            InputStream in = urlConnection.getInputStream();

            InputStreamReader reader = new InputStreamReader(in);

            int data = reader.read();

            while(data != -1){
                char current = (char) data;
                result += current;
                data = reader.read();
            }

            return result;

        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        try {

            JSONObject jsonObject = new JSONObject(result);

            JSONObject weatherData = new JSONObject(jsonObject.getString("main"));

            Double temperature = Double.parseDouble(weatherData.getString("temp"));
            double tempIn = temperature;/*(temperature * 1.8-459.67);*/

            String placename = jsonObject.getString("name");

            MainActivity.temperatureTextView.setText(String.valueOf(tempIn));

            MainActivity.placeTextView.setText(placename);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
