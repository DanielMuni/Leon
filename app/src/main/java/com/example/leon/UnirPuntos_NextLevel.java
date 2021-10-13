package com.example.leon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class UnirPuntos_NextLevel extends AppCompatActivity {
    TextView scoreTxt;
    int actNivel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unir_puntos_next_level);

        scoreTxt = findViewById(R.id.upNextLevelScore);

        if(UnirPuntos_Nivel1.getInstance().getState()) {
            actNivel = 1;
            scoreTxt.setText("Puntaje: " + UnirPuntos_Nivel1.getInstance().showScore());
        }else if (UnirPuntos_Nivel2.getInstance().getState()) {
            actNivel = 2;
            scoreTxt.setText("Puntaje: " + UnirPuntos_Nivel2.getInstance().showScore());
        }else if (UnirPuntos_Nivel3.getInstance().getState()) {
        actNivel = 3;
        scoreTxt.setText("Puntaje: " + UnirPuntos_Nivel3.getInstance().showScore());
         }
    }

    public void nextLevel(View v) {
        if(actNivel == 1) {
            Intent intent = new Intent(this, UnirPuntos_Nivel2.class);
            startActivity(intent);
        } else if (actNivel == 2) {
            Intent intent = new Intent(this, UnirPuntos_Nivel3.class);
            startActivity(intent);
        } else if (actNivel == 3) {
            Intent intent = new Intent(this, UnirPuntos_Nivel4.class);
            startActivity(intent);
        }
        finish();
    }
}