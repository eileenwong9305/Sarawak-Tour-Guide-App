package com.example.android.sarawaktourguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Eileen on 10/21/2017.
 */

public class EventsFragment extends Fragment {
    public EventsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tour_list, container, false);

        // Create an arraylist of event.
        final ArrayList<Tour> tours = new ArrayList<>();
        tours.add(new Tour(R.string.event_name_1, R.string.event_location_1, R.string.event_date_1,
                R.string.event_url_1, R.string.event_phone_1, R.string.event_type_1,
                R.string.event_description_1, R.drawable.tidal_bore_festival));
        tours.add(new Tour(R.string.event_name_2, R.string.event_location_2, R.string.event_date_2,
                R.string.event_url_2, R.string.event_phone_2, R.string.event_type_2,
                R.string.event_description_2, R.drawable.rainforest_puppet));
        tours.add(new Tour(R.string.event_name_3, R.string.event_location_3, R.string.event_date_3,
                R.string.event_url_3, R.string.event_phone_3, R.string.event_type_3,
                R.string.event_description_3, R.drawable.sarawak_international_dragon));
        tours.add(new Tour(R.string.event_name_4, R.string.event_location_4, R.string.event_date_4,
                R.string.event_url_4, R.string.event_phone_4, R.string.event_type_4,
                R.string.event_description_4, R.drawable.regatta));
        tours.add(new Tour(R.string.event_name_5, R.string.event_location_5, R.string.event_date_5,
                R.string.event_url_5, R.string.event_phone_5, R.string.event_type_5,
                R.string.event_description_5, R.drawable.countdown));
        tours.add(new Tour(R.string.event_name_6, R.string.event_location_6, R.string.event_date_6,
                R.string.event_url_6, R.string.event_phone_6, R.string.event_type_6,
                R.string.event_description_6, R.drawable.world_harvest_festival));

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
