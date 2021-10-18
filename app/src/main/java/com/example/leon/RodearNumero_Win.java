package com.example.leon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RodearNumero_Win extends AppCompatActivity {
    //Se declara la variable
    TextView scoreTxt;

    DataBase usuarios = MainActivity.usuarios;
    Usuario  usuarioActual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rodear_numero_win);


        scoreTxt = findViewById(R.id.winScore); //Se le asigna el nombre de la variable al TextView correspondiente
        usuarioActual = usuarios.findUsuarioSeleccionado(); //Se obtiene la sesion actual

        //Se muestra el resultado de showScore de la clase que le pertence a la pantalla  anterior
        scoreTxt.setText("Puntaje: " + RodearNumero_Nivel3.getInstance().showScore());
        usuarioActual.aumentarPuntacion(Integer.parseInt(RodearNumero_Nivel3.getInstance().showScore()));
        //Guardar la puntuacion del usuario en la base de datos
        usuarios.actualizarPuntos(usuarioActual);
    }

    /*Se declara la funcion openMenuPrincipal, la cual se encarga de cambiar la pantalla actual por la
     * pantalla de la clase MenuPrincipal*/
    public void openMenuPrincipal(View v) {
        Intent intent = new Intent(this, MenuPrincipal.class);
        startActivity(intent);
    }
}
