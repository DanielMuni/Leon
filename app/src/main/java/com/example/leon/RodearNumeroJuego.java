package com.example.leon;

import android.widget.Button;

public class RodearNumeroJuego {
    //Se declaran la variables
    int count = 0;
    int score = 100;

    /*Se declara la funcion correctButton que recibe un boton de parametro y regresa un booleano.
    * Si es un boton en especifico regresa true y si no la va restando valor a la variable soro,
    * si su valor es mayor a diez, y regresa false.*/
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

    /*Se declara la funcion allNumberse y recibe dos enteros como parametros, la cantidad de botones
    * correctos que hay en el nivel y el numero del nivel. Se le aumenta el valor de count por uno
    * y si este es igual a la cantidad de botones correctos dentro del nivel, se le asiganan los
    * valores a las variable actState de las diferentes clases por medio de la funcion setState y se
    * manda a llamar a la funcion nextLevel de la clase RodearNumero_Nivel1, RodearNumero_Nivel2
    * o RodearNumero_Nivel3, dependiendo el nivel en el que se este.*/
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

    /*Se declara la funcion getScore que devuelve el valor de la variable score.*/
    public int getScore() {
        return score;
    }

}
