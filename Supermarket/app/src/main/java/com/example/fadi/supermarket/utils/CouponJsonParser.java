package com.example.fadi.supermarket.utils;

/**
 * Created by Fadi on 5/4/2018.
 */

import com.example.fadi.supermarket.model.Coupon;

import org.json.JSONArray;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

        import java.util.ArrayList;
        import java.util.List;

/**
 * Created by Fadi on 5/4/2018.
 */

public class CouponJsonParser {

    public static List<Coupon> getObjectFromJason(String json) {
        List<Coupon> coupons;
        try {
            JSONArray jsonArray = new JSONArray(json);
            coupons = new ArrayList<Coupon>();
            for(int i = 0; i<jsonArray.length(); i++)
            {
                JSONObject jsonObject = new JSONObject();
                jsonObject= (JSONObject) jsonArray.get(i);
                Coupon coupon = new Coupon();
                coupon.setId(jsonObject.getInt("id"));
                coupon.setName(jsonObject.getString("name"));
                coupon.setDescription(jsonObject.getString("description"));

                coupons.add(coupon);
            }
        } catch (JSONException e)
        { e.printStackTrace();
            return null;
        }
        return coupons;
    }
}