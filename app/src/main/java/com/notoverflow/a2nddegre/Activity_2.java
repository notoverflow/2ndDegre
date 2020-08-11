package com.notoverflow.a2nddegre;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity_2 extends AppCompatActivity {

    @SuppressLint({"DefaultLocale", "SetTextI18n"})
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
    }
}