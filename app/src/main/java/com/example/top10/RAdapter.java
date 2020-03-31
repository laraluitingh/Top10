package com.example.top10;


import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class RAdapter extends RecyclerView.Adapter<RAdapter.RestViewHolder> {


    private MainActivity mParentActivity;
    private ArrayList<TopTen> mRest;
    private boolean mTwoPane;


    /*
    public interface OnClickListener {
        void OnClick(int position);
    }

     */
    //creating actions when an item is clicked in the recyclerview
    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            TopTen rest = (TopTen) v.getTag();
            //if device has a wide screen initialise fragment in the detail container
            //else switch to new activity
            if(mTwoPane) {
                Bundle arguments = new Bundle();
                arguments.putString(rest_detail.ARG_ITEM_ID, rest.getName());
                rest_detail fragment = new rest_detail();
                fragment.setArguments(arguments);

                mParentActivity.getSupportFragmentManager().beginTransaction().replace(R.id.detail_container, fragment).commit();
            } else {
                Context context = v.getContext();
                Intent intent = new Intent(context, RestDetail2.class);
                intent.putExtra(rest_detail.ARG_ITEM_ID, rest.getName());
                context.startActivity(intent);
            }
        }
    };

    //the adapter's constructor
    public RAdapter(MainActivity parent, ArrayList<TopTen> rest1, boolean twoPane) {
        mParentActivity = parent;
        mRest = rest1;
        mTwoPane = twoPane;
    }

    public static class RestViewHolder extends RecyclerView.ViewHolder  {
        public TextView name, cuisine, rating;

        public RestViewHolder(View v) {
            super(v);
            name = v.findViewById(R.id.rName);
            cuisine = v.findViewById(R.id.cuisine);
             rating = v.findViewById(R.id.rate);
        }
    }

    @Override
    public RAdapter.RestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating itemr XML in recyclerview
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemr, parent, false);
        return new RestViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RestViewHolder holder, int position) {
        //populating textView with restaurant data by calling get methods.
        // and initialising the onClickListner
        TopTen rest = mRest.get(position);
        holder.name.setText(rest.getName());
        holder.cuisine.setText(rest.getCusineType());
        holder.rating.setText(Double.toString(rest.getRating()));
        holder.itemView.setTag(rest);
        holder.itemView.setOnClickListener(mOnClickListener);
    }

    /*




    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView rName;
        public TextView rating;
        public TextView cuisine;
        OnClickListener onClickListener;

        public ViewHolder(View itemView, OnClickListener onClickListener){

            super(itemView);

            rName=(TextView) itemView.findViewById(R.id.rName);
            rating=(TextView) itemView.findViewById(R.id.rate);
            cuisine=(TextView) itemView.findViewById(R.id.cuisine);
            this.onClickListener=onClickListener;
            itemView.setOnClickListener(this);

        }



        @Override
        public void onClick(View v) {
            onClickListener.OnClick(getAdapterPosition());
        }
    }

    private List<TopTen> mRest;

    public RAdapter(List<TopTen> rest, OnClickListener mOnClickListner){
        mRest=rest;
        this.cOnCklickListner=mOnClickListner;

    }

    @Override
    public RAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View restView = inflater.inflate(R.layout.itemr, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(restView, cOnCklickListner);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        TopTen rest = mRest.get(position);

        // Set item views based on your views and data model
        TextView textView = viewHolder.rName;
        textView.setText(rest.getName());

        TextView textView2 = viewHolder.rating;
        textView2.setText(Double.toString(rest.getRating()));

        TextView textView3=viewHolder.cuisine;
        textView3.setText(rest.getCusineType());



    }

     */


    @Override
    public int getItemCount() {
        return mRest.size();
    }


}
