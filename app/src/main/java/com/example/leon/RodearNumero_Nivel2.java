package com.example.leon;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RodearNumero_Nivel2 extends AppCompatActivity {

    private static RodearNumero_Nivel2 instance; //Se declara la instancia de la clase
    
    //Se declaran las variables
    RodearNumeroJuego game; //Variable con la que se va a llamar a la clase RodearNumeroJuego
    boolean actState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rodear_numero_nivel2);

        game = new RodearNumeroJuego(); //Variable con la que se va a llamar a la clase RodearNumeroJuego
    }

    /*Se declara la funcion openMenuPrincipal, la cual se encarga de cambiar la pantalla actual por la
     * pantalla de la clase MenuPrincipal*/
    public void openMenuPrincipal(View v) {
        Intent intent = new Intent(this, MenuPrincipal.class);
        startActivity(intent);
    }

    //Se declaran las funciones RodeaNumero_Nivel2 y getInstance para llamar a la clase en otros archivos
    public RodearNumero_Nivel2() {
        instance = this;
    }

    public static RodearNumero_Nivel2 getInstance() {
        return instance;
    }

    /*Se declara la funcion flashAndPlay, la cual recibe un entero y un boton y se encarga de hacer
     * la animacion de cambiar y regresar el color a un boton cuando es presionado */
    private void flashAndPlay(int delay, Button btn) {
        ObjectAnimator animator;
        animator = ObjectAnimator.ofObject(btn,
                "backgroundColor",
                new ArgbEvaluator(),
                ((ColorDrawable)btn.getBackground()).getColor(),
                0xFFFFFFFF);

        animator.setDuration(150);
        animator.setRepeatCount(1);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.setStartDelay(delay);
        animator.start();
    }

    /*Se declara la funcion onTap, con ayuda de la funcion correctButton, de la clase RodearNumeroJuego,
     * manda a llamar a la funcion flashAndPlay si el boton es incorrecto y si es correcto lo
     * cambia de color, le cambia el contenido de la descripcion para ya no poder elegirlo de nuevo
     * y manda a llamar a la funcion allNumbers de la clase RodearNumeroJuego.*/
    public void onTap(View v) {
        Button tapped = (Button)v;

        if (tapped.getContentDescription() == null) {
            if (game.correctButton(tapped)) {
                tapped.setBackgroundColor(Color.WHITE);
                tapped.setTextColor(Color.argb(100, 187, 134, 252));
                tapped.setContentDescription("F");

                game.allNumbers(3, 1);
             } else {
                flashAndPlay(0, tapped);
             }
        }
    }

    /*Se declara la funcion nextLevel, la cual se encarga de cambiar la pantalla actual por la
     * pantalla de la clase RodearNumero_NextLevel*/
    public void nextLevel() {
        Intent intent = new Intent(this, RodearNumero_NextLevel.class);
        startActivity(intent);
    }

    /*Se declara la funcion setState, recibe una variable de tipo booleano. Se le asigna el valor de
     * la variable recibida a la variable actState.*/
    public void setState(boolean state) {
        actState = state;
    }

    /*Se declara la funcion getState, la cual regresa el valor de la variable actState*/
    public boolean getState() {
        return actState;
    }

    /*Se declara la funcion showScore, regresa el valor obtenido por la funcion getScore, de la clase
     * RodearNumeroJuego, como string*/
    public String showScore() {
        return(Integer.toString(game.getScore()));
    }
}
