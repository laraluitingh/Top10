package com.example.top10;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class rest_detail extends Fragment {

    public static final String ARG_ITEM_ID = "item_id";
    private TopTen mRest;



    public rest_detail() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getArguments().containsKey(ARG_ITEM_ID)) {
            // Finding the object in the array list
            mRest = TopTen.pick(getArguments().getString(ARG_ITEM_ID));
            this.getActivity().setTitle(mRest.getName());
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_rest_detail, container, false);

        //setting the value's TextView by calling the get methods of the object
        if(mRest != null) {
            ((TextView) rootView.findViewById(R.id.restName)).setText(mRest.getName());
            ((TextView) rootView.findViewById(R.id.rating)).setText(Double.toString(mRest.getRating()));
            ((TextView) rootView.findViewById(R.id.cuisine)).setText(mRest.getCusineType());
            ((TextView) rootView.findViewById(R.id.address)).setText(mRest.getAddress());
            String nameP=mRest.getPic();

            //finding the image in the drawable file
            int photo1=getResources().getIdentifier(nameP,"drawable", "com.example.top10");

            //setting ImageView
            ((ImageView) rootView.findViewById(R.id.photo)).setImageResource(photo1);

            ((Button) rootView.findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //calling relevant method
                    searchRest(mRest.getName());
                }
            });

            ((Button) rootView.findViewById(R.id.map)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //calling relevant method
                    showMap(mRest.getAddress());
                }
            });

            /*
            photo=(ImageView)findViewById(R.id.photo);
            String nameP=rest.getPic();

            int photo1=getResources().getIdentifier(nameP,"drawable", "com.example.top10");

            photo.setImageResource(photo1);

             */

        }

        return rootView;
    }

    //creating the method when search button is clicked

    public void searchRest(String name) {


        Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q="+name+"&oq="+name+"&aqs=chrome..69i57j0l7.2404j1j7&sourceid=chrome&ie=UTF-8"));

        startActivity(browserIntent);
    }

    //creating the method when Show Map button button is clicked

    public void showMap(String name1) {

        Uri gmmIntentUri = Uri.parse("geo:0,0?q= " + name1 + "");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

    /*
    private void searchCoin(String name) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=" + name));
        startActivity(intent);
    }

     */
}
