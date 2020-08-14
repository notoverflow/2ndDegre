package com.notoverflow.a2nddegre;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class Activity_4 extends AppCompatActivity {
    private    AdRequest adRequest;
    private AdView    adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {


            }
        });

        float a,c,b,d;

        Intent temp;
        temp = getIntent();
        a = temp.getFloatExtra("coef_A",0);
        b = temp.getFloatExtra("coef_B",0);
        c = temp.getFloatExtra("coef_C",0);

        d= b*b-4*a*c;


        TextView aV = findViewById(R.id.aV);
        TextView bV = findViewById(R.id.bV);
        TextView cV = findViewById(R.id.cV);
        TextView deltaV = findViewById(R.id.deltaV);
        TextView x1V = findViewById(R.id.x1V);
        TextView x1Vbis = findViewById(R.id.x1Vbis);
        TextView x1 = findViewById(R.id.x1);
        TextView x2 = findViewById(R.id.x2);
        TextView x2V = findViewById(R.id.x2V);
        TextView x2bis = findViewById(R.id.x2bis);
        TextView plus = findViewById(R.id.plus);
        TextView x1bis = findViewById(R.id.x1bis);
        TextView x2Vbis = findViewById(R.id.x2Vbis);
        TextView bla = findViewById(R.id.bla);
        ImageView retour = findViewById(R.id.retour);


        aV.setText(String.format ("% .3g",(a)));
        bV.setText(String.format ("% .3g",(b)));
        cV.setText(String.format ("% .3g",(c)));
        deltaV.setText(String.format ("% .3g",(d)));
        if (d<0)
        {
            plus.setText("Δ<0");
            bla.setText("Le discriminant est négatif,\nil n'y a donc pas de solution");

            x1V.setVisibility(View.INVISIBLE);
            x1bis.setVisibility(View.INVISIBLE);
            x1Vbis.setVisibility(View.INVISIBLE);
            x1.setVisibility(View.INVISIBLE);
            x2V.setVisibility(View.INVISIBLE);
            x2.setVisibility(View.INVISIBLE);
            x2bis.setVisibility(View.INVISIBLE);
            x2Vbis.setVisibility(View.INVISIBLE);
        }
        if (d==0)
        {
            plus.setText("Δ=0");
            bla.setText("Le discriminant est nul,\nil y a donc qu'une seule solution ");
            x1.setText("X0=");
            x1V.setText("-b/(2a)");
            x1bis.setText("X0≈");
            x1Vbis.setText(String.format ("% .3g",((-b/(2*a)) )));
            x2V.setVisibility(View.INVISIBLE);
            x2.setVisibility(View.INVISIBLE);
            x2bis.setVisibility(View.INVISIBLE);
            x2Vbis.setVisibility(View.INVISIBLE);

        }

        if (d>0)
        {
            plus.setText("Δ>0");
            bla.setText("Le discriminant est positif,\nil y a donc deux solutions");
            x1.setText("X1=");
            x1bis.setText("X1≈");
            x1V.setText("(-b-√Δ)/(2a)");
            x1Vbis.setText(String.format ("% .3g",(-b-Math.sqrt(d))/(2*a)));
            x2V.setText("(-b+√Δ)/(2a)");
            x2bis.setText ("X2≈");
            x2Vbis.setText(String.format ("% .3g",(((-b+Math.sqrt(d))/(2*a)))));
        }


        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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