package com.example.top10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class RestDetail2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_detail2);

        if (savedInstanceState == null) {
            Bundle arguments = new Bundle();
            arguments.putString(rest_detail.ARG_ITEM_ID, getIntent().getStringExtra(rest_detail.ARG_ITEM_ID));
            rest_detail fragment = new rest_detail();
            fragment.setArguments(arguments);

            //Initialising fragment in the detailContainer
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.detail_container, fragment)
                    .commit();
        }
    }
     /*
    private static final String TAG = "activity_rest_detail2";
    private ImageView photo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        setContentView(R.layout.activity_rest_detail2);

        TopTen rest=(TopTen)getIntent().getSerializableExtra("value1");

        TextView myText1 = (TextView) findViewById(R.id.restName);
        myText1.setText(rest.getName());

        TextView myText2 = (TextView) findViewById(R.id.cuisine);
        myText2.setText(rest.getCusineType());

        String rating= Double.toString(rest.getRating());
        TextView myText3 = (TextView) findViewById(R.id.rating);
        myText3.setText(rating);

        TextView myText4 = (TextView) findViewById(R.id.address);
        myText4.setText(rest.getAddress());

        photo=(ImageView)findViewById(R.id.photo);
        String nameP=rest.getPic();

        int photo1=getResources().getIdentifier(nameP,"drawable", "com.example.top10");

        photo.setImageResource(photo1);

    }

    public void browser(View view) {
        TextView myText1 = (TextView) findViewById(R.id.restName);
        String text1= (String) myText1.getText();

        Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q="+text1+"&oq="+text1+"&aqs=chrome..69i57j0l7.2404j1j7&sourceid=chrome&ie=UTF-8"));

        startActivity(browserIntent);
    }

    public void showMap(View view){
        TextView addr=(TextView) findViewById(R.id.address);
        String text10=(String) addr.getText();

        Uri gmmIntentUri = Uri.parse("geo:0,0?q= "+text10+"");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);

    }

      */
}
