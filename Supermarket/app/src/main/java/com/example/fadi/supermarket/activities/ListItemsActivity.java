package com.example.fadi.supermarket.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.example.fadi.supermarket.R;

public class ListItemsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items);
        ScrollView scrollView = (ScrollView) findViewById(R.id.scrollView);

        Intent intent = getIntent();
        String type = intent.getStringExtra("type");

        switch(type){

            case "meat":
                System.out.println("meat");
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

}
