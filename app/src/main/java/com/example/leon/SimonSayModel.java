package com.example.leon;

import android.widget.TextView;

import java.util.Random;

public class SimonSayModel {

    private int[] array = new int[50]; //model?
    private int count = 0; //model?
    private boolean userTurn = false; //model?
    private int moves = 0; //model?

    public void inicializar(TextView marcador){
        moves = 0;
        count = 0;
        marcador.setText("Record: 0");
    }

    private void playAll(){
        for (int i = 0; i < moves; i++){
            SimonDice.getInstance().flashAndPlaySound((i+1) * 600, array[i]);
        }
    }
    public void getNext(){
        userTurn = false;
        Random r = new Random();
        int next = r.nextInt(3-0);
        array[moves] = next;
        moves++;
        playAll();
        userTurn = true;
    }

    public boolean turnoDelJugador(){
        return userTurn && count < moves;
    }

    public void evaluarJugada(int number, TextView marcador){
        if (number != array[count]){
            marcador.setText("PERDISTE");
            userTurn = false;
        }
        else{
            count++;
            marcador.setText("Record: " + count);
            if(count == moves){
                count = 0;
                getNext();
            }
        }
    }
}
