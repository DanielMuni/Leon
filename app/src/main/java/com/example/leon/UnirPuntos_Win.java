package com.example.leon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class UnirPuntos_Win extends AppCompatActivity {
    TextView scoreTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unir_puntos_win);

        scoreTxt = findViewById(R.id.upWinScore);

        scoreTxt.setText("Puntaje: " + UnirPuntos_Nivel4.getInstance().showScore());
    }

    public void nextLevel(View v) {
        Intent intent = new Intent(this, MenuPrincipal.class);
        startActivity(intent);
    }
}