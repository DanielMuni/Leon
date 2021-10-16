package com.example.leon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class segundo_nivel_ef extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo_nivel_ef);
    }

	// Funcion Silueta Correcta
	public void SiluetaCorrecta(View view){
		Toast.makeText(this, "¡Muy bien, encontraste el Cuadrado Verde!", Toast.LENGTH_LONG).show();
		Intent siguienteNivel = new Intent(this, tercer_nivel_ef.class);
		startActivity(siguienteNivel);
	}

	public void openMenuPrincipal(View v) {
		Intent intent = new Intent(this, MenuPrincipal.class);
		startActivity(intent);
	}
}
