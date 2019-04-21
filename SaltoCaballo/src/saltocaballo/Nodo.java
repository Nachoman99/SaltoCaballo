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
public class Nodo {
    private int dato;
    private Nodo sig;
    private Nodo ant;

    public Nodo(int dato, Nodo sig, Nodo ant) {
        this.dato = dato;
        this.sig = sig;
        this.ant = ant;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getSig() {
        return sig;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }

    public Nodo getAnt() {
        return ant;
    }

    public void setAnt(Nodo ant) {
        this.ant = ant;
    }

    @Override
    public String toString() {
        return "Nodo{" + "dato=" + dato + ", sig=" + sig + ", ant=" + ant + '}';
    }
   
}
