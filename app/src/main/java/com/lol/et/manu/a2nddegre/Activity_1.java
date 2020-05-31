package com.lol.et.manu.a2nddegre;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity_1 extends AppCompatActivity {

    private TextView aV,bV,cV,dV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        float a,c,b,d;
//récupération des donner
        Intent temp;
        temp = getIntent();
        a = temp.getFloatExtra("coef_A",0);
        b = temp.getFloatExtra("coef_B",0);
        c = temp.getFloatExtra("coef_C",0);
//fin des récupération des donner
        d= b*b-4*a*c;


        ImageView retour;

        aV=findViewById(R.id.valeurA);
        bV=findViewById(R.id.valeurB);
        cV=findViewById(R.id.valeurC);
        dV=findViewById(R.id.delta);
//affichages des rsultat
        aV.setText(String.format ("% .3g",(a)));
        bV.setText(String.format ("% .3g",(b)));
        cV.setText(String.format ("% .3g",(c)));
        dV.setText(String.format ("% .3g",(d)));


        retour=findViewById(R.id.retour);

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}