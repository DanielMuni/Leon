package com.example.leon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RodearNumero_NextLevel extends AppCompatActivity {
    TextView scoreTxt;
    int actNivel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rodear_numero_next_level);

        scoreTxt = findViewById(R.id.nextLevelScore);

        if(RodearNumero_Nivel1.getInstance().getState()) {
            actNivel = 1;
            scoreTxt.setText("Puntaje: " + RodearNumero_Nivel1.getInstance().showScore());
        }else if (RodearNumero_Nivel2.getInstance().getState()) {
            actNivel = 2;
            scoreTxt.setText("Puntaje: " + RodearNumero_Nivel2.getInstance().showScore());
        }

    }

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