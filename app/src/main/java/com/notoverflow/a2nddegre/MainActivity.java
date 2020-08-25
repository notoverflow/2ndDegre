package com.notoverflow.a2nddegre;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;


public class MainActivity extends AppCompatActivity {

    private AdRequest adRequest;
    private AdView adView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {



        Log.i ("tttt", "ok1");
        super.onCreate(savedInstanceState);
        Log.i ("tttt", "ok1");
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {


            }
        });

        AdView adView = findViewById(R.id.adView);

        Log.i ("tttt", "ok1");


        Button button = findViewById(R.id.button);       // associe le bouton dans java avec le bouton XML


        button.setOnClickListener(new View.OnClickListener() {      // procédure exuter sur le click
            @Override
            public void onClick(View v) {


                Intent activitysuivante = new Intent(getApplicationContext(),choix.class );

                startActivity(activitysuivante);


            }
        });



        loadPub();


    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        if (adView != null) {
            adView.resume();

        }
    }

    @Override
    protected void onPause() {
        if (adView != null) {
            adView.pause();
        }
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        if (adView != null) {
            adView.destroy();

        }
        super.onDestroy();
    }

    private void loadPub() {
        adRequest = new AdRequest.Builder()
                .addTestDevice("72BC668537B5617DBB7381C8C100AF34")      // id dui device de test pour les pubs
                .build();

        adView=findViewById(R.id.adView);
        adView.loadAd(adRequest);

        adView.setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                super.onAdClosed();
            }

            @Override
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
            }

            @Override
            public void onAdClicked() {
                super.onAdClicked();
            }
        });


    }




}