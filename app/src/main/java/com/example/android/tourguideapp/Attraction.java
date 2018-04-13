package com.example.android.tourguideapp;

public class Attraction {

    private String mAttractionName;
    private String mAttractionPhoneNumber;
    private String mAttractionWebsite;
    private String mAttractionAddress;
    private int mImageResourceId;


    public Attraction(String attractionName, String attractionPhoneNumber, String attractionWebsite, String attractionAddress, int imageResourceId) {
        this.mAttractionName = attractionName;
        this.mAttractionPhoneNumber = attractionPhoneNumber;
        this.mAttractionWebsite = attractionWebsite;
        this.mAttractionAddress = attractionAddress;
        this.mImageResourceId = imageResourceId;

    }

    public String getAttractionName() {
        return mAttractionName;
    }

    public String getAttractionPhoneNumber() {
        return mAttractionPhoneNumber;
    }

    public String getAttractionWebsite() {
        return mAttractionWebsite;
    }

    public String getAttractionAddress() {
        return mAttractionAddress;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }



}
