package com.example.leon;

import android.widget.ImageButton;

public class UnirPuntosJuego {
    //Se declaran la variables
    int count = 0;
    int score = 100;

    /*Se declara la funcion correctPair que recibe dos ImageButton y regresa un booleano. Si el
    * contenido de la descripcion es la misma para los dos botones regresa true, si es diferente
    * el valor de score disminuye uno, si su valor es mayor a diez, y regresa false.*/
    public boolean correctPair(ImageButton pair1,ImageButton pair2) {
        if (pair1.getContentDescription() == pair2.getContentDescription())
            return true;
        else
            if (score > 10)
                score = score - 1;

            return false;
    }

    /*Se declara la funcion allPairs  y recibe dos enteros como parametros, la canridad de pares
     * que hay en el nivel y el numero del nivel. Se le aumenta el valor de count por uno
     * y si este es igual a la cantidad de pares dentro del nivel, se le asiganan los valores a las
     * variable actState de las diferentes clases por medio de la funcion setState y se
     * manda a llamar a la funcion nextLevel de la clase UnirPuntos_Nivel1, UnirPuntos_Nivel2,
     * UnirPuntos_Nivel3 o UnirPuntos_Nivel4, dependiendo el nivel en el que se este.*/
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

    /*Se declara la funcion getScore que devuelve el valor de la variable score.*/
    public int getScore() {
        return score;
    }
}
