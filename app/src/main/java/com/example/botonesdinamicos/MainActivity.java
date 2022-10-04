package com.example.botonesdinamicos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {

    Button bCrear;
    EditText nBotones;
    LinearLayout lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bCrear = findViewById(R.id.buttonCrear);
        nBotones = findViewById(R.id.editTextNbotones);
        lista = findViewById(R.id.listaNumeros);

        bCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cantidad = Integer.parseInt(nBotones.getText().toString());

                for (int i = 0; i < cantidad; i++){
                    Button botonaux = new Button(MainActivity.this);
                    botonaux.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                    botonaux.setText("Boton " + i);

                    lista.addView(botonaux);
                }

            }
        });


    }
}