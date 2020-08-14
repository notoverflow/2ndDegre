package com.notoverflow.a2nddegre;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class Activity_9 extends AppCompatActivity {
    private    AdRequest adRequest;
    private AdView    adView;

    private EditText V0V,HV,alphaV;
    private TextView résultatHoraires = findViewById(R.id.résultatHoraires);
    private TextView résultatMouvement = findViewById(R.id.résultatMouvement);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_9);


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {


            }
        });







        V0V=findViewById(R.id.V0V);
        HV=findViewById(R.id.H0V);
        alphaV =findViewById(R.id.alphaV);

        Button caculer = findViewById(R.id.calculer);
        ImageView information = findViewById(R.id.informationButton);

        information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activitysuivante = new Intent(getApplicationContext(),informationObjet.class);
                startActivity(activitysuivante);
            }
        });

        caculer.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"SetTextI18n", "DefaultLocale"})
            @Override
            public void onClick(View v) {

                float v1, h, alpha;

                boolean ok;

                String txt;

                ok = true;
                alpha = 0;
                v1 = 0;
                h = 0;


                txt = alphaV.getText ().toString ();
                if (txt.length () > 0)
                    alpha = Float.parseFloat(txt);
                else ok = false;


                txt = V0V.getText ().toString ();
                if (txt.length () > 0)
                    v1 = Float.parseFloat(txt);
                else ok = false;


                txt = HV.getText ().toString ();
                if (txt.length () > 0)
                    h = Float.parseFloat(txt);
                else ok = false;

                if (ok) {


                    résultatHoraires.setText ("x≈"+ (String.format ("% .3g",(((Math.cos (alpha*3.14159265359/180)* v1)))))+"*t\ny≈-4.9*t²+"+(String.format ("% .3g",((v1*Math.sin (alpha*3.14159265359/180)))))+"t+"+(String.format ("% .3g",(h))));
                    résultatMouvement.setText("y≈ "+(String.format ("% .3g", (((-4.9/(v1*v1*Math.cos (alpha*3.14159265359/180)*Math.cos (alpha*3.14159265359/180))))))+"x²+"+(String.format ("% .3g",((Math.tan (alpha*3.14159265359/180)))))+"*x+"+(String.format ("% .3g",(h)))));

                }
                else Toast.makeText(getApplicationContext(),"Remplir les données et cliquer sur calculer",Toast.LENGTH_SHORT).show();

                ImageView retour;
                retour = findViewById(R.id.retour);
                retour.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                    }
                });

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