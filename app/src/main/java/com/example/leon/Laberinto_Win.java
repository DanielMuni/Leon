package com.example.leon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Laberinto_Win extends AppCompatActivity {
    //Se declara la variable
    TextView scoreTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laberinto_win);


        scoreTxt = findViewById(R.id.winScore); //Se le asigna el nombre de la variable al TextView correspondiente
        scoreTxt.setText("Puntaje: 100");
    }

    /*Se declara la funcion openMenuPrincipal, la cual se encarga de cambiar la pantalla actual por la
     * pantalla de la clase MenuPrincipal*/
    public void openMenuPrincipal(View v) {
        finish();
    }
}
