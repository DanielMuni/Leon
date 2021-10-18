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

    /* Funcion que permite al boton regresar al menu principal*/
	public void MenuPrincipal(View view){
		Intent siguienteNivel = new Intent(this, MenuPrincipal.class);
		startActivity(siguienteNivel);
	}
}
