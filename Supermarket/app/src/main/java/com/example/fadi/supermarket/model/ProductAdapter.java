package com.example.fadi.supermarket.model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fadi.supermarket.R;

import java.util.ArrayList;
import java.util.List;


public class ProductAdapter extends ArrayAdapter<Product> {

    private Context mContext;
    private List<Product> productList = new ArrayList<>();

    public ProductAdapter(@NonNull Context context, ArrayList<Product> list) {
        super(context, 0, list);
        mContext = context;
        productList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false);

        Product product = productList.get(position);

        ImageView imageView = (ImageView) listItem.findViewById(R.id.imageView_image);
        imageView.setImageResource(R.drawable.no_image);

        TextView nameTextView = (TextView) listItem.findViewById(R.id.textView_name);
        nameTextView.setText(product.getName());

        TextView priceTextView = (TextView) listItem.findViewById(R.id.textView_price);
        priceTextView.setText(product.getPrice() + "");

        return listItem;
    }
}