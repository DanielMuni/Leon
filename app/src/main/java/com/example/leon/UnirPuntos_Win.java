package com.example.leon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class UnirPuntos_Win extends AppCompatActivity {
    //Se declara la variable
    TextView scoreTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unir_puntos_win);

        scoreTxt = findViewById(R.id.upWinScore); //Se le asigna el nombre de la variable al TextView correspondiente

        //Se muestra el resultado de showScore de la clase que le pertence a la pantalla  anterior
        scoreTxt.setText("Puntaje: " + UnirPuntos_Nivel4.getInstance().showScore());
    }

    /*Se declara la funcion nextLevel, la cual se encarga de cambiar la pantalla actual por la
     * pantalla de la clase MenuPrincipal*/
    public void nextLevel(View v) {
        Intent intent = new Intent(this, MenuPrincipal.class);
        startActivity(intent);
    }
}
