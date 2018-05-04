package com.example.fadi.supermarket.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.fadi.supermarket.R;

public class CatalogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        ImageView meatFish = (ImageView) findViewById(R.id.meatFish);
        ImageView bread = (ImageView) findViewById(R.id.bread);
        ImageView nonFood = (ImageView) findViewById(R.id.nonFood);
        ImageView food = (ImageView) findViewById(R.id.foodStuff);


        meatFish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListItemsActivity.class);
                intent.putExtra("type" , "meat");
                startActivity(intent);
            }
        });

        bread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListItemsActivity.class);
                intent.putExtra("type" , "bread");
                startActivity(intent);

            }
        });

        nonFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListItemsActivity.class);
                intent.putExtra("type" , "nonFood");
                startActivity(intent);

            }
        });
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListItemsActivity.class);
                intent.putExtra("type" , "food");
                startActivity(intent);
            }
        });
    }
}
