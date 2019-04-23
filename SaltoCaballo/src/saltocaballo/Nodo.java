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
    private Coordenada dato;
    private Nodo sig;
    private Nodo ant;

    /**
     * Constructor
     * @param dato Una coordenada
     * @param sig Siguiente nodo en la lista
     * @param ant Nodo anterior en la lista
     */
    public Nodo(Coordenada dato, Nodo sig, Nodo ant) {
        this.dato = dato;
        this.sig = sig;
        this.ant = ant;
    }

    /** 
     * get
     * @return una coordenada
     */
    public Coordenada getDato() {
        return dato;
    }

    /**
     * set
     * @param dato Coordenada
     */
    public void setDato(Coordenada dato) {
        this.dato = dato;
    }

    /**
     * get
     * @return Siguiente nodo en la lista
     */
    public Nodo getSig() {
        return sig;
    }

    /**
     * set
     * @param sig Siguiente en la lista
     */
    public void setSig(Nodo sig) {
        this.sig = sig;
    }

    /**
     * get
     * @return Anterior en la lista 
     */
    public Nodo getAnt() {
        return ant;
    }

    /**
     * set
     * @param ant Anterior en la lista
     */
    public void setAnt(Nodo ant) {
        this.ant = ant;
    }

    /**
     * To String
     * @return String
     */
    @Override
    public String toString() {
        return "Nodo{" + "dato=" + dato + ", sig=" + sig + ", ant=" + ant + '}';
    }
}
