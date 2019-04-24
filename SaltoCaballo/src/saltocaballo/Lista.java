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
     * Inserta al inicio de la lista
     * @param dato Coordenada a insertar
     */
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
     * Elimina el inicio de la lista
     * @return el valor eliminado
     * @throws ExceptionsCaballo Excepcion personalizada
     */
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
    
    /**
     * Elimina el final de la lista
     * @return el elemento eliminado
     * @throws ExceptionsCaballo Excepcion personalizada
     */
    public Coordenada eliminarFinal() throws ExceptionsCaballo{
        Coordenada valorRet;
        if (primero == null && ultimo == null) {
            throw new ExceptionsCaballo("La lista está vacía");
        }else if(primero.getSig() == null){
            valorRet = primero.getDato();
            ultimo = null;
            primero = null;
            return valorRet;   
        }else{
            valorRet = ultimo.getDato();
            ultimo = ultimo.getAnt();
            ultimo.getSig().setAnt(null);
            ultimo.setSig(null);
        }
        return valorRet;
    }
    
    /**
     * Elimina la lista
     * @throws ExceptionsCaballo Excepcion personalizada
     */
    public void eliminarLista() throws ExceptionsCaballo{
        if (primero == null) {
            throw new ExceptionsCaballo("La lista está vacía");
        }else{
            primero = null;
            ultimo = null;
            temporal = null;
        }
    }
    //Revisar método
    /**
     * Elimina un dato en especifico
     * @param dato dato a eliminar
     * @return dato eliminado
     * @throws ExceptionsCaballo Excepcion personalizada
     */
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
    //Este método está mal

    /**
     * Elimina el indice especificado
     * @param index indice a eliminar
     * @return Elemento eliminado
     * @throws ExceptionsCaballo Excepcion personalizada
     */
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
     * Imprime la lista pero al reves
     * @return un String con la lista
     */
    public String imprimirReves(){
        String str = "";
        for(Nodo temp = ultimo; temp != null; temp = temp.getAnt()){
            str = str + temp.getDato() + " ";
        }
        return str;
    }
    
    public Coordenada getPenultimo(){
        return ultimo.getAnt().getDato();
    }
}
