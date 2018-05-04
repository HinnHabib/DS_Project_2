package com.example.fadi.supermarket.utils;

/**
 * Created by Fadi on 5/4/2018.
 */

import com.example.fadi.supermarket.model.User;
        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;


public class UserJsonParser {

    public static User getObjectFromJason(String json) {
        User user = new User();
        try {
            JSONArray jsonArray = new JSONArray(json);
                JSONObject jsonObject = new JSONObject();
                jsonObject= (JSONObject) jsonArray.get(0);
                user.setName(jsonObject.getString("name"));
                user.setEmail(jsonObject.getString("email"));

        } catch (JSONException e)
        { e.printStackTrace();
            return null;
        }
        return user;
    }
}
