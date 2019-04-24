/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saltocaballo;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Kevin Trejos
 */
public class Tablero {
    private Celda[][] tablero;
    private int numeroMovimientos = 1;
    
    /**
     * Constructor
     */
    public Tablero() {
        tablero = new Celda[5][5];
    }

    /**
     * get
     * @return matriz de celdas
     */
    public Celda[][] getTablero() {
        return tablero;
    }

    /**
     * Set 
     * @param tablero Matriz de celdas
     */
    public void setTablero(Celda[][] tablero) {
        this.tablero = tablero;
    }

    public int getNumeroMovimientos() {
        return numeroMovimientos;
    }

    public void setNumeroMovimientos(int numeroMovimientos) {
        this.numeroMovimientos = numeroMovimientos;
    }

    /**
     * To String
     * @return String
     */
    @Override
    public String toString(){
        return "Tablero{" + "tablero=" + Arrays.toString(tablero) + ", numeroMovimientos=" + numeroMovimientos + '}';
    }

    /**
     * Este método verifica los posibles movimientos que el caballo tiene
     */
    //este metodo hay que llamarlo antes de todo para cargar las celdas con sus moviemientos
    public void posiblesMovimientos() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                tablero[i][j] = new Celda(0, new  ArrayList<>(), false);
                if(i+-2>=0){
                    if(j+-1>=0){
                        Coordenada movimiento5 = new Coordenada(-2, -1);
                        tablero[i][j].añadirPosiblesMovimientos(movimiento5);
                    }
                    if(j+1<tablero.length){
                        Coordenada movimiento6 = new Coordenada(-2, +1);
                        tablero[i][j].añadirPosiblesMovimientos(movimiento6);
                    }
                }
  
                if(i+-1>=0){
                    if(j+-2>=0){
                        Coordenada movimiento3 = new Coordenada(-1, -2);
                        tablero[i][j].añadirPosiblesMovimientos(movimiento3);
                    }
                    if(j+2<tablero.length){
                        Coordenada movimiento4 = new Coordenada(-1, +2);
                        tablero[i][j].añadirPosiblesMovimientos(movimiento4);
                    }
                }
                
                if(i+1<tablero.length){
                    if(j+-2>=0){
                        Coordenada movimiento1 = new Coordenada(+1, -2);
                        tablero[i][j].añadirPosiblesMovimientos(movimiento1);
                    }
                    if(j+2<tablero.length){
                        Coordenada movimiento2 = new Coordenada(+1, +2);
                        tablero[i][j].setPosicion(0);
                        tablero[i][j].añadirPosiblesMovimientos(movimiento2);
                    }
                }
        
                if(i+2<tablero.length){
                    if (j+1<tablero.length) {
                        Coordenada movimiento7 = new Coordenada(+2, +1);
                        tablero[i][j].añadirPosiblesMovimientos(movimiento7);
                    }
                    if(j-1>=0){
                        Coordenada movimiento8 = new Coordenada(+2, -1);
                        tablero[i][j].añadirPosiblesMovimientos(movimiento8);
                    }
                }  
            }
        }
    }
    
    /**
     * 
     * @param x
     * @param y
     */
    public void posiblesMovimientosEspecifico(int x, int y){
        ArrayList movimientos = tablero[x][y].getPosiblesMovimientos();
        System.out.println("Posibles movimientos de "+'('+x+','+y+')'+"\n"+movimientos.toString());  
    }
    
    public void vueltaAtras(Lista listaMovimientos, Coordenada posicionInicial){
        if (isPrimeraVez() == true) {
            tablero[posicionInicial.getX()][posicionInicial.getY()].setOcupada(true);
            tablero[posicionInicial.getX()][posicionInicial.getY()].setPosicion(numeroMovimientos);
            numeroMovimientos += 1;
        }
        if (tableroListo() == true) {
            System.out.println("Se terminó el proceso");
            return;
        }else{
            Coordenada coordenadaNueva;
            int coordenadaY;
            int coordenadaX;
            boolean realizoMovimiento = true;
            for (int i = 0; i < tablero[posicionInicial.getX()][posicionInicial.getY()].getPosiblesMovimientos().size(); i++) {
                coordenadaNueva = tablero[posicionInicial.getX()][posicionInicial.getY()].getPosiblesMovimientos().get(i);
                coordenadaX = coordenadaNueva.getX();
                coordenadaY = coordenadaNueva.getY();
                if (tablero[posicionInicial.getX() + coordenadaX][posicionInicial.getY() + coordenadaY].isOcupada() == false) {
                    System.out.println("Tablero");
                    Coordenada coordenadaInsertar = new Coordenada();
                    coordenadaInsertar.setX(posicionInicial.getX() + coordenadaX);
                    coordenadaInsertar.setY(posicionInicial.getY() + coordenadaY);
                    listaMovimientos.insertarFinal(coordenadaInsertar);
                    tablero[coordenadaInsertar.getX()][coordenadaInsertar.getY()].setOcupada(true);
                    tablero[coordenadaInsertar.getX()][coordenadaInsertar.getY()].setPosicion(numeroMovimientos);
                    numeroMovimientos += 1;
                    realizoMovimiento = false;
                    System.out.println(imprimirTablero());
                    vueltaAtras(listaMovimientos, coordenadaInsertar);
                    return;
                }
            }
            if (realizoMovimiento == true) {
                if (hayPenultimo() == true) {
                    Coordenada coordenadaUltima = listaMovimientos.getUltimaCoordenada();
                    Coordenada coordenadaAnterior = listaMovimientos.getPenultimo();
                    coordenadaX = coordenadaAnterior.getX();
                    coordenadaY = coordenadaAnterior.getY();
                    tablero[coordenadaUltima.getX()][coordenadaUltima.getY()].setPosicion(-1);
                    tablero[coordenadaUltima.getX()][coordenadaUltima.getY()].setOcupada(false);
                    tablero[coordenadaX][coordenadaY].getPosiblesMovimientos().remove(0);
                    tablero[coordenadaX][coordenadaY].setPosicion(numeroMovimientos - 2);
                    numeroMovimientos += - 1;
                    try {
                        listaMovimientos.eliminarFinal();
                    } catch (ExceptionsCaballo e) {
                        System.out.println(e);
                    }
                    System.out.println("Tablero cuando retrocede");
                    System.out.println(imprimirTablero());
                    vueltaAtras(listaMovimientos, coordenadaAnterior);
                    return;
                }else{
                    System.out.println("No tiene solución");
                    return;
                }   
            }
        }
    }
    
    public Celda[][] copiarTablero(){
        Celda[][] tableroCopia = new Celda[tablero.length][tablero.length];
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                tableroCopia[i][j] = tablero[i][j];
            }
        }
        return tableroCopia;
    }
    
    public boolean hayPenultimo(){
        int count = 0;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[i][j].isOcupada() == true) {
                    count += 1;
                }
            }
        }
        if (count >= 3) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isPrimeraVez(){
        int count = 0;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[i][j].isOcupada() == true) {
                    count += 1;
                }
            }
        }
        if (count == 0) {
            return true;
        }else{
            return false;
        }
    }
    
    public boolean tableroListo(){
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if(tablero[i][j].isOcupada() == false){
                    return false;
                }
            }
        }
        return true;
    }
    //metodo solo para pruebas se puede borrar despues
    public void ponerTrue(){
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                tablero[i][j].setOcupada(true);
            }
        }
        //tablero[0][0].setOcupada(false);
    }
    
    public String imprimirTablero(){
        String print = "";
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                print += tablero[i][j].getPosicion() + " | ";
            }
            print += "\n";
        }
        return print;
    }
}
