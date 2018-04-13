package com.example.android.tourguideapp;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class ClujFragment extends Fragment {


    public ClujFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        // Create a list of attractions
        final ArrayList<Attraction> attractions = new ArrayList<>();

        attractions.add(new Attraction(getResources().getString(R.string.cluj_attraction_name_1), getResources().getString(R.string.cluj_attraction_phone_1), getResources().getString(R.string.cluj_attraction_website_1), getResources().getString(R.string.cluj_attraction_address_1), R.drawable.cj1));
        attractions.add(new Attraction(getResources().getString(R.string.cluj_attraction_name_2), getResources().getString(R.string.cluj_attraction_phone_2), getResources().getString(R.string.cluj_attraction_website_2), getResources().getString(R.string.cluj_attraction_address_2), R.drawable.cj2));
        attractions.add(new Attraction(getResources().getString(R.string.cluj_attraction_name_3), getResources().getString(R.string.cluj_attraction_phone_3), getResources().getString(R.string.cluj_attraction_website_3), getResources().getString(R.string.cluj_attraction_address_3), R.drawable.cj3));
        attractions.add(new Attraction(getResources().getString(R.string.cluj_attraction_name_4), getResources().getString(R.string.cluj_attraction_phone_4), getResources().getString(R.string.cluj_attraction_website_4), getResources().getString(R.string.cluj_attraction_address_4), R.drawable.cj4));
        attractions.add(new Attraction(getResources().getString(R.string.cluj_attraction_name_5), getResources().getString(R.string.cluj_attraction_phone_5), getResources().getString(R.string.cluj_attraction_website_5), getResources().getString(R.string.cluj_attraction_address_4), R.drawable.cj5));

        AttractionAdapter adapter = new AttractionAdapter(getActivity(), attractions);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            Intent websiteIntent = new Intent(Intent.ACTION_VIEW);

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Attraction attraction = attractions.get(position);
                String url = attraction.getAttractionWebsite();
                websiteIntent.setData(Uri.parse(url));
                startActivity(websiteIntent);


            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                Attraction attraction = attractions.get(position);
                Uri gmmIntentUri = Uri.parse(getResources().getString(R.string.locationUri) + attraction.getAttractionName());
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);

                return true;
            }
        });

        return rootView;
    }

}
