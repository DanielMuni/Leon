package com.example.leon;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class MenuPrincipal extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //Obtener la cantidad de RAM disponible en el dispositivo
        ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);;
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        float GiB = 1073741824; //Cantidad de bytes en un GiB
        float RAM = (float) memoryInfo.totalMem / GiB;

        if (RAM > 2)
            setContentView(R.layout.activity_menu_principal);
        else
            setContentView(R.layout.activity_menu_principal_low_specs);
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
        Intent intent = new Intent(this, MainActivity_ef.class);
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