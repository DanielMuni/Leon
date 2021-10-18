package com.example.leon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity_ef extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ef);
    }

	// Funcion Silueta Correcta
	public void SiluetaCorrecta(View view){
		Toast.makeText(this, "¡Bien, encontraste el Círculo Azul!", Toast.LENGTH_LONG).show();
		Intent siguienteNivel = new Intent(this, segundo_nivel_ef.class);
		startActivity(siguienteNivel);
	}

	/* Funcion que permite al boton regresar al menu principal*/
	public void openMenuPrincipal(View v) {
		Intent intent = new Intent(this, MenuPrincipal.class);
		startActivity(intent);
	}
}
