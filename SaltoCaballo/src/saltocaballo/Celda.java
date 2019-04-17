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
    private String poscicion;
    private ArrayList<Coordenada> posiblesMovimientos;

    public Celda() {
    }
    
    public Celda(String poscicion, ArrayList<Coordenada> posiblesMovimientos) {
        this.poscicion = poscicion;
        this.posiblesMovimientos = posiblesMovimientos;
    }

    public String getPoscicion() {
        return poscicion;
    }

    public void setPoscicion(String poscicion) {
        this.poscicion = poscicion;
    }

    public ArrayList<Coordenada> getPosiblesMovimientos() {
        return posiblesMovimientos;
    }

    public void setPosiblesMovimientos(ArrayList<Coordenada> posiblesMovimientos) {
        this.posiblesMovimientos = posiblesMovimientos;
    }

    @Override
    public String toString() {
        return "Celda{" + "poscicion=" + poscicion + ", posiblesMovimientos=" + posiblesMovimientos + '}';
    }
    
    public void añadir(Coordenada coordenada){
        posiblesMovimientos.add(coordenada);
    }
    
    public void eliminar(Coordenada coordenada){
        posiblesMovimientos.remove(coordenada);
    }
}
