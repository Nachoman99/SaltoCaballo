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

    /**
     * Constructor
     */
    public Tablero() {
        tablero= new Celda[5][5];
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

    /**
     * To String
     * @return String
     */
    @Override
    public String toString() {
        return "Tablero{" + "tablero=" + Arrays.toString(tablero) + '}';
    }
    
    /**
     * Este método verifica los posibles movimientos que el caballo tiene
     */
    //este metodo hay que llamarlo antes de todo para cargar las celdas con sus moviemientos
    public void posiblesMovimientos(){
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                tablero[i][j] = new Celda(null, new  ArrayList<>(), false);
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
                        tablero[i][j].setPoscicion("0");
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
        if (tableroListo() == true) {
            System.out.println("Se terminó el proceso");
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
                    Coordenada coordenadaInsertar = null;
                    coordenadaInsertar.setX(posicionInicial.getX() + coordenadaX);
                    coordenadaInsertar.setY(posicionInicial.getY() + coordenadaY);
                    listaMovimientos.insertarFinal(coordenadaInsertar);
                    vueltaAtras(listaMovimientos, coordenadaInsertar);
                    realizoMovimiento = false;
                }
            }
            if (realizoMovimiento == true) {
                
            }
        }
    }
    
    public boolean tableroListo(){
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if(tablero[i][j].isOcupada()==false){
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
}
