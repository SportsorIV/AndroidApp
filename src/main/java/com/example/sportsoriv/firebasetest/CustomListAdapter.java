package com.example.sportsoriv.firebasetest;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by sportsoriv on 12/10/17.
 */

public class CustomListAdapter extends ArrayAdapter<Product>{

    ArrayList<Product> products;
    Context context;
    int resource;

    public CustomListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<Product> products) {
        super(context, resource, products);
        this.products = products;
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.custom_list_layout,null,true);



        }
        Product product = getItem(position);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageViewProduct);
        Picasso.with(context).load("http://cir.di.ionio.gr/~p13stav/" + product.getImage().substring(2)).into(imageView);
        TextView txtName = (TextView) convertView.findViewById(R.id.txtName);
        txtName.setText("Username: " + product.getName());
        TextView txtPrice = (TextView) convertView.findViewById(R.id.txtPrice);
        txtPrice.setText("Answer 1: " + product.getPrice());
        TextView answer2 = (TextView) convertView.findViewById(R.id.answer2);
        answer2.setText("Answer 2: " + product.getAnswer2());
        TextView answer3 = (TextView) convertView.findViewById(R.id.answer3);
        answer3.setText("Answer 3: " + product.getAnswer3());
        TextView answer4 = (TextView) convertView.findViewById(R.id.answer4);
        answer4.setText("Answer 4: " +product.getAnswer4());
        TextView answer5 = (TextView) convertView.findViewById(R.id.answer5);
        answer5.setText("Answer 5: " + product.getAnswer5());
        TextView answer6 = (TextView) convertView.findViewById(R.id.answer6);
        answer6.setText("Answer 6: " + product.getAnswer6());
        TextView latitude = (TextView) convertView.findViewById(R.id.latitude_posted);
        latitude.setText("Latitude: " + product.getLatitude());
        TextView longitude = (TextView) convertView.findViewById(R.id.longitude_posted);
        longitude.setText("Longitude: " + product.getLongitude());


        return convertView;
    }
}
