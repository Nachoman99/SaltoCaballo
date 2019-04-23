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
public class Celda {
    private String posicion;
    private ArrayList<Coordenada> posiblesMovimientos ;

    /**
     * Constructor
     */
    public Celda() {
        posiblesMovimientos = new ArrayList<>();
    }
    
    /**
     * Constructor
     * @param posicion este parametro indica la posicion de cada celda
     * @param posiblesMovimientos posibles movimientos del caballo
     */
    public Celda(String posicion, ArrayList<Coordenada> posiblesMovimientos) {
        this.posicion = posicion;
        this.posiblesMovimientos = posiblesMovimientos;
    }

    /**
     * getPoscision
     * @return
     */
    public String getPosicion() {
        return posicion;
    }

    /**
     *
     * @param posicion
     */
    public void setPoscicion(String posicion) {
        this.posicion = posicion;
    }

    /**
     *
     * @return
     */
    public ArrayList<Coordenada> getPosiblesMovimientos() {
        return posiblesMovimientos;
    }

    /**
     *
     * @param posiblesMovimientos
     */
    public void setPosiblesMovimientos(ArrayList<Coordenada> posiblesMovimientos) {
        this.posiblesMovimientos = posiblesMovimientos;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Celda{" + "posicion=" + posicion + ", posiblesMovimientos=" + posiblesMovimientos + '}';
    }
    
    /**
     *
     * @param coordenada
     */
    public void añadirPosiblesMovimientos(Coordenada coordenada){
        posiblesMovimientos.add(coordenada);
    }
    
    /**
     *
     * @param coordenada
     */
    public void eliminarPosiblesMovimientos(Coordenada coordenada){
        posiblesMovimientos.remove(coordenada);
    }
}
