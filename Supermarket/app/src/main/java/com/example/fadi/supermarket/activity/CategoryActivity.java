package com.example.fadi.supermarket.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.fadi.supermarket.R;
import com.example.fadi.supermarket.adapter.CategoryAdapter;
import com.example.fadi.supermarket.async.task.AsyncResponse;
import com.example.fadi.supermarket.async.task.GetDataAsyncTaskRunner;
import com.example.fadi.supermarket.model.Category;
import com.example.fadi.supermarket.other.Constants;
import com.example.fadi.supermarket.util.JsonParser;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity implements AsyncResponse{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);


        GetDataAsyncTaskRunner getDataAsyncTaskRunner = new GetDataAsyncTaskRunner(this);
        getDataAsyncTaskRunner.execute(Constants.GET_CATEGORIES_URL);


//        ImageView meatFish = (ImageView) findViewById(R.id.meatFish);
//        meatFish.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), ListItemsActivity.class);
//                intent.putExtra("type" , "meat");
//                startActivity(intent);
//            }
//        });

    }

    @Override
    public void processData(Object data) {

        String jsonString = (String) data;

        ArrayList<Category> categories = JsonParser.parseCategoriesJson(jsonString);

        ListView listView = (ListView) findViewById(R.id.categories_list);

        CategoryAdapter categoryAdapter = new CategoryAdapter(this, categories);

        listView.setAdapter(categoryAdapter);
    }
}
