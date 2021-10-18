package com.example.leon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RodearNumero_NextLevel extends AppCompatActivity {
    //Se declaran las variables
    TextView scoreTxt;
    int actNivel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rodear_numero_next_level);

        scoreTxt = findViewById(R.id.nextLevelScore); //Se le asigna el nombre de la variable al TextView correspondiente

        /*Dependiendo del resultado de la funcion getState de la pantalla anterior a esta, se le
        * asigna un valor a la variable actNivel y se manda a llamar a la funcion showScore, de la
        * clase pertenecionte a la pantalla anterior, y se muestra el resultado en el TextView*/
        if(RodearNumero_Nivel1.getInstance().getState()) {
            actNivel = 1;
            scoreTxt.setText("Puntaje: " + RodearNumero_Nivel1.getInstance().showScore());
        }else if (RodearNumero_Nivel2.getInstance().getState()) {
            actNivel = 2;
            scoreTxt.setText("Puntaje: " + RodearNumero_Nivel2.getInstance().showScore());
        }

    }

    /*Se declara la funcion nextLevel se encarga de cambiar la pantalla actual por la pantalla
    * de la clase RodearNumero_Nivel2 o RodearNumero_Nivel3, dependiendo cual sea el valor de la
    * variable actNivel*/
   public void nextLevel(View v) {
        if(actNivel == 1) {
            Intent intent = new Intent(this, RodearNumero_Nivel2.class);
            startActivity(intent);
        }else if (actNivel == 2) {
            Intent intent = new Intent(this, RodearNumero_Nivel3.class);
            startActivity(intent);
        }
    }
}
