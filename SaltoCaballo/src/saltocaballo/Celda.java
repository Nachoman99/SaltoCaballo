/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saltocaballo;

import java.util.ArrayList;

/**
 * Esta clase maneja las celdas del tablero
 * @version 27/04/2019
 * @author Kevin Trejos
 */
public class Celda {
    private boolean ocupada;
    private int posicion;
    private ArrayList<Coordenada> posiblesMovimientos;

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
     * @param ocupada si la celda ya fue visitada o no
     */
    public Celda(int posicion, ArrayList<Coordenada> posiblesMovimientos, boolean ocupada) {
        this.posicion = posicion;
        this.posiblesMovimientos = posiblesMovimientos;
        this.ocupada = ocupada;
    }

    /**
     * get
     * @return la posicion
     */
    public int getPosicion() {
        return posicion;
    }

    /**
     * set
     * @param posicion la posicion
     */
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    /**
     * get
     * @return  un arrayList con los posibles movimientos
     */
    public ArrayList<Coordenada> getPosiblesMovimientos() {
        return posiblesMovimientos;
    }

    /**
     * set
     * @param posiblesMovimientos posibles movimientos
     */
    public void setPosiblesMovimientos(ArrayList<Coordenada> posiblesMovimientos) {
        this.posiblesMovimientos = posiblesMovimientos;
    }

    /**
     * get
     * @return boolean 
     */
    public boolean isOcupada() {
        return ocupada;
    }

    /**
     * set
     * @param ocupada boolean 
     */
    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }
    
    /**
     * toString
     * @return to String
     */
    @Override
    public String toString(){
        return "Celda{" + "ocupada=" + ocupada + ", posicion=" + posicion + ", posiblesMovimientos=" + posiblesMovimientos + '}';
    }

    /**
     * Añade una coordenada a un arrayList
     * @param coordenada coordenada a insertar
     */
    public void añadirPosiblesMovimientos(Coordenada coordenada) {
        posiblesMovimientos.add(0, coordenada);
    }
    
    /**
     * Elimina un coordenada de un arrayList
     * @param coordenada coordenada a eliminar
     */
    public void eliminarPosiblesMovimientos(Coordenada coordenada){
        for (int i = 0; i < posiblesMovimientos.size(); i++) {
            if (posiblesMovimientos.get(i) == coordenada) {
                posiblesMovimientos.remove(i);
            }
        }
    }
    
    /**
     * Elimina una coordenada por indice
     * @param index Indice a eliminar
     * @return la coordenada eliminada
     */
    public Coordenada eliminarMovimiento(int index){
        return posiblesMovimientos.remove(index);
    }
}
