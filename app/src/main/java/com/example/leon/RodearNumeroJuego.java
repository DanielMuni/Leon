package com.example.leon;

import android.widget.Button;

public class RodearNumeroJuego {

    int count = 0;
    int score = 100;

    public boolean correctButton(Button btn) {
        if (btn.getId() == R.id.nivel1_rightBtn || btn.getId() == R.id.nivel1_rightBtn2 || btn.getId() == R.id.nivel1_rightBtn3 ||
                btn.getId() == R.id.nivel2_rightBtn || btn.getId() == R.id.nivel2_rightBtn2 || btn.getId() == R.id.nivel2_rightBtn3 ||
                btn.getId() == R.id.nivel3_rightBtn || btn.getId() == R.id.nivel3_rightBtn2) {
            return true;
        }
        else {
            if (score > 10) {
                score = score - 1;
            }
            return false;
        }
    }

    public void allNumbers(int amount, int level) {
        count++;

        if (count == amount) {
            switch (level) {
                case 1:
                    RodearNumero_Nivel1.getInstance().setState(true);
                    RodearNumero_Nivel1.getInstance().nextLevel();
                    break;
                case 2:
                    RodearNumero_Nivel1.getInstance().setState(false);
                    RodearNumero_Nivel2.getInstance().setState(true);
                    RodearNumero_Nivel2.getInstance().nextLevel();
                    break;
                case 3:
                    RodearNumero_Nivel3.getInstance().nextLevel();
                    break;
            }

            count = 0;
        }
    }

    public int getScore() {
        return score;
    }

}
