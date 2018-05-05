package com.example.fadi.supermarket.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.fadi.supermarket.R;
import com.example.fadi.supermarket.adapter.ProductAdapter;
import com.example.fadi.supermarket.model.Product;
import com.example.fadi.supermarket.async.task.AsyncResponse;
import com.example.fadi.supermarket.async.task.GetDataAsyncTaskRunner;
import com.example.fadi.supermarket.other.Constants;
import com.example.fadi.supermarket.util.JsonParser;

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

        GetDataAsyncTaskRunner getDataAsyncTaskRunner = new GetDataAsyncTaskRunner(this);

        switch (type) {
            case "meat":
                getDataAsyncTaskRunner.execute(Constants.GET_MEAT_PRODUCTS_URL);
                break;
            case "bread":
                getDataAsyncTaskRunner.execute(Constants.GET_BREAD_PRODUCTS_URL);
                break;
            case "food":
                getDataAsyncTaskRunner.execute(Constants.GET_FOOD_PRODUCTS_URL);
                break;
            case "nonFood":
                getDataAsyncTaskRunner.execute(Constants.GET_NON_FOOD_PRODUCTS_URL);
                break;
        }

    }

    @Override
    public void processData(Object data) {

        String jsonString = (String) data;

        ArrayList<Product> products = JsonParser.parseProductsJson(jsonString);

        ListView listView = (ListView) findViewById(R.id.products_list);

        ProductAdapter productAdapter = new ProductAdapter(this, products);

        listView.setAdapter(productAdapter);
    }
}
