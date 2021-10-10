package com.example.leon;

import android.widget.ImageButton;

public class UnirPuntosJuego {
    int count = 0;
    int score = 100;

    public boolean correctPair(ImageButton pair1,ImageButton pair2) {
        if (pair1.getContentDescription() == pair2.getContentDescription())
            return true;
        else
            if (score > 10)
                score = score - 1;

            return false;
    }

    public void allPairs(int amount, int level) {
        count ++;

        if (count == amount) {
            switch (level) {
                case 1:
                    UnirPuntos_Nivel1.getInstance().setState(true);
                    UnirPuntos_Nivel1.getInstance().next();
                    break;
                case 2:
                    UnirPuntos_Nivel1.getInstance().setState(false);
                    UnirPuntos_Nivel2.getInstance().setState(true);
                    UnirPuntos_Nivel2.getInstance().next();
                    break;
                case 3:
                    UnirPuntos_Nivel2.getInstance().setState(false);
                    UnirPuntos_Nivel3.getInstance().setState(true);
                    UnirPuntos_Nivel3.getInstance().next();
                    break;
                case 4:
                    UnirPuntos_Nivel3.getInstance().setState(false);
                    UnirPuntos_Nivel4.getInstance().setState(true);
                    UnirPuntos_Nivel4.getInstance().next();
            }
        }
    }

    public int getScore() {
        return score;
    }
}
