package com.example.leon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class UnirPuntos_NextLevel extends AppCompatActivity {
    //Se declaran las variables
    TextView scoreTxt;
    int actNivel;

    DataBase usuarios = MainActivity.usuarios;
    Usuario  usuarioActual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unir_puntos_next_level);

        scoreTxt = findViewById(R.id.upNextLevelScore); //Se le asigna el nombre de la variable al TextView correspondiente

        usuarioActual = usuarios.findUsuarioSeleccionado(); //Se obtiene la sesion actual

        /*Dependiendo del resultado de la funcion getState de la pantalla anterior a esta, se le
         * asigna un valor a la variable actNivel y se manda a llamar a la funcion showScore, de la
         * clase pertenecionte a la pantalla anterior, y se muestra el resultado en el TextView*/
        if(UnirPuntos_Nivel1.getInstance().getState()) {
            actNivel = 1;
            scoreTxt.setText("Puntaje: " + UnirPuntos_Nivel1.getInstance().showScore());
            usuarioActual.aumentarPuntacion(Integer.parseInt(UnirPuntos_Nivel1.getInstance().showScore()));
        }else if (UnirPuntos_Nivel2.getInstance().getState()) {
            actNivel = 2;
            scoreTxt.setText("Puntaje: " + UnirPuntos_Nivel2.getInstance().showScore());
            usuarioActual.aumentarPuntacion(Integer.parseInt(UnirPuntos_Nivel2.getInstance().showScore()));
        }else if (UnirPuntos_Nivel3.getInstance().getState()) {
            actNivel = 3;
            scoreTxt.setText("Puntaje: " + UnirPuntos_Nivel3.getInstance().showScore());
            usuarioActual.aumentarPuntacion(Integer.parseInt(UnirPuntos_Nivel3.getInstance().showScore()));
        }

        //Guardar la puntuacion del usuario en la base de datos
        usuarios.actualizarPuntos(usuarioActual);
    }

    /*Se declara la funcion nextLevel se encarga de cambiar la pantalla actual por la pantalla
     * de la clase UnirPuntos_Nivel2, UnirPuntos_Nivel3 o UnirPuntos_Nivel4, dependiendo cual sea
     * el valor de la variable actNivel*/
    public void nextLevel(View v) {
        if(actNivel == 1) {
            Intent intent = new Intent(this, UnirPuntos_Nivel2.class);
            startActivity(intent);
        } else if (actNivel == 2) {
            Intent intent = new Intent(this, UnirPuntos_Nivel3.class);
            startActivity(intent);
        } else if (actNivel == 3) {
            Intent intent = new Intent(this, UnirPuntos_Nivel4.class);
            startActivity(intent);
        }
        finish();
    }
}
