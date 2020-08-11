package com.notoverflow.a2nddegre;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity_3 extends AppCompatActivity {

    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        float a;
        float c;
        float b;
        float d;
        double X1;
        double X2;

        Intent temp;
        temp = getIntent();
        a = temp.getFloatExtra("coef_A",0);
        b = temp.getFloatExtra("coef_B",0);
        c = temp.getFloatExtra("coef_C",0);

        d= b*b-4*a*c;
        X1=(-b-Math.sqrt(d))/(2*a);
        X2=(-b+Math.sqrt(d))/(2*a);


        TextView aV = findViewById(R.id.aV);
        TextView bV = findViewById(R.id.bV);
        TextView cV = findViewById(R.id.cV);
        TextView dV = findViewById(R.id.deltaV);
        TextView resultat = findViewById(R.id.resultat);

        if (d>0)
        {
            if (X1>=0 && X2>=0)
            {
                resultat.setText (String.format ("% .3g ( x - % .3g )( x - % .3g )",a,X1,X2));
            }
            if (X1<0 && X2<0)
            {
                resultat.setText (String.format ("% .3g ( x + % .3g )( x + % .3g )",a,-X1,-X2));
            }
            if (X1<0 && X2>0)
            {
                resultat.setText (String.format ("% .3g ( x + % .3g )( x - % .3g )",a,-X1,X2));
            }
            if (X1>0 && X2<0)
            {
                resultat.setText (String.format ("% .3g ( x - % .3g )( x + % .3g )",a,X1,-X2));
            }

        }
        if (d==0){
            if (X1 > 0) {
                resultat.setText (String.format ("% .3g ( x - % .3g )²",a,X1));
            }
            else resultat.setText  (String.format ("% .3g ( x + % .3g )²",a,-X1));
        }

        if (d<0)
        { resultat.setText("Le delta étant négatif, il n'y a pas de solution");
        }







        aV.setText(String.format ("% .3g",(a)));
        bV.setText(String.format ("% .3g",(b)));
        cV.setText(String.format ("% .3g",(c)));
        dV.setText(String.format ("% .3g",(d)));


        ImageView retour = findViewById(R.id.retour);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}