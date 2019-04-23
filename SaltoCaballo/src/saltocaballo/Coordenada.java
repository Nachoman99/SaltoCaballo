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
public class Coordenada {
    private int x;
    private int y;

    /**
     * Constructor vacío
     */
    public Coordenada() {
    }

    /**
     * Constructor con parametros
     * @param x un valor entero
     * @param y un valor entero
     */
    public Coordenada(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * get
     * @return un valor entero
     */
    public int getX() {
        return x;
    }

    /**
     * set
     * @param x un valor entero
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * get
     * @return un valor entero
     */
    public int getY() {
        return y;
    }

    /**
     * set
     * @param y un valor entero
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * to string
     * @return un String
     */
    @Override
    public String toString() {
        return "Coordenadas{" + "x=" + x + ", y=" + y + '}';
    }
}
