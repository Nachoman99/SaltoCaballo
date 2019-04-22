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
public class Lista {
    private Nodo primero = null;
    private Nodo ultimo = null;
    private Nodo temporal = null;

    public Lista() {
    }
    
    public Lista(Nodo primero, Nodo ultimo){
        this.primero = primero;
        this.ultimo = ultimo;
    }

    public Nodo getPrimero() {
        return primero;
    }

    public void setPrimero(Nodo primero) {
        this.primero = primero;
    }

    public Nodo getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodo ultimo) {
        this.ultimo = ultimo;
    }

    public Nodo getTemporal() {
        return temporal;
    }

    public void setTemporal(Nodo temporal) {
        this.temporal = temporal;
    }

    @Override
    public String toString() {
        return "Lista{" + "primero=" + primero + ", ultimo=" + ultimo + ", temporal=" + temporal + '}';
    }
    
    public void insertarInicio(Coordenada dato){
        Nodo nuevo = new Nodo(dato, null, null);
        if (ultimo == null) {
            primero = nuevo;
            ultimo = primero;
        }else{
            nuevo.setSig(primero);
            primero.setAnt(nuevo);
            primero = nuevo;
        }
    }
    
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
    
    public Coordenada eliminarInicio() throws ExceptionsCaballo{
        Coordenada valorRet;
        if (primero == null || ultimo == null) {
            throw new ExceptionsCaballo("La lista está vacía");
        }else if(primero.getSig() == null){
            valorRet = primero.getDato();
            primero = null;
            ultimo = null;
        }else{
            valorRet = primero.getDato();
            primero = primero.getSig();
            primero.setAnt(null);
        }
        return valorRet;
    }
    
    public Coordenada eliminarFinal() throws ExceptionsCaballo{
        Coordenada valorRet;
        if (primero == null && ultimo == null) {
            throw new ExceptionsCaballo("La lista está vacía");
        }else{
            valorRet = ultimo.getDato();
            ultimo = ultimo.getAnt();
            ultimo.getSig().setAnt(null);
            ultimo.setSig(null);
        }
        return valorRet;
    }
    
    public void eliminarLista() throws ExceptionsCaballo{
        if (primero == null) {
            throw new ExceptionsCaballo("La lista está vacía");
        }else{
            primero = null;
            ultimo = null;
            temporal = null;
        }
    }
    
    public Coordenada eliminarDatoEspecifico(Coordenada dato) throws ExceptionsCaballo{
        Coordenada valorRet;
        if (primero == null || ultimo == null) {
            throw new ExceptionsCaballo("La lista está vacía");
        }else if(primero.getDato() == dato){
            valorRet = primero.getDato();
            eliminarInicio();
            return valorRet;
        }else if(ultimo.getDato() == dato){
            valorRet = ultimo.getDato();
            eliminarFinal();
            return valorRet;
        }else{
            temporal = primero;
            while (temporal.getSig() != null) {                
                if (temporal.getDato() == dato) {
                    valorRet = temporal.getDato();
                    temporal.getAnt().setSig(temporal.getSig());
                    temporal.getSig().setAnt(temporal.getAnt());
                    return valorRet;
                }else{
                    temporal = temporal.getSig();
                }
            }
        }
        throw new ExceptionsCaballo("El dato no se encuentra en la lista");
    }
    
    public Coordenada eliminarIndice(int index) throws ExceptionsCaballo{
        Coordenada valorRet;
        int count = 0;
        if (primero == null) {
            throw new ExceptionsCaballo("La lista está vacía");
        }else if(index == 0){
            valorRet = primero.getDato();
            eliminarInicio();
            return valorRet;
        }else{
            temporal = primero;
            while (primero.getSig() != null) {                
                if (count == index) {
                    valorRet = temporal.getDato();
                    temporal.getAnt().setSig(temporal.getSig());
                    temporal.getSig().setAnt(temporal.getAnt());
                    return valorRet;
                }else{
                    count += 1;
                    temporal = temporal.getSig();
                }
            }
        }
        throw new ExceptionsCaballo("No se encuentra el indice especificado");
    }
    
    public String imprimirLista(){
        String result = "";
        for (Nodo temp = primero; temp != null;temp = temp.getSig()) {
            result = result + temp.getDato() + "\n"; 
        }
        return result;
    }
    
    public String imprimirReves(){
        String str = "";
        for(Nodo temp = ultimo; temp != null; temp = temp.getAnt()){
            str = str + temp.getDato() + " ";
        }
        return str;
    }
}
