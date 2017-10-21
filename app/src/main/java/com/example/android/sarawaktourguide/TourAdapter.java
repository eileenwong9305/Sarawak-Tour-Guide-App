package com.example.android.sarawaktourguide;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TourAdapter extends ArrayAdapter<Tour> {

    public TourAdapter(Activity context, ArrayList<Tour> tour) {
        super(context, 0, tour);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        ViewHolder holder;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.single_item_list, parent, false);

            // Cache view fields into the holder
            holder = new ViewHolder(listItemView);
            // Associate the holder with view for later lookup.
            listItemView.setTag(holder);
        } else {
            // If view exists, get the holder instance from the view.
            holder = (ViewHolder) listItemView.getTag();
        }

        // Get the {@link Tour} object located at this position in the list
        final Tour currentTour = getItem(position);

        // Get the photo of the place from current Tour object and set this image on the photo ImageView.
        holder.photoImageView.setImageResource(currentTour.getImageResourceId());

        // Get the description from current Tour object and set this text on the type TextView.
        holder.typeTextView.setText(currentTour.getType());

        // Get the name of the place from current Tour object and set this text on the name TextView.
        holder.nameTextView.setText(currentTour.getName());

        if (currentTour.hasShortDesc()) {
            // Get the description from current Tour object and set this text on the short description TextView.
            holder.shortDescTextView.setText(currentTour.getShortDescription());
        } else if (currentTour.hasFee()) {
            // Get the price from current Tour object and set this text on the short description TextView.
            holder.shortDescTextView.setText(currentTour.getFee());
        } else {
            holder.shortDescTextView.setText(currentTour.getTime());
        }

        // Set a click listener to play open activity with the detail of tour when the
        // list item is clicked on
        listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the detail activity
                Intent detailIntent = new Intent(getContext(), DetailActivity.class);
                // Set the parcelable object {@link Tour} to an intent
                detailIntent.putExtra("tour", (Parcelable) currentTour);
                getContext().startActivity(detailIntent);
            }
        });

        // Return whole list item layout.
        return listItemView;
    }

    static class ViewHolder {
        @BindView(R.id.photo_image)
        ImageView photoImageView;
        @BindView(R.id.type_text)
        TextView typeTextView;
        @BindView(R.id.name_text)
        TextView nameTextView;
        @BindView(R.id.short_desc_text)
        TextView shortDescTextView;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
