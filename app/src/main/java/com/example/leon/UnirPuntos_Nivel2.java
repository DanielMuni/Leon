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

public class UnirPuntos_Nivel2 extends AppCompatActivity {
    ImageButton btn1;
    ImageButton btn2;
    ImageButton btn3;
    ImageButton btn4;
    ImageButton btn5;

    private static UnirPuntos_Nivel2 instance;
    UnirPuntosJuego game;
    ImageButton actBtn;
    boolean stateLine1;
    boolean stateLine2 = true;
    boolean actState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unir_puntos_nivel2);

        game = new UnirPuntosJuego();

        btn1 = findViewById(R.id.upNivel2_btn);
        btn2 = findViewById(R.id.upNivel2_btn2);
        btn3 = findViewById(R.id.upNivel2_btn3);
        btn4 = findViewById(R.id.upNivel2_btn4);
        btn5 = findViewById(R.id.upNivel2_btn5);
    }

    public void openMenuPrincipal(View v) {
        Intent intent = new Intent(this, MenuPrincipal.class);
        startActivity(intent);
    }

    public UnirPuntos_Nivel2() {
        instance = this;
    }

    public static UnirPuntos_Nivel2 getInstance() {
        return instance;
    }

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
            else if (actBtn == btn5)
                actBtn.setBackgroundColor(Color.rgb(233,176,242));

            stateLine1 = true;
            stateLine2 = false;
        }
    }

    public void onTapLine2(View v) {
        ImageButton tapped = (ImageButton)v;

        if (!stateLine2) {
            if (game.correctPair(actBtn, tapped)) {
                tapped.setBackgroundColor(((ColorDrawable)actBtn.getBackground()).getColor());

                game.allPairs(5, 2);
            } else {
                flashAndPlay(0, actBtn,tapped);
                actBtn.setBackgroundColor(Color.TRANSPARENT);
            }
            stateLine1 = false;
            stateLine2 = true;
        }
    }

    public void next () {
        Intent intent = new Intent(this, UnirPuntos_NextLevel.class);
        startActivity(intent);
    }

    public void setState(boolean state) {
        actState = state;
    }

    public boolean getState() {
        return actState;
    }

    public String showScore() {
        return(Integer.toString(game.getScore()));
    }
}