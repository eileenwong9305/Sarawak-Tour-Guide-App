package com.example.android.sarawaktourguide;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * {@link Tour} represents attraction, restaurant, tour package, hotel.
 * It contains the detailed information.
 * Resource: https://coderwall.com/p/vfbing/passing-objects-between-activities-in-android
 */
public class Tour extends ArrayList<Parcelable> implements Parcelable {

    /**
     * This field is needed for Android to be able to create new objects, individually or as arrays
     * Else, Android framework will raises an exception.
     * Parcelable protocol requires a Parcelable.Creator object called CREATOR
     */
    public static final Parcelable.Creator<Tour> CREATOR
            = new Parcelable.Creator<Tour>() {
        public Tour createFromParcel(Parcel in) {
            return new Tour(in);
        }

        public Tour[] newArray(int size) {
            return new Tour[size];
        }
    };
    /**
     * Name of the place
     */
    private int mName;
    /**
     * Address of the place
     */
    private int mAddress;
    /**
     * Time or date of the place
     */
    private int mTime;
    /**
     * Website url of the place
     */
    private int mUrl;
    /**
     * Description of the place
     */
    private int mDescription;
    /**
     * Short description of the place
     */
    private int mShortDescription = 0;
    /**
     * Contact number of the place
     */
    private int mPhone;
    /**
     * Entrance fee of the place
     */
    private int mFee = 0;
    /**
     * Attraction type of the place
     */
    private int mType;
    /**
     * Photo of the place
     */
    private int mImageResourceId;

    /**
     * Require for using parcelable
     */
    private Tour(Parcel source) {
        mName = source.readInt();
        mAddress = source.readInt();
        mTime = source.readInt();
        mUrl = source.readInt();
        mPhone = source.readInt();
        mType = source.readInt();
        mFee = source.readInt();
        mDescription = source.readInt();
        mShortDescription = source.readInt();
        mImageResourceId = source.readInt();
    }

    /**
     * Create a new Tour object
     */
    public Tour(int name, int address, int time, int url, int phone,
                int type, int fee, int description, int shortDescription,
                int imageResourceId) {
        mName = name;
        mAddress = address;
        mTime = time;
        mUrl = url;
        mPhone = phone;
        mType = type;
        mFee = fee;
        mDescription = description;
        mShortDescription = shortDescription;
        mImageResourceId = imageResourceId;
    }

    /**
     * Create a new Tour object
     */
    public Tour(int name, int address, int time, int url, int phone,
                int type, int fee, int description, int imageResourceId) {
        mName = name;
        mAddress = address;
        mTime = time;
        mUrl = url;
        mPhone = phone;
        mType = type;
        mDescription = description;
        mFee = fee;
        mImageResourceId = imageResourceId;
    }

    /**
     * Create a new Tour object
     */
    public Tour(int name, int address, int time, int url, int phone,
                int type, int description, int imageResourceId) {
        mName = name;
        mAddress = address;
        mTime = time;
        mUrl = url;
        mPhone = phone;
        mType = type;
        mDescription = description;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get name of the place
     *
     * @return name of the place
     */
    public int getName() {
        return mName;
    }

    /**
     * Get address of the place
     *
     * @return address of the place
     */
    public int getAddress() {
        return mAddress;
    }

    /**
     * Get location of the place to show on google map
     *
     * @return location of the place.
     */
    public int getLocation() {
        if (hasFee()) {
            // for attraction, hotel, and restaurant fragment
            return mName;
        } else {
            // for event fragment
            return mAddress;
        }
    }

    /**
     * Get opening hour of the place
     *
     * @return opening hour of the place
     */
    public int getTime() {
        return mTime;
    }

    /**
     * Get url of the place
     *
     * @return url of the place
     */
    public int getUrl() {
        return mUrl;
    }

    /**
     * Get phone of the place
     *
     * @return phone of the place
     */
    public int getPhone() {
        return mPhone;
    }

    /**
     * Get type of the place
     *
     * @return type of the place
     */
    public int getType() {
        return mType;
    }

    /**
     * Get fee of the place
     *
     * @return fee of the place
     */
    public int getFee() {
        return mFee;
    }

    /**
     * Get description of the place
     *
     * @return description of the place
     */
    public int getDescription() {
        return mDescription;
    }

    /**
     * Get short description of the place
     *
     * @return short description of the place
     */
    public int getShortDescription() {
        return mShortDescription;
    }

    /**
     * Get image resource id of the place
     *
     * @return image resource id of the place
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an short description.
     *
     * @return true if there is an short description and vice versa
     */
    public boolean hasShortDesc() {
        return mShortDescription != 0;
    }

    /**
     * Returns whether or not there is an fee.
     *
     * @return true if there is an short description and vice versa
     */
    public boolean hasFee() {
        return mFee != 0;
    }

    /**
     * Define the kind of object that to be parcel
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Actual object serialization happens here, Write object content
     * to parcel, reading should be done according to this write order
     *
     * @param dest  - parcel
     * @param flags - Additional flags about how the object should be written
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mName);
        dest.writeInt(mAddress);
        dest.writeInt(mTime);
        dest.writeInt(mUrl);
        dest.writeInt(mPhone);
        dest.writeInt(mType);
        dest.writeInt(mFee);
        dest.writeInt(mDescription);
        dest.writeInt(mShortDescription);
        dest.writeInt(mImageResourceId);
    }
}
