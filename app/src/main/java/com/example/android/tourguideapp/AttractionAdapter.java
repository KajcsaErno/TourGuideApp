package com.example.android.tourguideapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AttractionAdapter extends ArrayAdapter<Attraction> {

    AttractionAdapter(Activity context, ArrayList<Attraction> attractions) {
        super(context, 0, attractions);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Attraction currentAttraction = getItem(position);
        //getting the current item
//        View view = super.getView(position,convertView,parent);
        if (currentAttraction != null && convertView != null) {

            //alternate row colors
            if (position % 2 == 1) {
                convertView.setBackgroundColor(getContext().getResources().getColor(R.color.myRed));
            } else {
                convertView.setBackgroundColor(getContext().getResources().getColor(R.color.colorPrimary));
            }


            //Setting the attraction name
            TextView nameTextView = listItemView.findViewById(R.id.name);
            nameTextView.setText(currentAttraction.getAttractionName());

            //Setting the attraction telephone number if it has any
            TextView phoneTextView = listItemView.findViewById(R.id.phone);
            if ("".equals(currentAttraction.getAttractionPhoneNumber()))
                phoneTextView.setVisibility(View.GONE);
            else {
                phoneTextView.setVisibility(View.VISIBLE);
                phoneTextView.setText(currentAttraction.getAttractionPhoneNumber());
            }

            //Setting the attraction website
            TextView websiteTextView = listItemView.findViewById(R.id.website);
            websiteTextView.setText(currentAttraction.getAttractionWebsite());

            //Setting the Attraction Address
            TextView addressTextView = listItemView.findViewById(R.id.address);
            addressTextView.setText(currentAttraction.getAttractionAddress());

            //Setting the image
            ImageView imageView = listItemView.findViewById(R.id.image_view);
            imageView.setImageResource(currentAttraction.getImageResourceId());

        }

        return listItemView;
    }


}
