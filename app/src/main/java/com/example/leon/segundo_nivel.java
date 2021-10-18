package com.example.leon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class segundo_nivel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo_nivel);
    }

	// Funcion Silueta Correcta
	public void SiluetaCorrectaNvl2(View view){
		Toast.makeText(this, "¡Muy bien, encontraste al León!", Toast.LENGTH_LONG).show();
		Intent nivelTres = new Intent(this, tercer_nivel.class);
		startActivity(nivelTres);
	}

	/* Funcion que permite al boton regresar al menu principal*/
	public void openMenuPrincipal(View v) {
		Intent intent = new Intent(this, MenuPrincipal.class);
		startActivity(intent);
	}
}
