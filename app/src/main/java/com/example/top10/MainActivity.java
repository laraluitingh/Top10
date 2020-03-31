package com.example.top10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity  {

    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //the if statement will help program identify whether the device is a phone or a tablet by determining whether the screen has a detail container

        if (findViewById(R.id.detail_container) != null) {
            mTwoPane = true;
        }


        // setting up the recycler view
        RecyclerView mRecyclerView = findViewById(R.id.rvRest);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        //get TopTen restaurant data by calling the getRest() method
        RecyclerView.Adapter mAdapter = new RAdapter(this, TopTen.getRest(), mTwoPane);
        mRecyclerView.setAdapter(mAdapter);
    }


    /*
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private  RecyclerView.LayoutManager layoutManager;

     */

    /*
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










/*

    }





    //called when the user click launch button

 */
    /*
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

     */
}
