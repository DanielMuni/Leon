package com.example.leon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class cuarto_nivel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuarto_nivel);
    }

	// Funcion Silueta Correcta
	public void SiluetaCorrecta4(View view){
		Toast.makeText(this, "¡Perfecto, encontraste al Gallo!", Toast.LENGTH_LONG).show();
		Intent siguienteNivel = new Intent(this, juego_finalizado.class);
		startActivity(siguienteNivel);
	}

	public void openMenuPrincipal(View v) {
		Intent intent = new Intent(this, MenuPrincipal.class);
		startActivity(intent);
	}
}
