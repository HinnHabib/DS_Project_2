package com.example.fadi.supermarket.utils;

import com.example.fadi.supermarket.model.Product;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ProductsJsonParser {

    public static List<Product> getObjectFromJson(String json) {
        List<Product> products = new ArrayList<>();
        try {

            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("foodlist");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonProductObject = (JSONObject) jsonArray.get(i);
                Product product = new Product();
                product.setName(jsonProductObject.getString("name"));
                product.setPrice(jsonProductObject.getDouble("price"));
                products.add(product);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return products;
    }
}
