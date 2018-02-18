package com.example.sportsoriv.firebasetest;

/**
 * Created by sportsoriv on 7/5/17.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sportsoriv on 6/30/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<ListItem> listItems;

    public MyAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    private Context context;


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ListItem listItem = listItems.get(position);

        holder.textViewHead.setText("Username: " + listItem.getHead());
        holder.textViewDesc.setText("Answer 1: " + listItem.getDesc());
        holder.textViewId.setText("Answer 2: " + listItem.getTrackid());
        holder.answer3.setText("Answer 3: " + listItem.getAnswer3());
        holder.answer4.setText("Answer 4: " + listItem.getAnswer4());
        holder.answer5.setText("Answer 5: " + listItem.getAnswer5());
        holder.answer6.setText("Answer 6: " + listItem.getAnswer6());
        holder.image.setText("Image Name: " + listItem.getImage());
        holder.latitude.setText("Latitude: " +listItem.getLatitude());
        holder.longitude.setText("Longitude: " + listItem.getLongitutde());




    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewHead;
        public TextView textViewDesc;
        public TextView textViewId;
        public TextView answer3;
        public TextView answer4;
        public TextView answer5;
        public TextView answer6;
        public TextView image;
        public TextView latitude;
        public TextView longitude;



        public ViewHolder(View itemView) {
            super(itemView);

            textViewHead = (TextView) itemView.findViewById(R.id.textViewHead);
            textViewDesc = (TextView) itemView.findViewById(R.id.textViewDesc);
            textViewId = (TextView) itemView.findViewById(R.id.textViewId);
            answer3 = (TextView) itemView.findViewById(R.id.answer3);
            answer4 = (TextView) itemView.findViewById(R.id.answer4);
            answer5 = (TextView) itemView.findViewById(R.id.answer5);
            answer6 = (TextView) itemView.findViewById(R.id.answer6);
            image = (TextView) itemView.findViewById(R.id.image);
            latitude = (TextView) itemView.findViewById(R.id.latitude);
            longitude =  (TextView) itemView.findViewById(R.id.longitude);


        }
    }
}