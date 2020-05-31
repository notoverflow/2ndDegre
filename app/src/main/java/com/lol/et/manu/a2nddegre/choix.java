package com.lol.et.manu.a2nddegre;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class choix extends AppCompatActivity {

    private EditText aV,bV,cV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix);

        

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
}