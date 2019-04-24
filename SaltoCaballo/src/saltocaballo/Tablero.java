/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saltocaballo;

import java.util.ArrayList;

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
        return "Tablero{" + "tablero=" + tablero + '}';
    }
    
    /**
     * Este método verifica los posibles movimientos que el caballo tiene
     */
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
        System.out.println("Posibles moviemientos de "+'('+x+','+y+')'+"\n"+movimientos.toString());
        
        
    }
}
