package com.notoverflow.a2nddegre;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_6 extends AppCompatActivity {

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_6);

        float a,c,b,d, xE,yE;

        Intent temp;
        temp = getIntent();
        a = temp.getFloatExtra("coef_A",0);
        b = temp.getFloatExtra("coef_B",0);
        c = temp.getFloatExtra("coef_C",0);

        d= b*b-4*a*c;
        xE = -b/(2*a);
        yE= -d/(2*a);


        TextView aV = findViewById(R.id.aV);
        TextView bV = findViewById(R.id.bV);
        TextView cV = findViewById(R.id.cV);
        TextView dV = findViewById(R.id.deltaV);

        TextView valeurDeXV = findViewById(R.id.ValeurDeX);
        TextView y0V = findViewById(R.id.Y0);
        TextView y1V = findViewById(R.id.Y1);
        ImageView variation = findViewById(R.id.variation);


        aV.setText(String.format ("% .3g",(a)));
        bV.setText(String.format ("% .3g",(b)));
        cV.setText(String.format ("% .3g",(c)));
        dV.setText(String.format ("% .3g",(d)));

        valeurDeXV.setText(String.format ("% .3g",(xE)));

        if (a < 0) {

            variation.setImageResource(R.drawable.anegatif);

            y0V.setText(String.format ("% .3g",(yE)));

        } else {
            variation.setImageResource(R.drawable.apositif);
            y1V.setText(String.format ("% .3g",(yE)));

        }





        ImageView retour;
        retour=findViewById(R.id.retour);

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}