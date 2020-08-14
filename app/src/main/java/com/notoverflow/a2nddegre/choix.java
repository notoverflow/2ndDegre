package com.notoverflow.a2nddegre;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class choix extends AppCompatActivity {
    private AdRequest adRequest;
    private AdView    adView;


    private EditText aV,bV,cV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix);



        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {


            }
        });


        Button b1 = findViewById(R.id.delta);
        Button b2 = findViewById(R.id.canonique);
        Button b3 = findViewById(R.id.factoriser);
        Button b4 = findViewById(R.id.équatioon);
        Button b5 = findViewById(R.id.inéquatioon);
        Button b6 = findViewById(R.id.variation);
        Button b7 = findViewById(R.id.graphique);
        Button b9 = findViewById(R.id.balllistique);
        Button b8 = findViewById(R.id.extrémum);

        aV=findViewById(R.id.coefA);
        bV=findViewById(R.id.coefB);
        cV=findViewById(R.id.coefC);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent activitysuivante = new Intent(getApplicationContext(), Activity_1.class);

                activiteSuivante(activitysuivante);

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activitysuivante = new Intent(getApplicationContext(),Activity_2.class );

                activiteSuivante(activitysuivante);
            }
        });


        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activitysuivante = new Intent(getApplicationContext(),Activity_3.class );

                activiteSuivante(activitysuivante);
            }
        });


        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activitysuivante = new Intent(getApplicationContext(),Activity_4.class );

                activiteSuivante(activitysuivante);
            }
        });


        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activitysuivante = new Intent(getApplicationContext(),Activity_5.class );

                activiteSuivante(activitysuivante);
            }
        });


        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activitysuivante = new Intent(getApplicationContext(),Activity_6.class );

                activiteSuivante(activitysuivante);
            }
        });


        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activitysuivante = new Intent(getApplicationContext(),Activity_7.class );

                activiteSuivante(activitysuivante);
            }
        });


        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activitysuivante = new Intent(getApplicationContext(),Activity_8.class );

                activiteSuivante(activitysuivante);
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent activitysuivante = new Intent(getApplicationContext(),Activity_9.class );

                startActivity(activitysuivante);

            }
        });
    }



    void activiteSuivante(Intent act)
    {


        float a,b,c;


        boolean ok;

        String txt;

        ok =true;
        a=0;
        b=0;
        c=0;


        txt = aV.getText().toString();
        if (txt.length()>0)
            a = Float.parseFloat(txt);
        else ok=false;

        if (a==0)
        {
            ok=false;
        }

        txt = bV.getText().toString();
        if (txt.length()>0)
            b = Float.parseFloat(txt);
        else ok=false;


        txt = cV.getText().toString();
        if (txt.length()>0)
            c = Float.parseFloat(txt);
        else ok=false;

        if (ok) {

//transmision des données
            act.putExtra("coef_A", a);
            act.putExtra("coef_B", b);
            act.putExtra("coef_C", c);
//fin des transmision des données

            startActivity(act);
        }
        else Toast.makeText(getApplicationContext(),"Les Coefs ne sont pas correct",Toast.LENGTH_SHORT).show();

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
        loadPub();
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