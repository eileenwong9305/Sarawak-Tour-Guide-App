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

public class HotelsFragment extends Fragment {
    public HotelsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tour_list, container, false);

        // Create an arraylist of hotel.
        final ArrayList<Tour> tours = new ArrayList<>();
        tours.add(new Tour(R.string.hotel_name_1, R.string.hotel_address_1, R.string.hotel_hour_1,
                R.string.hotel_url_1, R.string.hotel_phone_1, R.string.hotel_type_1,
                R.string.hotel_price_1, R.string.hotel_description_1, R.drawable.pullman_kuching));
        tours.add(new Tour(R.string.hotel_name_2, R.string.hotel_address_2, R.string.hotel_hour_2,
                R.string.hotel_url_2, R.string.hotel_phone_2, R.string.hotel_type_2,
                R.string.hotel_price_2, R.string.hotel_description_2, R.drawable.grand_margherita));
        tours.add(new Tour(R.string.hotel_name_3, R.string.hotel_address_3, R.string.hotel_hour_3,
                R.string.hotel_url_3, R.string.hotel_phone_3, R.string.hotel_type_3,
                R.string.hotel_price_3, R.string.hotel_description_3, R.drawable.imperial_riverbank));
        tours.add(new Tour(R.string.hotel_name_4, R.string.hotel_address_4, R.string.hotel_hour_4,
                R.string.hotel_url_4, R.string.hotel_phone_4, R.string.hotel_type_4,
                R.string.hotel_price_4, R.string.hotel_description_4, R.drawable.merdeka_palace));
        tours.add(new Tour(R.string.hotel_name_5, R.string.hotel_address_5, R.string.hotel_hour_5,
                R.string.hotel_url_5, R.string.hotel_phone_5, R.string.hotel_type_5,
                R.string.hotel_price_5, R.string.hotel_description_5, R.drawable.hilton_hotel));
        tours.add(new Tour(R.string.hotel_name_6, R.string.hotel_address_6, R.string.hotel_hour_6,
                R.string.hotel_url_6, R.string.hotel_phone_6, R.string.hotel_type_6,
                R.string.hotel_price_6, R.string.hotel_description_6, R.drawable.check_in_lodge));

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
