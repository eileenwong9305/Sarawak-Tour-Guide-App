package com.example.android.sarawaktourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * {@link CategoryAdapter} is a {@link FragmentPagerAdapter} that can provide the layout for each
 * list item based on a data source which is a list of {@link Tour} objects.
 */
public class CategoryAdapter extends FragmentPagerAdapter {

    /**
     * Context of the app
     */
    private Context mContext;

    /**
     * Create a new {@link CategoryAdapter} object.
     *
     * @param fm is the fragment manage that will keep each fragment's state in the adapter
     *           across swipes.
     */
    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     *
     * @param position page number
     * @return {@link Fragment}
     */
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HotelsFragment();
            case 1:
                return new RestaurantFragment();
            case 2:
                return new AttractionFragment();
            default:
                return new EventsFragment();
        }
    }

    /**
     * @return total number of pages.
     */
    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.hotels);
        } else if (position == 1) {
            return mContext.getString(R.string.restaurants);
        } else if (position == 2) {
            return mContext.getString(R.string.attractions);
        } else {
            return mContext.getString(R.string.events);
        }
    }
}
