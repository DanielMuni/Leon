package com.example.leon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class tercer_nivel extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tercer_nivel);
	}

	// Funcion Silueta Correcta
	public void SiluetaCorrecta(View view){
		Toast.makeText(this, "¡Excelente, encontraste al Elefante!", Toast.LENGTH_LONG).show();
		Intent siguienteNivel = new Intent(this, cuarto_nivel.class);
		startActivity(siguienteNivel);
	}
}
