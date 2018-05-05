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
        setContentView(R.layout.activity_products);

        Intent intent = getIntent();
        int categoryId = intent.getIntExtra("categoryId", 0);
        this.getData(categoryId);
    }

    public void getData(int categoryId) {

        GetDataAsyncTaskRunner getDataAsyncTaskRunner = new GetDataAsyncTaskRunner(this);
        getDataAsyncTaskRunner.execute(Constants.GET_PRODUCTS_BY_CATEGORY_URL + "/" + categoryId);
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
