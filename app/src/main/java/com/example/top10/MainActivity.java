package com.example.top10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RAdapter.OnClickListener {

    /*
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private  RecyclerView.LayoutManager layoutManager;

     */

    ArrayList<TopTen> rest;

    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        launchApp();

        /*
        RecyclerView rvCoin=(RecyclerView) findViewById(R.id.rvCoin);

        coin=Coin.getCoins();

        CoinAdapter adapter=new CoinAdapter(coin);

        rvCoin.setAdapter(adapter);
        rvCoin.setLayoutManager(new LinearLayoutManager(this));

         */












    }





    //called when the user click launch button
    private void launchApp(){

        RecyclerView rvCoin=(RecyclerView) findViewById(R.id.rvRest);

        rest=TopTen.getRest();

        RAdapter adapter=new RAdapter(rest,this);

        rvCoin.setAdapter(adapter);
        rvCoin.setLayoutManager(new LinearLayoutManager(this));


    }


    @Override
    public void OnClick(int position) {
        Log.d(TAG, "OnClick:");
        // Intent myIntent=new Intent(getBaseContext(),CoinDetail.class);
        Intent intent=new Intent(this,RestDetail2.class );
        intent.putExtra("value1", rest.get(position));
        startActivity(intent);
    }
}
