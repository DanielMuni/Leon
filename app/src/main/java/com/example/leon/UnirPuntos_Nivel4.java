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
import android.widget.ImageButton;

public class UnirPuntos_Nivel4 extends AppCompatActivity {
    //Se declaran las variables
    ImageButton btn1;
    ImageButton btn2;
    ImageButton btn3;
    ImageButton btn4;

    private static UnirPuntos_Nivel4 instance; //Se declara la instancia de la clase
    UnirPuntosJuego game; //Variable con la que se va a llamar a la clase UnirPuntosJuego
    ImageButton actBtn;
    boolean stateLine1;
    boolean stateLine2 = true;
    boolean actState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unir_puntos_nivel4);

        game = new UnirPuntosJuego(); //Variable con la que se va a llamar a la clase UnirPuntosJuego

        //Se le asignan los nombres de las variables a los botones correspondientes
        btn1 = findViewById(R.id.upNivel4_btn);
        btn2 = findViewById(R.id.upNivel4_btn2);
        btn3 = findViewById(R.id.upNivel4_btn3);
        btn4 = findViewById(R.id.upNivel4_btn4);
    }

    /*Se declara la funcion openMenuPrincipal que cambia la pantalla actual por la pantalla de la clase
     * MenuPrincipal*/
    public void openMenuPrincipal(View v) {
        Intent intent = new Intent(this, MenuPrincipal.class);
        startActivity(intent);
    }

    //Se declaran las funciones UnirPuntos_Nivel4 y getInstance para llamar a la clase en otros archivos
    public UnirPuntos_Nivel4() {
        instance = this;
    }

    public static UnirPuntos_Nivel4 getInstance() {
        return instance;
    }

    /*Se declara la funcion flashAndPlay un entero y dos ImageButton. Se encarga de hacer la animacion
     * de cambiar de color, a color de actBtn, y lo regresa a su color original cuando el boton
     * btn es presionado.*/
    private void flashAndPlay(int delay, ImageButton actBtn,ImageButton btn) {
        ObjectAnimator animator;
        animator = ObjectAnimator.ofObject(btn,
                "backgroundColor",
                new ArgbEvaluator(),
                ((ColorDrawable)btn.getBackground()).getColor(),
                ((ColorDrawable)actBtn.getBackground()).getColor());

        animator.setDuration(120);
        animator.setRepeatCount(1);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.setStartDelay(delay);
        animator.start();
    }

    /*Se declara la funcion onTapLine1 que, si ningun boton de la linea 1 esta presionado, se encarga
     * de asignar que la variable actBtn es el boton presionado y cambiar los botones a un color en
     * especifico segun el boton que sea presionado. Marca la variable stateLine1 como true y la
     * variable stateLine2 como false.*/
    public void onTapLine1(View v) {

        if (!stateLine1) {
            actBtn = (ImageButton)v;
            if (actBtn == btn1)
                actBtn.setBackgroundColor(Color.rgb(255,182,174));
            else if (actBtn == btn2)
                actBtn.setBackgroundColor(Color.rgb(252,169,133));
            else if (actBtn == btn3)
                actBtn.setBackgroundColor(Color.rgb(176,242,194));
            else if (actBtn == btn4)
                actBtn.setBackgroundColor(Color.rgb(176,194,242));

            stateLine1 = true;
            stateLine2 = false;
        }
    }

    /*Se declara la funcion onTapLine2 que, si ningun boton de la linea 2 esta presionado, manda a
     * llamar a la funcion correctPair de la clase UnirPuntosJuego, si es verdadero le cambia el color
     * al boton presionado por el color actual de actBtn y se manda a llamar a la funcion allPairs
     * de la clase UnirPuntosJuego, si es falso manda a llamar a la funcion flashAndPlay y vuelve a
     * actBtn transparente. Marca la variable stateLine2 como true y la variable stateLine1 como false.*/
    public void onTapLine2(View v) {
        ImageButton tapped = (ImageButton)v;

        if (!stateLine2) {
            if (game.correctPair(actBtn, tapped)) {
                tapped.setBackgroundColor(((ColorDrawable)actBtn.getBackground()).getColor());

                game.allPairs(4, 4);
            } else {
                flashAndPlay(0, actBtn,tapped);
                actBtn.setBackgroundColor(Color.TRANSPARENT);
            }
            stateLine1 = false;
            stateLine2 = true;
        }
    }

    /*Se declara la funcion next que cambia la pantalla actual por la pantalla de la clase
     * UnirPuntos_NextLevel*/
    public void next () {
        Intent intent = new Intent(this, UnirPuntos_Win.class);
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
     * UnirPuntosJuego, como string*/
    public String showScore() {
        return(Integer.toString(game.getScore()));
    }
}
