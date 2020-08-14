package com.notoverflow.a2nddegre;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class Activity_7 extends AppCompatActivity {
    private    AdRequest adRequest;
    private AdView    adView;

    LineGraphSeries<DataPoint> series;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_7);


        float a,c,b,d;

        Intent temp;
        temp = getIntent();
        a = temp.getFloatExtra("coef_A",0);
        b = temp.getFloatExtra("coef_B",0);
        c = temp.getFloatExtra("coef_C",0);

        d= b*b-4*a*c;







        double x,y;


        GraphView graph = (GraphView) findViewById(R.id.graph);
//        x = (-b-Math.sqrt(Math.abs(d))/(2*a));

        double xMin;
        double dt = 2*Math.max (Math.sqrt (Math.abs (d / (2 * a))), 5);

        xMin = -Math.abs (b / (2 * a)) - dt;

        series= new LineGraphSeries<DataPoint>();
        for (int i=0; i<500;i++){
            x=xMin+2*dt*i/500;
            y= a*x*x+b*x+c;
            series.appendData(new DataPoint(x,y),true,500);
//a améliorer
        }

        graph.addSeries(series);

        graph.getViewport().setXAxisBoundsManual(false);
//        graph.getViewport().setMinX(-500);
//        graph.getViewport().setMaxX(500);

        graph.getViewport().setYAxisBoundsManual(false);
//        graph.getViewport().setMinY(-50);
//        graph.getViewport().setMaxY(50);


        graph.getViewport().setScalable(true);
        graph.getViewport().setScalableY(true);

        Toast.makeText(getApplicationContext(),"Zommer avec les doigts",Toast.LENGTH_LONG).show();


        ImageView retour;
        retour = findViewById(R.id.retour);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
