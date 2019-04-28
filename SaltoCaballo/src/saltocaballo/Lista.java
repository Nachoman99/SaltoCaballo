/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saltocaballo;

/**
 * Esta clase es una lista de nodos para manejar los movimientos que ya se han realizado en el tablero
 * @version 27/04/2019
 * @author Kevin Trejos
 */
public class Lista {
    private Nodo primero = null;
    private Nodo ultimo = null;
    private Nodo temporal = null;
    
    /**
     * Constructor vacío
     */
    public Lista() {
        
    }
    
    /**
     * Constructor con parametros
     * @param primero primer posicion
     * @param ultimo ultima posicion
     */
    public Lista(Nodo primero, Nodo ultimo){
        this.primero = primero;
        this.ultimo = ultimo;
    }

    /**
     * get
     * @return primero
     */
    public Nodo getPrimero() {
        return primero;
    }

    /**
     * set
     * @param primero primero
     */
    public void setPrimero(Nodo primero) {
        this.primero = primero;
    }

    /**
     * get
     * @return ultimo
     */
    public Nodo getUltimo() {
        return ultimo;
    }

    /**
     * set
     * @param ultimo ultimo
     */
    public void setUltimo(Nodo ultimo) {
        this.ultimo = ultimo;
    }

    /**
     * get
     * @return temporal
     */
    public Nodo getTemporal() {
        return temporal;
    }

    /**
     * set
     * @param temporal temporal
     */
    public void setTemporal(Nodo temporal) {
        this.temporal = temporal;
    }

    /**
     * to sstring
     * @return String
     */
    @Override
    public String toString() {
        return "Lista{" + "primero=" + primero + ", ultimo=" + ultimo + ", temporal=" + temporal + '}';
    }
    
    /**
     * Inserta al final de la lista
     * @param dato Coordenada a insertar
     */
    public void insertarFinal(Coordenada dato){
        Nodo nuevo = new Nodo(dato, null, null);
        if (ultimo == null) {
            ultimo = nuevo;
            primero = ultimo;
        }else{
            nuevo.setAnt(ultimo);
            ultimo.setSig(nuevo);
            ultimo = nuevo;
        }
    }
    
    /**
     * Elimina el final de la lista
     * @return el elemento eliminado
     */
    public boolean eliminarFinal(){
        Coordenada valorRet;
        if (primero == null && ultimo == null) {
            return false;
        }else if(primero.getSig() == null){
            valorRet = primero.getDato();
            ultimo = null;
            primero = null;
            return true;   
        }else{
            valorRet = ultimo.getDato();
            ultimo = ultimo.getAnt();
            ultimo.getSig().setAnt(null);
            ultimo.setSig(null);
        }
        return true;
    }
    
    /**
     * Ultimo dato de la lista
     * @return el ultimo dato de la lista
     */
    public Coordenada getUltimaCoordenada(){
        return ultimo.getDato();
    }
    
    /**
     * Imprime la lista
     * @return un String con la lista
     */
    public String imprimirLista(){
        String result = "";
        for (Nodo temp = primero; temp != null;temp = temp.getSig()) {
            result = result + temp.getDato() + "\n"; 
        }
        return result;
    }
    
    /**
     * Obtiene el penultimo elemento de la lista
     * @return penultimo elemento de la lista
     */
    public Coordenada getPenultimo(){
        return ultimo.getAnt().getDato();
    }
}
