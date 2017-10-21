package com.example.android.sarawaktourguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Eileen on 10/20/2017.
 */

public class RestaurantFragment extends Fragment {
    public RestaurantFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tour_list, container, false);

        // Create an arraylist of restaurant places.
        final ArrayList<Tour> tours = new ArrayList<>();
        tours.add(new Tour(R.string.restaurant_name_1, R.string.restaurant_address_1,
                R.string.restaurant_hour_1, R.string.restaurant_url_1, R.string.restaurant_phone_1,
                R.string.restaurant_type_1, R.string.restaurant_price_1,
                R.string.restaurant_description_1, R.drawable.the_dyak));
        tours.add(new Tour(R.string.restaurant_name_2, R.string.restaurant_address_2,
                R.string.restaurant_hour_2, R.string.restaurant_url_2, R.string.restaurant_phone_2,
                R.string.restaurant_type_2, R.string.restaurant_price_2,
                R.string.restaurant_description_2, R.drawable.jambu_restaurant));
        tours.add(new Tour(R.string.restaurant_name_3, R.string.restaurant_address_3,
                R.string.restaurant_hour_3, R.string.restaurant_url_3, R.string.restaurant_phone_3,
                R.string.restaurant_type_3, R.string.restaurant_price_3,
                R.string.restaurant_description_3, R.drawable.topspot));
        tours.add(new Tour(R.string.restaurant_name_4, R.string.restaurant_address_4,
                R.string.restaurant_hour_4, R.string.restaurant_url_4, R.string.restaurant_phone_4,
                R.string.restaurant_type_4, R.string.restaurant_price_4,
                R.string.restaurant_description_4, R.drawable.balkanico_pizza));
        tours.add(new Tour(R.string.restaurant_name_5, R.string.restaurant_address_5,
                R.string.restaurant_hour_5, R.string.restaurant_url_5, R.string.restaurant_phone_5,
                R.string.restaurant_type_5, R.string.restaurant_price_5,
                R.string.restaurant_description_5, R.drawable.chong_choon));
        tours.add(new Tour(R.string.restaurant_name_6, R.string.restaurant_address_6,
                R.string.restaurant_hour_6, R.string.restaurant_url_6, R.string.restaurant_phone_6,
                R.string.restaurant_type_6, R.string.restaurant_price_6,
                R.string.restaurant_description_6, R.drawable.my_little_kitchen));

        // Create an {@link TourAdapter}, whose data source is a list of {@link Tour}s.
        TourAdapter tourAdapter = new TourAdapter(getActivity(), tours);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {link ListView} use the {@link TourAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Tour} in the list.
        listView.setAdapter(tourAdapter);

        return rootView;
    }
}
