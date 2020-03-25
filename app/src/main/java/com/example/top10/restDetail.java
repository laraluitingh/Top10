package com.example.top10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class restDetail extends AppCompatActivity {

    private static final String TAG = "RestDetail2";

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
        TextView myText3 = (TextView) findViewById(R.id.rate);
        myText3.setText(rating);

        TextView myText4 = (TextView) findViewById(R.id.rate);
        myText4.setText(rest.getAddress());

    }

    public void browser(View view) {
        TextView myText1 = (TextView) findViewById(R.id.restName);
        String text1= (String) myText1.getText();

        Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q="+text1+"&oq="+text1+"&aqs=chrome..69i57j0l7.2404j1j7&sourceid=chrome&ie=UTF-8"));

        startActivity(browserIntent);
    }

}
