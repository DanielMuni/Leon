package com.example.leon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Laberinto extends AppCompatActivity {

    LaberintoModel laberinto = new LaberintoModel();
    String laberintoASCII;
    TableLayout laberintoDisplay;
    TextView felicitaciones;
    boolean [] controles;  //0 = arriba, 1 = derecha, 2 = abajo, 3 = izquierda

    DataBase usuarios = MainActivity.usuarios;
    Usuario  usuarioActual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laberinto);

        laberintoDisplay = (TableLayout) findViewById(R.id.laberintoDisplay);
        felicitaciones = (TextView) findViewById(R.id.felicitaciones);
        usuarioActual = usuarios.findUsuarioSeleccionado();
    }
    public void openMenuPrincipal(View v) {
        Intent intent = new Intent(this, MenuPrincipal.class);
        startActivity(intent);
        finish();
    }

    //Muestra el laberinto
    private void display(){
        //Reseteamos el mapa
        laberintoDisplay.removeAllViews();
        //Obtenemos el mapa en bruto del modelo
        laberintoASCII = laberinto.getLaberinto();


        TableRow filaActual = new TableRow(this);
        TableRow.LayoutParams parametrosFila = new TableRow.LayoutParams(
                TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT,
                1);
        parametrosFila.setMargins(0,0,0,0);
        filaActual.setLayoutParams(parametrosFila);
        filaActual.setGravity(Gravity.CENTER);

        for (int i = 0; i < laberintoASCII.length(); i++){

            char charActual = laberintoASCII.charAt(i);
            if (charActual == '\n'){
                laberintoDisplay.addView(filaActual);

                filaActual = new TableRow(this);
                filaActual.setLayoutParams(parametrosFila);
            }
            else {
                ImageView celdaActual = new ImageView(this);
                TableRow.LayoutParams parametrosCelda = new TableRow.LayoutParams(35, 35,1);
                parametrosCelda.setMargins(0,0,0,0);
                celdaActual.setLayoutParams(parametrosCelda);

                switch (charActual){
                    case ' ':
                        celdaActual.setImageResource(R.drawable.camino);
                        break;
                    case '*':
                        celdaActual.setImageResource(R.drawable.jugador);
                        break;
                    case 'x':
                        celdaActual.setImageResource(R.drawable.meta);
                        break;
                    //(charActual == '+' || charActual == '-' || charActual == '|')
                    default:
                        celdaActual.setImageResource(R.drawable.arbusto);
                }

                filaActual.addView(celdaActual);
            }
        }
    }

    //Actualiza el laberinto
    private  void refresh(){
        controles = laberinto.getControles();
        if (!laberinto.checkPosicion()){
            display();
        }
        else {
            for (int i = 0; i < 4; i++)
                controles[i] = false;

            felicitaciones.setText("FELICIDADES!!!");
            felicitaciones.setTypeface(Typeface.MONOSPACE);

            usuarioActual.aumentarPuntacion(100);
            //Guardar la puntuacion del usuario en la base de datos
            usuarios.actualizarPuntos(usuarioActual);

            Intent intent = new Intent(this, MenuPrincipal.class);
            startActivity(intent);
            finish();
        }
    }

    //Desplega el laberinto al inicializar el juego
    @Override
    protected void onStart() {
        super.onStart();
        refresh();
    }

    //Las siguientes funciones reciben las respuestas de los controles
    public void arriba(View v){
        if (controles[0]) {
            laberinto.arriba();
            refresh();
        }
    }

    public void derecha(View v){
        if (controles[1]) {
            laberinto.derecha();
            refresh();
        }
    }

    public void abajo(View v){
        if (controles[2]) {
            laberinto.abajo();
            refresh();
        }
    }

    public void izquierda(View v){
        if (controles[3]) {
            laberinto.izquierda();
            refresh();
        }
    }
}