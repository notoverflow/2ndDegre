package com.notoverflow.a2nddegre;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class Activity_5 extends AppCompatActivity {
    private    AdRequest adRequest;
    private AdView    adView;

    RadioButton B1, B2, B3, B4;
    TextView résultat, forme;
    ImageView image;


    private float a, c, b, d;
    private float x1;
    private float x2;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);


        Intent temp;
        temp = getIntent();
        a = temp.getFloatExtra("coef_A", 0);
        b = temp.getFloatExtra("coef_B", 0);
        c = temp.getFloatExtra("coef_C", 0);
        float tempa;

        x1=0f;
        x2=0f;
        float x00;



        d = b * b - 4 * a * c;

       if (d>=0)
       {
           x1 = (float) ((-b - Math.sqrt(d)) / (2 * a));
           x2 = (float) ((-b + Math.sqrt(d)) / (2 * a));

           if (x2<x1)
           {

               tempa=x2;
               x2 =x1;
               x1=tempa;
           }
       }
        x00 = -b/2*a;


        TextView aV = findViewById(R.id.aV);
        TextView bV = findViewById(R.id.bV);
        TextView cV = findViewById(R.id.cV);
        TextView dV = findViewById(R.id.deltaV);
        résultat = findViewById(R.id.résultat);
        TextView x0 = findViewById(R.id.x0);
        TextView x20 = findViewById(R.id.x2);

        B1 = findViewById(R.id.B1);
        B2 = findViewById(R.id.B2);
        B3 = findViewById(R.id.B3);
        B4 = findViewById(R.id.B4);
        forme = findViewById(R.id.forme);
        image=findViewById(R.id.image);


        aV.setText("" + a);
        bV.setText("" + b);
        cV.setText("" + c);
        dV.setText("" + d);


        if (d>0)
        {
            x0.setText(String.format("X1 =%.2f",x1 ));
            x20.setText(String.format("X2=%.2f",x2 ));

            if (a>0)
            {
                image.setImageResource(R.drawable.dpap);
            }
            if (a<0)
            {
                image.setImageResource(R.drawable.dpan);

            }
        }
        if (d==0)
        {
            x0.setText(String.format("X0=%.2f", x00));

            if (a>0)
            {
                image.setImageResource(R.drawable.dzap);
            }
            if (a<0)
            {
                image.setImageResource(R.drawable.dzan);
            }
        }
        if (d<0)
        {
            if (a>0)
            {
                image.setImageResource(R.drawable.dnap);
            }

            if (a<0)
            {
                image.setImageResource(R.drawable.dnan);
            }
        }

        B1.setOnClickListener(new RadioButton.OnClickListener() { //inf a 0
            @Override
            public void onClick (View v) {
                if (b>=0&&c>=0)
                {
                    forme.setText(String.format("%.2fx²+%.2fx+%.2f<0", a, b, c));
                }
                if (b>=0&&c<0)
                {
                    forme.setText(String.format("%.2fx²+%.2fx%.2f<0", a, b, c));
                }
                if (b<0&&c>=0)
                {
                    forme.setText(String.format("%.2fx²%.2fx+%.2f<0", a, b, c));
                }
                if (b<0&&c<0)
                {
                    forme.setText(String.format("%.2fx²%.2fx%.2f<0", a, b, c));
                }




                if (d < 0) {
                    if (a > 0) {
                        résultat.setText("S= ∅");
                    }
                    if (a < 0) {
                        résultat.setText("S=ℝ");

                    }
                }

                if (d == 0) {
                    if (a < 0) {
                        résultat.setText(String.format("S=]-∞;%.2f[∪]%.2f;+∞", x1, x1));
                    }

                    if (a > 0) {
                        résultat.setText("S= ∅");
                    }
                }
                if (d > 0) {
                    if (a > 0) {
                        résultat.setText(String.format("S=]%.2f;%.2f[", x1, x2));
                    }
                    if (a < 0) {
                        résultat.setText(String.format("S=]-∞;%.2f[∪]%.2f;+∞[", x1, x2));
                    }
                }
            }
        });

        B2.setOnClickListener(new RadioButton.OnClickListener() {//sup a 0
            @Override
            public void onClick (View v) {

                if (b>=0&&c>=0)
                {
                    forme.setText(String.format("%.2fx²+%.2fx+%.2f>0", a, b, c));
                }
                if (b>=0&&c<0)
                {
                    forme.setText(String.format("%.2fx²+%.2fx%.2f>0", a, b, c));
                }
                if (b<0&&c>=0)
                {
                    forme.setText(String.format("%.2fx²%.2fx+%.2f>0", a, b, c));
                }
                if (b<0&&c<0)
                {
                    forme.setText(String.format("%.2fx²%.2fx%.2f>0", a, b, c));
                }


                if (d < 0) {
                    if (a > 0) {
                        résultat.setText("S=ℝ");
                    }
                    if (a < 0) {
                        résultat.setText("S= ∅");

                    }
                }
                if (d == 0) {
                    if (a < 0) {
                        résultat.setText("S= ∅");
                    }

                    if (a > 0) {
                        résultat.setText(String.format("S=]-∞;%.2f[∪]%.2f;+∞", x1, x1));
                    }
                }
                if (d > 0) {
                    if (a > 0) {
                        résultat.setText(String.format("S=]-∞;%.2f[∪]%.2f;+∞[", x1, x2));
                    }
                    if (a < 0) {
                        résultat.setText(String.format("S=]%.2f;%.2f[", x1, x2));
                    }
                }
            }
        });
        B3.setOnClickListener(new RadioButton.OnClickListener() {//inf ou = a 0
            @Override
            public void onClick (View v) {
                if (b>=0&&c>=0)
                {
                    forme.setText(String.format("%.2fx²+%.2fx+%.2f≤0", a, b, c));
                }
                if (b>=0&&c<0)
                {
                    forme.setText(String.format("%.2fx²+%.2fx%.2f≤0", a, b, c));
                }
                if (b<0&&c>=0)
                {
                    forme.setText(String.format("%.2fx²%.2fx+%.2f≤0", a, b, c));
                }
                if (b<0&&c<0)
                {
                    forme.setText(String.format("%.2fx²%.2fx%.2f≤0", a, b, c));
                }
                if (d < 0) {
                    if (a > 0) {
                        résultat.setText("S= ∅");
                    }
                    if (a < 0) {
                        résultat.setText("S=ℝ");
                    }
                }
                if (d == 0) {
                    if (a < 0) {
                        résultat.setText("S=ℝ");
                    }
                    if (a > 0) {
                        résultat.setText(String.format("S={%.2f}", x1));
                    }
                }
                if (d > 0) {
                    if (a > 0) {
                        résultat.setText(String.format("S=[%.2f;%.2f]", x1, x2));
                    }
                    if (a < 0) {
                        résultat.setText(String.format("S=]-∞;%.2f]∪][%.2f;+∞", x1, x2));
                    }
                }
            }
        });
        B4.setOnClickListener(new RadioButton.OnClickListener() { // sup ou = a 0
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick (View v) {
                if (b>=0&&c>=0)
                {
                    forme.setText(String.format("%.2fx²+%.2fx+%.2f≥0", a, b, c));
                }
                if (b>=0&&c<0)
                {
                    forme.setText(String.format("%.2fx²+%.2fx%.2f≥0", a, b, c));
                }
                if (b<0&&c>=0)
                {
                    forme.setText(String.format("%.2fx²%.2fx+%.2f≥0", a, b, c));
                }
                if (b<0&&c<0)
                {
                    forme.setText(String.format("%.2fx²%.2fx%.2f≥0", a, b, c));
                }

                if (d < 0) {
                    if (a > 0) {
                        résultat.setText("S=ℝ");

                    }
                    if (a < 0) {
                        résultat.setText("S= ∅");
                    }
                }
                if (d == 0) {
                    if (a < 0) {
                        résultat.setText(String.format("S=]-∞;%.2f]∪[%.2f;+∞[", x1, x1));
                    }
                    if (a > 0) {
                        résultat.setText("S=]-∞;+∞[");
                    }
                }
                if (d > 0) {
                    if (a > 0) {
                        résultat.setText(String.format("S=]-∞;%.2f]∪[%.2f;+∞[", x1, x2));
                    }
                    if (a
 < 0) {
                        résultat.setText(String.format("S=[%.2f;%.2f]", x1, x2));
                    }
                }
            }
        });


        ImageView retour = findViewById(R.id.retour);

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
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
