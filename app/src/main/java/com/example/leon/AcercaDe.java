package com.example.leon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AcercaDe extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);


    }

    /* Funcion que permite al boton regresar al menu principal*/
    public void openMenuPrincipal(View v) {
        Intent intent = new Intent(this, MenuPrincipal.class);
        startActivity(intent);
    }
}