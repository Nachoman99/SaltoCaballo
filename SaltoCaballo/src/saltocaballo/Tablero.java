/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saltocaballo;

/**
 *
 * @author Kevin Trejos
 */
public class Tablero {
    private Celda[][] tablero = new Celda[5][5];

    public Tablero() {
    }

    public Celda[][] getTablero() {
        return tablero;
    }

    public void setTablero(Celda[][] tablero) {
        this.tablero = tablero;
    }

    @Override
    public String toString() {
        return "Tablero{" + "tablero=" + tablero + '}';
    }
    
    
}
