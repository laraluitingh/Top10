package com.example.top10;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RAdapter extends RecyclerView.Adapter<RAdapter.ViewHolder> {

    private OnClickListener cOnCklickListner;

    public interface OnClickListener {
        void OnClick(int position);
    }


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


    @Override
    public int getItemCount() {
        return mRest.size();
    }


}
