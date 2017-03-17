package com.example.android.quizapptvseries;

import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.CollapsingToolbarLayout;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    CustomDialog alert;
    CollapsingToolbarLayout collapsingToolbar;
    Toolbar toolbar;
    ImageView first_ImageView;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alert = new CustomDialog();
        alert.showDialog(MainActivity.this);
        name = alert.getName();
        setActionOnScrollUp();

        first_ImageView = (ImageView) findViewById(R.id.imageView);
        Picasso.with(this)
                .load(R.drawable.dexter)
                .fit()
                .centerCrop()
                .into(first_ImageView);
    }

    //Set text on actionBar when scrolling up.
    public void setActionOnScrollUp() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        collapsingToolbar.setTitle("TV Series - Quiz");
        collapsingToolbar.setExpandedTitleColor(ResourcesCompat.getColor(getResources(), android.R.color.transparent, null));
    }
}
