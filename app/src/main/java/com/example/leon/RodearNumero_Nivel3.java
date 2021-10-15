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

public class RodearNumero_Nivel3 extends AppCompatActivity {

    private static RodearNumero_Nivel3 instance;
    RodearNumeroJuego game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rodear_numero_nivel3);

        game = new RodearNumeroJuego();
    }

    public RodearNumero_Nivel3() {
        instance = this;
    }

    public static RodearNumero_Nivel3 getInstance() {
        return instance;
    }

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

    public void nextLevel() {
        Intent intent = new Intent(this, RodearNumero_Win.class);
        startActivity(intent);
    }

    public String showScore() {
        return(Integer.toString(game.getScore()));
    }
}
