package com.sohaeb.wia.Events;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.sohaeb.wia.R;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        TextView title = (TextView) findViewById(R.id.details_title);
        TextView body = (TextView) findViewById(R.id.details_body);
        ImageView imageView = (ImageView) findViewById(R.id.details_imageView);

        Intent intent = getIntent();

        title.setText(intent.getStringExtra("title"));
        body.setText(intent.getStringExtra("body"));
        Picasso.with(getApplicationContext()).load(intent.getStringExtra("image")).into(imageView);
    }
}
