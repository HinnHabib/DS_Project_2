package com.example.fadi.supermarket.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.fadi.supermarket.R;
import com.example.fadi.supermarket.model.ProductAdapter;
import com.example.fadi.supermarket.model.Product;
import com.example.fadi.supermarket.utils.AsyncResponse;
import com.example.fadi.supermarket.utils.AsyncTaskRunner;
import com.example.fadi.supermarket.utils.Constants;
import com.example.fadi.supermarket.utils.JsonParser;

import java.util.ArrayList;

public class ListItemsActivity extends AppCompatActivity implements AsyncResponse {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items);

        Intent intent = getIntent();
        String type = intent.getStringExtra("type");
        this.getData(type);
    }

    public void getData(String type) {

        AsyncTaskRunner asyncTaskRunner = new AsyncTaskRunner(this);

        switch (type) {
            case "meat":
                asyncTaskRunner.execute(Constants.GET_MEAT_PRODUCTS_URL);
                break;
            case "bread":
                asyncTaskRunner.execute(Constants.GET_BREAD_PRODUCTS_URL);
                break;
            case "food":
                asyncTaskRunner.execute(Constants.GET_FOOD_PRODUCTS_URL);
                break;
            case "nonFood":
                asyncTaskRunner.execute(Constants.GET_NON_FOOD_PRODUCTS_URL);
                break;
        }

    }

    public void processData(String jsonString) {

        ArrayList<Product> products = JsonParser.parseProductsJson(jsonString);

        ListView listView = (ListView) findViewById(R.id.products_list);

        ProductAdapter productAdapter = new ProductAdapter(this, products);

        listView.setAdapter(productAdapter);
    }
}
