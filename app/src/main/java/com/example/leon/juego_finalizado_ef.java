package com.example.leon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class juego_finalizado_ef extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_finalizado_ef);
    }

    /* Funcion que permite al boton regresar al menu principal*/
	public void MenuPrincipal(View view){
		Intent siguienteNivel = new Intent(this, MenuPrincipal.class);
		startActivity(siguienteNivel);
	}
}
