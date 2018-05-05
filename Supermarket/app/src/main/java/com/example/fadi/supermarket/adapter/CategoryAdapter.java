package com.example.fadi.supermarket.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fadi.supermarket.R;
import com.example.fadi.supermarket.activity.ListItemsActivity;
import com.example.fadi.supermarket.model.Category;

import java.util.ArrayList;
import java.util.List;


public class CategoryAdapter extends ArrayAdapter<Category> {

    private Context mContext;
    private List<Category> categoryList = new ArrayList<>();

    public CategoryAdapter(@NonNull Context context, ArrayList<Category> list) {
        super(context, 0, list);
        mContext = context;
        categoryList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.category_list_item, parent, false);

        final Category category = categoryList.get(position);

        ImageView imageView = (ImageView) listItem.findViewById(R.id.imageView_image);
        imageView.setImageResource(R.drawable.no_image);

        TextView nameTextView = (TextView) listItem.findViewById(R.id.textView_name);
        nameTextView.setText(category.getName());

        listItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ListItemsActivity.class);
                intent.putExtra("categoryId", category.getId());
                mContext.startActivity(intent);
            }
        });

        return listItem;
    }
}