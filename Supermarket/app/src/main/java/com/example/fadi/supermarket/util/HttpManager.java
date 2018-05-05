package com.example.fadi.supermarket.util;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import javax.net.ssl.HttpsURLConnection;

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

    public static boolean signIn(String email, String password) {

        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("email", email);
            jsonObject.put("password", password);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        String parameters = jsonObject.toString();

        System.out.println("-------------------------");
        System.out.println(parameters);
        System.out.println("-------------------------");

        byte[] postData = parameters.getBytes();

        int postDataLength = postData.length;
        URL url;
        try {
            url = new URL("http://distributed.ga:8080/api/v1/user/signIn");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("charset", "utf-8");
            connection.setRequestProperty("Content-Length", Integer.toString(postDataLength));
            connection.setUseCaches(false);
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.write(postData);

            return connection.getResponseCode() == 200 || connection.getResponseCode() == 201;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    public static boolean register(String name, String email, String password) {

        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("name", name);
            jsonObject.put("email", email);
            jsonObject.put("password", password);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        String parameters = jsonObject.toString();

        byte[] postData = parameters.getBytes();

        int postDataLength = postData.length;
        URL url;
        try {
            url = new URL("http://distributed.ga:8080/api/v1/user/signup");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("charset", "utf-8");
            connection.setRequestProperty("Content-Length", Integer.toString(postDataLength));
            connection.setUseCaches(false);
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.write(postData);

            return connection.getResponseCode() == 200 || connection.getResponseCode() == 201;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}