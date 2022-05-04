package com.example.best_ideas.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.best_ideas.R;
import com.example.best_ideas.databinding.ActivityProjectDetailsBinding;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class Project_Details_Activity extends AppCompatActivity {

    ActivityProjectDetailsBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProjectDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        AdRequest adRequest = new AdRequest.Builder().build();
        binding.adView.loadAd(adRequest);


        setSupportActionBar(binding.toolbarBack);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);
        getSupportActionBar().setTitle("تفاصيل المشروع");

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String description = intent.getStringExtra("description");
        String cost = intent.getStringExtra("cost");

        binding.screenDetailsTvName.setText(name);
        binding.screenDetailsTvDescription.setText(description);
        binding.screenDetailsTvCostInfo.setText(cost);

//        int img = intent.getIntExtra("img",0);
//        binding.img.setImageResource(img);

    }

    // toolBar Back
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed(); // toolBar Back
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}