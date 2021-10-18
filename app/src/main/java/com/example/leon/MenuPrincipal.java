package com.example.leon;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


public class MenuPrincipal extends AppCompatActivity {
    DataBase usuarios = MainActivity.usuarios;
    Usuario usuarioActual;

    ImageButton perfil;
    TextView nombreYPuntos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //Obtener la cantidad de RAM disponible en el dispositivo
        ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        float GiB = 1073741824; //Cantidad de bytes en un GiB
        float RAM = (float) memoryInfo.totalMem / GiB;

        if (RAM > 2)
            setContentView(R.layout.activity_menu_principal);
        else
            setContentView(R.layout.activity_menu_principal_low_specs);
        //textView_MostarPerfil;
        nombreYPuntos = findViewById(R.id.textView_MostarPerfil);
        perfil = findViewById(R.id.perfil);
        usuarioActual = null;
    }

    @Override
    protected void onStart() {
        super.onStart();
        usuarioActual = usuarios.findUsuarioSeleccionado();
        String imagenDePerfil = usuarioActual.getImagenSrc();
        System.out.println(imagenDePerfil);

        switch (imagenDePerfil){
            case "perfil_1":
                perfil.setImageResource(R.drawable.perfil_1);
                break;
            case "perfil_2":
                perfil.setImageResource(R.drawable.perfil_2);
                break;
            case "perfil_3":
                perfil.setImageResource(R.drawable.perfil_3);
                break;
            case "perfil_4":
                perfil.setImageResource(R.drawable.perfil_4);
                break;
            default:
                perfil.setImageResource(R.drawable.perfil_0);
                break;
        }

        String datos = usuarioActual.getNombre();
        nombreYPuntos.setText(datos);
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