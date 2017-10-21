package com.example.android.sarawaktourguide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AttractionFragment extends Fragment {

    public AttractionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tour_list, container, false);

        // Create an arraylist of attraction places.
        final ArrayList<Tour> tours = new ArrayList<>();
        tours.add(new Tour(R.string.attraction_name_1, R.string.attraction_address_1,
                R.string.attraction_hour_1, R.string.attraction_url_1, R.string.attraction_phone_1,
                R.string.attraction_type_1, R.string.attraction_fee_1, R.string.attraction_description_1,
                R.string.attraction_short_desc_1, R.drawable.bako_national_park));
        tours.add(new Tour(R.string.attraction_name_2, R.string.attraction_address_2,
                R.string.attraction_hour_2, R.string.attraction_url_2, R.string.attraction_phone_2,
                R.string.attraction_type_2, R.string.attraction_fee_2, R.string.attraction_description_2,
                R.string.attraction_short_desc_2, R.drawable.sarawak_cultural_village));
        tours.add(new Tour(R.string.attraction_name_3, R.string.attraction_address_3,
                R.string.attraction_hour_3, R.string.attraction_url_3, R.string.attraction_phone_3,
                R.string.attraction_type_3, R.string.attraction_fee_3, R.string.attraction_description_3,
                R.string.attraction_short_desc_3, R.drawable.mulu_national_park));
        tours.add(new Tour(R.string.attraction_name_4, R.string.attraction_address_4,
                R.string.attraction_hour_4, R.string.attraction_url_4, R.string.attraction_phone_4,
                R.string.attraction_type_4, R.string.attraction_fee_4, R.string.attraction_description_4,
                R.string.attraction_short_desc_4, R.drawable.semenggoh_nature_reserve));
        tours.add(new Tour(R.string.attraction_name_5, R.string.attraction_address_5,
                R.string.attraction_hour_5, R.string.attraction_url_5, R.string.attraction_phone_5,
                R.string.attraction_type_5, R.string.attraction_fee_5, R.string.attraction_description_5,
                R.string.attraction_short_desc_5, R.drawable.kuching_waterfront));
        tours.add(new Tour(R.string.attraction_name_6, R.string.attraction_address_6,
                R.string.attraction_hour_6, R.string.attraction_url_6, R.string.attraction_phone_6,
                R.string.attraction_type_6, R.string.attraction_fee_6, R.string.attraction_description_6,
                R.string.attraction_short_desc_6, R.drawable.brooke_gallery));

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
