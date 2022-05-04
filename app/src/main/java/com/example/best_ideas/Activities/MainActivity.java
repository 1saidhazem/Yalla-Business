package com.example.best_ideas.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.best_ideas.Adapters.Adapter_bests_rv_main;
import com.example.best_ideas.Database.DatabaseAccess;
import com.example.best_ideas.Models.Projects;
import com.example.best_ideas.databinding.ActivityMainBinding;
import com.example.best_ideas.Adapters.onItemClickListenerRV;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.rewarded.RewardedAd;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Adapter_bests_rv_main adapter_BestAgriculturalProjects, adapter_BestCommercialAndFinancialProjects,
            adapter_BestIndustrialProjects, adapter_BestServiceProjects,
            adapter_BestTechnicalProjects;

    private ActivityMainBinding binding;
    private DatabaseAccess db;
    public static String key = null;
    private AdRequest adRequest;
    private InterstitialAd mInterstitialAd;
    private RewardedAd mRewardedAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.mainToolbar);

        db = DatabaseAccess.getInstance(this);
        db.open();
        
        adRequest = new AdRequest.Builder().build();
        InterstitialAd.load(this,"ca-app-pub-3940256099942544/1033173712", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                        Log.i("ttt", "onAdLoaded");
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        Log.i("ttt", loadAdError.getMessage());
                        mInterstitialAd = null;
                    }
                });

        // *******
//        if (mInterstitialAd != null) {
//            mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
//                @Override
//                public void onAdDismissedFullScreenContent() {
//                    // Called when fullscreen content is dismissed.
//                    Log.d("TAG", "The ad was dismissed.");
//                }
//
//                @Override
//                public void onAdFailedToShowFullScreenContent(AdError adError) {
//                    // Called when fullscreen content failed to show.
//                    Log.d("TAG", "The ad failed to show.");
//                }
//
//                @Override
//                public void onAdShowedFullScreenContent() {
//                    // Called when fullscreen content is shown.
//                    // Make sure to set your reference to null so you don't
//                    // show it a second time.
//                    mInterstitialAd = null;
//                    Log.d("TAG", "The ad was shown.");
//                }
//            });
//        }
//        else {
//            Log.d("ttt","ERROR");
//        }
        binding.btnTechnicalProjects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(MainActivity.this);
                } else {
                    Log.d("TAG", "The interstitial ad wasn't ready yet.");
                }
                Intent intent = new Intent(getBaseContext(), screen_Activity_Projects.class);
                key = "Technical";
                intent.putExtra(key, "Technical");
                startActivity(intent);

            }
        });

        binding.btnServiceProjects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(MainActivity.this);
                } else {
                    Log.d("TAG", "The interstitial ad wasn't ready yet.");
                }
                Intent intent = new Intent(getBaseContext(), screen_Activity_Projects.class);
                key = "Service";
                intent.putExtra(key, "Service");
                startActivity(intent);
            }
        });

        binding.btnIndustrialProjects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(MainActivity.this);
                } else {
                    Log.d("TAG", "The interstitial ad wasn't ready yet.");
                }
                Intent intent = new Intent(getBaseContext(), screen_Activity_Projects.class);
                key = "Industrial";
                intent.putExtra(key, "Industrial");
                startActivity(intent);
            }
        });

        binding.btnAgriculturalProjects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(MainActivity.this);
                } else {
                    Log.d("TAG", "The interstitial ad wasn't ready yet.");
                }
                Intent intent = new Intent(getBaseContext(), screen_Activity_Projects.class);
                key = "Agricultural";
                intent.putExtra(key, "Agricultural");
                startActivity(intent);
            }
        });

        binding.btnCommercialAndFinancialProjects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(MainActivity.this);
                } else {
                    Log.d("TAG", "The interstitial ad wasn't ready yet.");
                }
                Intent intent = new Intent(getBaseContext(), screen_Activity_Projects.class);
                key = "CommercialAndFinancial";
                intent.putExtra(key, "CommercialAndFinancial");
                startActivity(intent);
            }
        });

        {
            ArrayList<Projects> list_BestTechnicalProjects = db.getBestTechnicalProjects();

            adapter_BestTechnicalProjects = new Adapter_bests_rv_main("Technical", list_BestTechnicalProjects, new onItemClickListenerRV() {
                @Override
                public void onItemClickedListener(Projects projects) {
                    String name = projects.getName();
                    String description = projects.getDescription();
                    String cost = projects.getCost();

                    Intent intent = new Intent(getBaseContext(), Project_Details_Activity.class);
                    intent.putExtra("name", name);
                    intent.putExtra("description", description);
//                    intent.putExtra("img", img);
                    intent.putExtra("cost", cost);
                    startActivity(intent);
                }
            });
//            RecyclerView.LayoutManager layoutManager_BestTechnicalProjects =
//                    new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            LinearLayoutManager layoutManager_BestTechnicalProjects = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            layoutManager_BestTechnicalProjects.setStackFromEnd(true);
            binding.mainRvBestTechnicalProjects.setHasFixedSize(true);
            binding.mainRvBestTechnicalProjects.setLayoutManager(layoutManager_BestTechnicalProjects);
            binding.mainRvBestTechnicalProjects.setAdapter(adapter_BestTechnicalProjects);
        }

        {
            ArrayList<Projects> list_BestAgriculturalProjects = db.getBestAgriculturalProjects();

            adapter_BestAgriculturalProjects = new Adapter_bests_rv_main("Agricultural", list_BestAgriculturalProjects, new onItemClickListenerRV() {
                @Override
                public void onItemClickedListener(Projects projects) {
                    String name = projects.getName();
                    String description = projects.getDescription();
                    String cost = projects.getCost();
//                  int img = projects.getImg();
                    /*
                    RewardedAd.load(this, "ca-app-pub-3940256099942544/5224354917",
                            adRequest, new RewardedAdLoadCallback() {
                                @Override
                                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                                    // Handle the error.
                                    Log.d("ttt", loadAdError.getMessage());
                                    mRewardedAd = null;
                                }

                                @Override
                                public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
                                    mRewardedAd = rewardedAd;
                                    Log.d("ttt", "Ad was loaded.");
                                }
                            });
                     */
                    Intent intent = new Intent(getBaseContext(), Project_Details_Activity.class);
                    intent.putExtra("name", name);
                    intent.putExtra("description", description);
                    intent.putExtra("cost", cost);
                    startActivity(intent);

                }
            });

            LinearLayoutManager layoutManager_BestAgriculturalProjects = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            layoutManager_BestAgriculturalProjects.setStackFromEnd(true);
            binding.mainRvBestAgriculturalProjects.setHasFixedSize(true);
            binding.mainRvBestAgriculturalProjects.setLayoutManager(layoutManager_BestAgriculturalProjects);
            binding.mainRvBestAgriculturalProjects.setAdapter(adapter_BestAgriculturalProjects);
        }

        {
            ArrayList<Projects> list_BestCommercialAndFinancialProjects = db.getBestCommercialAndFinancialProjects();

            adapter_BestCommercialAndFinancialProjects = new Adapter_bests_rv_main("CommercialAndFinancial", list_BestCommercialAndFinancialProjects, new onItemClickListenerRV() {
                @Override
                public void onItemClickedListener(Projects projects) {
                    String name = projects.getName();
                    String description = projects.getDescription();
                    String cost = projects.getCost();
//                  int img = projects.getImg();
                    Intent intent = new Intent(getBaseContext(), Project_Details_Activity.class);
                    intent.putExtra("name", name);
                    intent.putExtra("description", description);
                    intent.putExtra("cost", cost);
                    startActivity(intent);
                }
            });
//            RecyclerView.LayoutManager layoutManager_BestCommercialAndFinancialProjects =
//                    new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            LinearLayoutManager layoutManager_BestCommercialAndFinancialProjects = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            layoutManager_BestCommercialAndFinancialProjects.setStackFromEnd(true);
            binding.mainRvBestCommercialAndFinancialProjects.setHasFixedSize(true);
            binding.mainRvBestCommercialAndFinancialProjects.setLayoutManager(layoutManager_BestCommercialAndFinancialProjects);
            binding.mainRvBestCommercialAndFinancialProjects.setAdapter(adapter_BestCommercialAndFinancialProjects);
        }

        {
            ArrayList<Projects> list_BestIndustrialProjects = db.getBestIndustrialProjects();

            adapter_BestIndustrialProjects = new Adapter_bests_rv_main("Industrial", list_BestIndustrialProjects, new onItemClickListenerRV() {
                @Override
                public void onItemClickedListener(Projects projects) {
                    String name = projects.getName();
                    String description = projects.getDescription();
                    String cost = projects.getCost();
//                  int img = projects.getImg();
                    Intent intent = new Intent(getBaseContext(), Project_Details_Activity.class);
                    intent.putExtra("name", name);
                    intent.putExtra("description", description);
                    intent.putExtra("cost", cost);
                    startActivity(intent);
                }
            });
//            RecyclerView.LayoutManager layoutManager_BestIndustrialProjects =
//                    new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            LinearLayoutManager layoutManager_BestIndustrialProjects = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            layoutManager_BestIndustrialProjects.setStackFromEnd(true);
            binding.mainRvBestIndustrialProjects.setHasFixedSize(true);
            binding.mainRvBestIndustrialProjects.setLayoutManager(layoutManager_BestIndustrialProjects);
            binding.mainRvBestIndustrialProjects.setAdapter(adapter_BestIndustrialProjects);
        }

        {
            ArrayList<Projects> list_BestServiceProjects = db.getBestServiceProjects();

            adapter_BestServiceProjects = new Adapter_bests_rv_main("Service", list_BestServiceProjects, new onItemClickListenerRV() {
                @Override
                public void onItemClickedListener(Projects projects) {
                    String name = projects.getName();
                    String description = projects.getDescription();
                    String cost = projects.getCost();
//                  int img = projects.getImg();
                    Intent intent = new Intent(getBaseContext(), Project_Details_Activity.class);
                    intent.putExtra("name", name);
                    intent.putExtra("description", description);
                    intent.putExtra("cost", cost);
                    startActivity(intent);
                }
            });
//            RecyclerView.LayoutManager layoutManager_BestServiceProjects =
//                    new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            LinearLayoutManager layoutManager_BestServiceProjects = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            layoutManager_BestServiceProjects.setStackFromEnd(true);
            binding.mainRvBestServiceProjects.setHasFixedSize(true);
            binding.mainRvBestServiceProjects.setLayoutManager(layoutManager_BestServiceProjects);
            binding.mainRvBestServiceProjects.setAdapter(adapter_BestServiceProjects);
        }

        db.close();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (mInterstitialAd != null) {
            mInterstitialAd.show(MainActivity.this);
        } else {
            Log.d("TAG", "The interstitial ad wasn't ready yet.");
        }
    }
}