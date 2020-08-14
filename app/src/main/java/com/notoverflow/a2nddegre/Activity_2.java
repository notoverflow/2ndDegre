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

public class Activity_2 extends AppCompatActivity {
    private    AdRequest adRequest;
    private AdView    adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);



        float a,c,b,d,alfa,beta;

        Intent temp;
        temp = getIntent();
        a = temp.getFloatExtra("coef_A",0);
        b = temp.getFloatExtra("coef_B",0);
        c = temp.getFloatExtra("coef_C",0);

        float delta = b * b - 4 * a * c;
        d= delta;
        alfa= (-b)/(2*a);
        beta= -delta/(4*a);


        ImageView retour;

        TextView aV = findViewById(R.id.aV);
        TextView bV = findViewById(R.id.bV);
        TextView cV = findViewById(R.id.cV);
        TextView dV = findViewById(R.id.deltaV);
        TextView alfaV = findViewById(R.id.alphaV);
        TextView betaV = findViewById(R.id.betaV);
        TextView resultat = findViewById(R.id.resultat);

        if (alfa>0 && beta>0)
        {
            resultat.setText(String.format ("% .3g",(a))+"(x-"+(String.format ("% .3g",(alfa)))+")²-"+(String.format ("% .3g",beta)));
        }

        if (alfa<=0 && beta<=0)
        {
            resultat.setText(String.format ("% .3g",(a))+"(x+"+(String.format ("% .3g",(-1f*alfa)))+")²+"+(String.format ("% .3g",(-1f*beta))));
        }
        if (alfa>0 && beta <=0)
        {
            resultat.setText(String.format ("% .3g",(a))+"(x-"+(String.format ("% .3g",(alfa)))+")²+"+(String.format ("% .3g",(-1f*beta))));
        }

        if (alfa<=0 && beta>0)
        {
            resultat.setText(String.format ("% .3g",(a))+"(x+"+(String.format ("% .3g",+(-1f*alfa))+")²-"+(String.format ("% .3g",(beta)))));
        }



        aV.setText(String.format ("% .3g",(a)));
        bV.setText(String.format ("% .3g",(b)));
        cV.setText(String.format ("% .3g",(c)));
        dV.setText(String.format ("% .3g",(d)));
        alfaV.setText(String.format ("% .3g",(alfa)));
        betaV.setText(String.format ("% .3g",(beta)));


        retour=findViewById(R.id.retour);




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