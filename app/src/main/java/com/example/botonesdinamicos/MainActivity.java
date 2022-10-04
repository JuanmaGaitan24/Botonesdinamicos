package com.example.botonesdinamicos;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button bCrear, bBorrar, bBorrarPares;
    EditText nBotones;
    LinearLayout lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bCrear = findViewById(R.id.buttonCrear);
        bBorrar = findViewById(R.id.buttonBorrar);
        bBorrarPares = findViewById(R.id.buttonBorrarPares);
        nBotones = findViewById(R.id.editTextNbotones);
        lista = findViewById(R.id.listaNumeros);

        bCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cantidad = Integer.parseInt(nBotones.getText().toString());

                for (int i = 0; i < cantidad; i++) {

                    Button botonaux = new Button(MainActivity.this);
                    botonaux.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                    botonaux.setText("Boton " + i);
                    botonaux.setBackgroundColor(Color.rgb(dameColor(), dameColor(), dameColor()));
                    final int numero = i;



                    botonaux.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast t = Toast.makeText(getApplicationContext(), "Soy el boton: "+numero, Toast.LENGTH_SHORT);
                            t.show();
                            view.setBackgroundColor(Color.rgb(dameColor(), dameColor(), dameColor()));
                        }
                    });

                    lista.addView(botonaux);

                }

            }
        });

        bBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lista.removeAllViews();
            }
        });

        bBorrarPares.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ArrayList<View> Arraybotones = lista.getTouchables();
                Iterator<View> it = Arraybotones.iterator();

                while (it.hasNext()){

                    View v = it.next();

                    if (v instanceof Button){
                        String[] cadena = ((Button) v).getText().toString().split(" ");
                        int numero = Integer.parseInt(cadena[1]);

                        if (numero % 2 == 0){
                            lista.removeView(v);
                        }

                    }

                }

            }
        });

    }

    private int dameColor() {

        final int max = 255;
        final int min = 0;
        int random = new Random().nextInt((max - min) + 1) + min;

        return random;
    }
}