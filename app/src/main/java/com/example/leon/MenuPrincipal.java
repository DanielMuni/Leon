package com.example.leon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class MenuPrincipal extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);



    }


    public void openAcercaDe(View v) {
        Intent intent = new Intent(this, AcercaDe.class);
        startActivity(intent);
    }

    public void openColorearParejas(View v) {
        Intent intent = new Intent(this, Memorama.class);

        startActivity(intent);
    }

    public void openImagenesRepetidas(View v) {
        Intent intent = new Intent(this, RodearFiguraRepetida.class);

        startActivity(intent);
    }

    public void openUnirPuntos(View v) {
        Intent intent = new Intent(this, UnirPuntos_Nivel1.class);
        startActivity(intent);
    }

    public void openRodearNumero(View v) {
        Intent intent = new Intent(this, RodearNumero_Nivel1.class);
        startActivity(intent);
    }

    public void openInicio(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openLaberinto(View v) {
        Intent intent = new Intent(this, Laberinto.class);
        startActivity(intent);
    }

    public void openSimonDice(View v) {
        Intent intent = new Intent(this, SimonDice.class);
        startActivity(intent);
    }

    public void openEncontrarSilueta(View v) {
        Intent intent = new Intent(this, primer_nivel.class);
        startActivity(intent);
    }

}