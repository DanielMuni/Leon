package com.example.leon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class juego_finalizado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_finalizado);
    }

	// Funcion Silueta Correcta
	public void MenuPrincipal(View view){
		Intent siguienteNivel = new Intent(this, MainActivity.class);
		startActivity(siguienteNivel);
	}
}
