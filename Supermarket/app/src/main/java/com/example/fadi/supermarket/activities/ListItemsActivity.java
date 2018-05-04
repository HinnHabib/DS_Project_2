package com.example.fadi.supermarket.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ScrollView;

import com.example.fadi.supermarket.R;
import com.example.fadi.supermarket.model.Product;
import com.example.fadi.supermarket.utils.AsyncResponse;
import com.example.fadi.supermarket.utils.AsyncTaskRunner;
import com.example.fadi.supermarket.utils.Constants;
import com.example.fadi.supermarket.utils.JsonParser;

import java.util.List;

public class ListItemsActivity extends AppCompatActivity implements AsyncResponse {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items);
        ScrollView scrollView = (ScrollView) findViewById(R.id.scrollView);

        Intent intent = getIntent();
        String type = intent.getStringExtra("type");
        AsyncTaskRunner asyncTaskRunner = new AsyncTaskRunner(this);

        switch(type){

            case "meat":
                asyncTaskRunner.execute(Constants.GET_MEAT_PRODUCTS_URL);

                break;
            case "bread":
                System.out.println("bread");
                break;
            case "nonFood":
                System.out.println("nonfood");
                break;
            case "food":
                System.out.println("food");
                break;
        }
    }

    public void processData(String jsonString) {
        List<Product> products = JsonParser.parseProductsJson(jsonString);
    }
}
