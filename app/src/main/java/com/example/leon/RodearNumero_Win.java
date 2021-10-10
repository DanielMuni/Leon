package com.example.leon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RodearNumero_Win extends AppCompatActivity {
    TextView scoreTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rodear_numero_win);


        scoreTxt = findViewById(R.id.winScore);

        scoreTxt.setText("Puntaje: " + RodearNumero_Nivel3.getInstance().showScore());
    }

    public void openMenuPrincipal(View v) {
        Intent intent = new Intent(this, MenuPrincipal.class);
        startActivity(intent);
    }
}