package com.example.android.sarawaktourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Get the parcelable object from intent extras(bundle)
        Bundle bundle = getIntent().getExtras();
        final Tour tour = bundle.getParcelable("tour");

        // Find the imageview and update the image
        ImageView photoImageView = (ImageView) findViewById(R.id.photo_detail_image);
        photoImageView.setImageResource(tour.getImageResourceId());

        // Update the text in the detail activity.
        updateView(tour);

        // Find the Linear Layout in the detail_activity.xml layout with the ID address_layout.
        LinearLayout addressLayout = (LinearLayout) findViewById(R.id.address_layout);
        // Open Google map app with the address when address layout is clicked.
        addressLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri mapIntentUri = Uri.parse("geo:0,0?q=" + getString(tour.getLocation()));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, mapIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
            }
        });

        // Find the Linear Layout in the detail_activity.xml layout with the ID url_layout.
        LinearLayout urlLayout = (LinearLayout) findViewById(R.id.url_layout);
        // Open web browser with the webpage shown when url layout is clicked.
        urlLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webpageUri = Uri.parse(getString(tour.getUrl()));
                Intent webpageIntent = new Intent(Intent.ACTION_VIEW, webpageUri);
                if (webpageIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(webpageIntent);
                }
            }
        });

        // Find the Linear Layout in the detail_activity.xml layout with the ID phone_layout.
        LinearLayout phoneLayout = (LinearLayout) findViewById(R.id.phone_layout);
        // Open phone app with the phone number when phone layout is clicked.
        phoneLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
                phoneIntent.setData(Uri.parse("tel:" + getString(tour.getPhone())));
                if (phoneIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(phoneIntent);
                }
            }
        });
    }

    private void updateView(Tour tour) {
        // Change the name of the place or tour in TextView ID name_detail_text
        TextView nameTextView = (TextView) findViewById(R.id.name_detail_text);
        nameTextView.setText(tour.getName());

        // Change the description of the place or tour in TextView ID desc_detail_text
        TextView descTextView = (TextView) findViewById(R.id.desc_detail_text);
        descTextView.setText(tour.getDescription());

        // Change the address of the place or tour in TextView ID address_detail_text
        TextView addressTextView = (TextView) findViewById(R.id.address_detail_text);
        addressTextView.setText(tour.getAddress());

        // Change the type of the place or tour in TextView ID type_detail_text
        TextView typeTextView = (TextView) findViewById(R.id.type_detail_text);
        typeTextView.setText(tour.getType());

        // Change the url of the place or tour in TextView ID type_detail_text
        TextView urlTextView = (TextView) findViewById(R.id.url_detail_text);
        if (getString(tour.getUrl()).equals("-")) {
            findViewById(R.id.url_layout).setVisibility(View.GONE);
        } else {
            urlTextView.setText(tour.getUrl());
        }

        // Change the contact number of the place or tour in TextView ID phone_detail_text or
        // remove the phone layout if no phone number.
        TextView phoneTextView = (TextView) findViewById(R.id.phone_detail_text);
        if (getString(tour.getPhone()).equals("-")) {
            findViewById(R.id.phone_layout).setVisibility(View.GONE);
        } else {
            phoneTextView.setText(tour.getPhone());
        }

        // Change the opening hour of the place or tour in TextView ID opening_hour_text_view
        TextView timeTextView = (TextView) findViewById(R.id.opening_hour_text_view);
        timeTextView.setText(tour.getTime());

        // Change the fee of the place or tour in TextView ID fee_text_view
        TextView feeTextView = (TextView) findViewById(R.id.fee_text_view);
        if (tour.hasFee()) {
            feeTextView.setText(tour.getFee());
        } else {
            findViewById(R.id.fee_layout).setVisibility(View.GONE);
        }
    }
}
