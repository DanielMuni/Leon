package com.example.leon;

import java.util.ArrayList;
import java.util.Arrays;

class Nodo{

    int y = -1;
    int x = -1;

    boolean status      = false;
    boolean arriba      = false;
    boolean abajo       = false;
    boolean derecha     = false;
    boolean izquierda   = false;

    public boolean [] getDirecciones(){
        //0 = arriba, 1 = derecha, 2 = abajo, 3 = izquierda
        boolean [] direccione = new boolean[4];
        direccione[0] = arriba;
        direccione[1] = derecha;
        direccione[2] = abajo;
        direccione[3] = izquierda;

        return direccione;
    }
}

class MatrizDeLaberinto{

    Nodo[][] nodos;
    // y0x0 y0x1 y0x2
    // y1x0 y1x1 y1x2
    // y2x0 y2x1 y3x2

    int xFinal;
    int xInicial;

    private  ArrayList<Nodo> getVecinos(Nodo nodoActual, String status){
        ArrayList<Nodo> vecinos = new ArrayList<>();
        int yActual = nodoActual.y;
        int xActual = nodoActual.x;

        if (yActual > 0){ //Agregar nodo superior
            vecinos.add(this.nodos[yActual-1][xActual]);
        }
        if (yActual < this.nodos.length-1){ //Agregar nodo inferiror
            vecinos.add(this.nodos [yActual+1][xActual]);
        }
        if (xActual < this.nodos.length-1){ //Agregar nodo derecho
            vecinos.add(this.nodos [yActual][xActual+1]);
        }
        if (xActual > 0) { //Agregar nodo izquierdo
            vecinos.add(this.nodos [yActual][xActual-1]);
        }

        ArrayList<Nodo> vecinosSelecionados = new ArrayList<>();

        if (status.equals("conectados")){
            for (int i = 0; i < vecinos.size(); i ++){
                if (vecinos.get(i).status)
                    vecinosSelecionados.add(vecinos.get(i));
            }
        }
        else{
            for (int i = 0; i < vecinos.size(); i ++){
                if (!vecinos.get(i).status)
                    vecinosSelecionados.add(vecinos.get(i));
            }
        }
        return vecinosSelecionados;
    }

    private void conectarNodos(Nodo nodoA, Nodo nodoB){

        //Elevar el status de los nodos
        if (!nodoA.status)
            nodoA.status = true;
        if (!nodoB.status)
            nodoB.status = true;


        if (nodoA.y == nodoB.y){
            if (nodoA.x < nodoB.x){
                this.nodos[nodoA.y][nodoA.x].derecha = true;
                this.nodos[nodoB.y][nodoB.x].izquierda = true;
            }
            else{
                this.nodos[nodoA.y][nodoA.x].izquierda = true;
                this.nodos[nodoB.y][nodoB.x].derecha = true;
            }
        }
        else{
            if (nodoA.y < nodoB.y){
                this.nodos[nodoA.y][nodoA.x].abajo = true;
                this.nodos[nodoB.y][nodoB.x].arriba = true;
            }
            else{
                this.nodos[nodoA.y][nodoA.x].arriba = true;
                this.nodos[nodoB.y][nodoB.x].abajo = true;
            }
        }
    }

    public MatrizDeLaberinto(int n){
        this.nodos = new Nodo[n][n];
        for (int y = 0; y < n; y++){
            for (int x = 0; x < n; x++){
                this.nodos[y][x] = new Nodo();
                this.nodos[y][x].y = y;
                this.nodos[y][x].x = x;
            }
        }

        //Inicializamos la entrada y salida del laberinto, yInicial y yFinal siempre van a ser 0 y n,
        // respectivamente
        xFinal = (int) (Math.random() * n);
        this.nodos[0][xFinal].arriba = true;
        xInicial = (int) (Math.random() * n);
        this.nodos[n-1][xInicial].abajo = true;

        //Agregamos el nodo inical a los nodos conectados
        Nodo nodoInicial= this.nodos[n-1][xInicial];
        nodoInicial.status = true;

        //Agregamos sus vecinos a los nodos no conectados
        ArrayList<Nodo> vecinosNoConectados = getVecinos(nodoInicial, "no conectados");

        while (vecinosNoConectados.size() > 0){
            //Elejimos un nuevo nodo vecino de manera aleatoria para conectar
            int nodoAleatorio = (int) (Math.random() * vecinosNoConectados.size());
            Nodo nodoAConectar = vecinosNoConectados.get(nodoAleatorio);
            vecinosNoConectados.remove(nodoAleatorio);

            //Obtenemos los nodos vecinos conectados
            ArrayList<Nodo> vecinosConectados = getVecinos(nodoAConectar, "conectados");

            //Elejimos un nodo vecino conectado de forma aleatoria
            nodoAleatorio = (int) (Math.random() * vecinosConectados.size());
            Nodo nodoConectado = vecinosConectados.get(nodoAleatorio);

            //Conectamos el nodo por conectar con uno previamente conectado
            conectarNodos(nodoAConectar, nodoConectado);

            //Agregamos todos los nodos vecinos no conectados a la lista de nodos por conectar
            vecinosNoConectados.addAll(getVecinos(nodoAConectar, "no conectados"));
        }
    }

    public boolean [] getDirecciones(int y, int x){
        return nodos[y][x].getDirecciones();
    }

}

public class LaberintoModel {

    int n;
    MatrizDeLaberinto mapa;
    int xInicial;
    int xFinal;

    boolean [][] posicionDelJugador;
    int xActual;
    int yActual;

    LaberintoModel(){
        n = 10;
        mapa = new MatrizDeLaberinto(n);
        xInicial = mapa.xInicial;
        xFinal = mapa.xFinal;
        xActual = xInicial;
        yActual = n -1;

        posicionDelJugador = new boolean[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(posicionDelJugador[i], false);
        }
        posicionDelJugador[yActual][xActual] = true;
    }

    private String laberintoEnASCII(){
        String laberintoASCII = new String();
        String wildcard;

        //Agregamos el borde superior
        for (int x = 0; x < n; x++){
            if (!mapa.nodos[0][x].arriba)
                laberintoASCII += "+-+";
            else
                laberintoASCII += "+ +";
        }
        laberintoASCII += "\n";

        //Agregamos los pasillos y bordes inferiores
        for (int y = 0; y < n; y++){

            //Agregamos los pasillos
            for (int x = 0; x < n; x++){
                if (posicionDelJugador[y][x])
                    wildcard = "*";
                else
                    if (y == 0 && x == xFinal)
                        wildcard = "x";
                    else
                        wildcard = " ";

                if (mapa.nodos[y][x].izquierda && mapa.nodos[y][x].derecha)
                    laberintoASCII += " " + wildcard + " ";
                else
                if (!mapa.nodos[y][x].izquierda && !mapa.nodos[y][x].derecha)
                    laberintoASCII += "|" + wildcard + "|";
                else
                if (!mapa.nodos[y][x].izquierda)
                    laberintoASCII += "|" + wildcard + " ";
                else
                    laberintoASCII += " " + wildcard + "|";
            }
            laberintoASCII += "\n";

            //Agregamos los bordes inferiores
            for (int x = 0; x < n; x++){
                if (!mapa.nodos[y][x].abajo)
                    laberintoASCII += "+-+";
                else
                    laberintoASCII += "+ +";
            }
            laberintoASCII += "\n";
        }
        return laberintoASCII;
    }

    public String getLaberinto(){
        return laberintoEnASCII();
    }

    //Nos permite evaluar si el jugador se encuentra en la meta
    public boolean checkPosicion(){
        if (yActual == 0 && xActual == xFinal)
            return true;
        else
            return false;
    }

    //Nos permite obtener las opciones por donde se puede mover el jugador
    public boolean [] getControles(){
        boolean [] controlesSinRevisar = mapa.getDirecciones(yActual, xActual);

        //Control de seguridad
        // Evita que el jugador se salga del mapa cuando esta en la celda inicial
        if (yActual == n-1 && xActual == xInicial)
            controlesSinRevisar[2] = false;

        return controlesSinRevisar;
    }

    //Las siguientes funciones mueve al jugador en el mapa
    public void arriba(){
        int nuevaY = yActual - 1;
        posicionDelJugador[yActual][xActual] = false;
        posicionDelJugador[nuevaY][xActual] = true;
        yActual = nuevaY;
    }

    public void abajo(){
        int nuevaY = yActual + 1;
        posicionDelJugador[yActual][xActual] = false;
        posicionDelJugador[nuevaY][xActual] = true;
        yActual = nuevaY;
    }

    public void derecha(){
        int nuevaX = xActual + 1;
        posicionDelJugador[yActual][xActual] = false;
        posicionDelJugador[yActual][nuevaX] = true;
        xActual = nuevaX;
    }

    public void izquierda(){
        int nuevaX = xActual - 1;
        posicionDelJugador[yActual][xActual] = false;
        posicionDelJugador[yActual][nuevaX] = true;
        xActual = nuevaX;
    }
}
