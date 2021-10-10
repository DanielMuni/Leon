package com.example.leon;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SimonDice extends AppCompatActivity {

    private static SimonDice instance;
    private MediaPlayer playerRed;
    private MediaPlayer playerBlue;
    private MediaPlayer playerYellow;
    private MediaPlayer playerGreen;

    Button red;
    Button blue;
    Button yellow;
    Button green;

    TextView label;

    SimonSayModel model = new SimonSayModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simon_dice);

        red = (Button) findViewById(R.id.red);
        blue = (Button) findViewById(R.id.blue);
        yellow = (Button) findViewById(R.id.yellow);
        green = (Button) findViewById(R.id.green);

        label = (TextView) findViewById(R.id.score);


        playerRed = MediaPlayer.create(this, R.raw.red);
        playerBlue = MediaPlayer.create(this, R.raw.blue);
        playerYellow = MediaPlayer.create(this, R.raw.yellow);
        playerGreen = MediaPlayer.create(this, R.raw.green);
    }

    public void openMenuPrincipal(View v) {
        Intent intent = new Intent(this, MenuPrincipal.class);
        startActivity(intent);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        playerRed.release();
        playerBlue.release();
        playerYellow.release();
        playerGreen.release();
    }

    public SimonDice(){
        instance = this;
    }

    public static SimonDice getInstance(){
        return instance;
    }

    public void startGame(View v){ //controlador
        model.inicializar(label);
        model.getNext();
    }


    public void handleTap(View v){
        if(model.turnoDelJugador()){
            Button tapped = (Button) v;
            int number = 0;
            if (tapped == red) {
                number = 0;
            }else if (tapped == blue){
                number = 1;
            }else if(tapped == yellow) {
                number = 2;
            }else if (tapped==green){
                number = 3;
            }

            flashAndPlaySound(0, number);
            model.evaluarJugada(number, label);
        }
    }

    public void flashAndPlaySound(int delay, int number){ //controlador
        ObjectAnimator animator;
        final MediaPlayer player;
        Button botonTap;
        switch(number){
            case 0: player = playerRed;
                botonTap = red;
                break;
            case 1: player = playerBlue;
                botonTap = blue;
                break;
            case 2: player = playerYellow;
                botonTap = yellow;
                break;
            default: player = playerGreen;
                botonTap = green;
                break;
        }

        animator = ObjectAnimator.ofObject(botonTap,
                "backgroundColor",
                new ArgbEvaluator(), botonTap.getBackgroundTintList().getDefaultColor(),
                0xFFFFFFFF);

        animator.setDuration(400);
        animator.setRepeatCount(1);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.setStartDelay(delay);
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation){
                super.onAnimationStart(animation);
                player.start();
            }
        });
        animator.start();
    }
}