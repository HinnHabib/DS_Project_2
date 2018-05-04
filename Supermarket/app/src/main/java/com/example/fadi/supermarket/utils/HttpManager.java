package com.example.fadi.supermarket.utils;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Mohammad on 7/30/2017.
 */

public class HttpManager {

    public static String getData(String URI) {
        BufferedReader bufferedReader = null;

        try {
            URL url = new URL(URI);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();
            String line = bufferedReader.readLine();

            while (line != null) {
                stringBuilder.append(line + '\n');
                line = bufferedReader.readLine();
            }

            return stringBuilder.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
