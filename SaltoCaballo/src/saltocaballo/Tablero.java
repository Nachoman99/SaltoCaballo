/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saltocaballo;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Clase encargada de hacer la matriz de celdas y metodos necesarios para realizar procesos del salto del caballo
 * @version 27/04/2019
 * @author Kevin Trejos
 */
public class Tablero {
    private Celda[][] tablero;
    private int numeroMovimientos = 1;
    private Coordenada coordenadaInicio;
    private Lista listaMovimientos = new Lista();

    /**
     * Constructor vacío
     */
    public Tablero() {

    }
    
    /**
     * Constructor que no permite que el tamaño del tablero sea menor a 5
     * @param tamaño tamaño que el usuario ingresa
     * @throws ExceptionsCaballo Excepcion personalizada
     */
    public Tablero(int tamaño) throws ExceptionsCaballo{
        if (tamaño < 5) {
            throw new ExceptionsCaballo("El tamaño no puede ser menor a 5");
        }else{
            tablero = new Celda[tamaño][tamaño];
        }
    }

    /**
     * get
     * @return matriz de celdas
     */
    public Celda[][] getTablero() {
        return tablero;
    }

    /**
     * Set 
     * @param tablero Matriz de celdas
     */
    public void setTablero(Celda[][] tablero) {
        this.tablero = tablero;
    }

    /**
     * get
     * @return el numero de movimientos 
     */
    public int getNumeroMovimientos() {
        return numeroMovimientos;
    }

    /**
     * set
     * @param numeroMovimientos el numero de movimientos 
     */
    public void setNumeroMovimientos(int numeroMovimientos) {
        this.numeroMovimientos = numeroMovimientos;
    }

    /**
     * get
     * @return La lista de movimientos
     */
    public String getListaMovimientos(){
        return listaMovimientos.imprimirLista();
    }
    /**
     * To String
     * @return String
     */
    @Override
    public String toString(){
        return "Tablero{" + "tablero=" + Arrays.toString(tablero) + ", numeroMovimientos=" + numeroMovimientos + '}';
    }

    /**
     * Este método verifica los posibles movimientos que tiene cada celda 
     */
    public void posiblesMovimientos() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                tablero[i][j] = new Celda(0, new  ArrayList<>(), false);
                if(i+-2>=0){
                    if(j+-1>=0){
                        Coordenada movimiento5 = new Coordenada(-2, -1);
                        tablero[i][j].añadirPosiblesMovimientos(movimiento5);
                    }
                    if(j+1<tablero.length){
                        Coordenada movimiento6 = new Coordenada(-2, +1);
                        tablero[i][j].añadirPosiblesMovimientos(movimiento6);
                    }
                }
  
                if(i+-1>=0){
                    if(j+-2>=0){
                        Coordenada movimiento3 = new Coordenada(-1, -2);
                        tablero[i][j].añadirPosiblesMovimientos(movimiento3);
                    }
                    if(j+2<tablero.length){
                        Coordenada movimiento4 = new Coordenada(-1, +2);
                        tablero[i][j].añadirPosiblesMovimientos(movimiento4);
                    }
                }
                
                if(i+1<tablero.length){
                    if(j+-2>=0){
                        Coordenada movimiento1 = new Coordenada(+1, -2);
                        tablero[i][j].añadirPosiblesMovimientos(movimiento1);
                    }
                    if(j+2<tablero.length){
                        Coordenada movimiento2 = new Coordenada(+1, +2);
                        tablero[i][j].setPosicion(0);
                        tablero[i][j].añadirPosiblesMovimientos(movimiento2);
                    }
                }
        
                if(i+2<tablero.length){
                    if (j+1<tablero.length) {
                        Coordenada movimiento7 = new Coordenada(+2, +1);
                        tablero[i][j].añadirPosiblesMovimientos(movimiento7);
                    }
                    if(j-1>=0){
                        Coordenada movimiento8 = new Coordenada(+2, -1);
                        tablero[i][j].añadirPosiblesMovimientos(movimiento8);
                    }
                }  
            }
        }
    }
    
    /**
     * Metodo para borrar el movimiento de la penultima celda a la ultima
     * @param xOriginal
     * @param yOriginal
     * @param cordenadaBorrar 
     */
    public void borrarEspecificoMovimiento(int xOriginal, int yOriginal, Coordenada cordenadaBorrar){
        int limite= tablero[xOriginal][yOriginal].getPosiblesMovimientos().size();
        if(limite>=0){  
             for (int i = 0; i < limite ; i++) {
                Coordenada cordenada1=tablero[xOriginal][yOriginal].getPosiblesMovimientos().get(i);
                if(((xOriginal+cordenada1.getX()) == cordenadaBorrar.getX())&&((yOriginal+cordenada1.getY()) == cordenadaBorrar.getY())){
                   tablero[xOriginal][yOriginal].getPosiblesMovimientos().remove(i);
                   limite--;
                     

                }
            }
        }   
    }
    
    /**
     * Este método actualiza los posibles movimientos de una Celda en específico
     * @param coordendaActualizar Coordenada de la Celda a actualizar
     */
    public void actualizarPosibles(Coordenada coordendaActualizar){
        int i=coordendaActualizar.getX();
        int j = coordendaActualizar.getY();
        tablero[i][j] = new Celda(-1, new  ArrayList<>(), false);
        if(i+-2>=0){
            if(j+-1>=0){
                Coordenada movimiento5 = new Coordenada(-2, -1);
                tablero[i][j].añadirPosiblesMovimientos(movimiento5);
            }
            if(j+1<tablero.length){
                Coordenada movimiento6 = new Coordenada(-2, +1);
                tablero[i][j].añadirPosiblesMovimientos(movimiento6);
            }
        }
        if(i+-1>=0){
            if(j+-2>=0){
                Coordenada movimiento3 = new Coordenada(-1, -2);
                tablero[i][j].añadirPosiblesMovimientos(movimiento3);
            }
            if(j+2<tablero.length){
            Coordenada movimiento4 = new Coordenada(-1, +2);
            tablero[i][j].añadirPosiblesMovimientos(movimiento4);
            }
        }             
        if(i+1<tablero.length){
            if(j+-2>=0){
                Coordenada movimiento1 = new Coordenada(+1, -2);
                tablero[i][j].añadirPosiblesMovimientos(movimiento1);
            }
            if(j+2<tablero.length){
            Coordenada movimiento2 = new Coordenada(+1, +2);
            tablero[i][j].setPosicion(0);
            tablero[i][j].añadirPosiblesMovimientos(movimiento2);
            }
        }
        if(i+2<tablero.length){
            if (j+1<tablero.length) {
                Coordenada movimiento7 = new Coordenada(+2, +1);
                tablero[i][j].añadirPosiblesMovimientos(movimiento7);
            }
            if(j-1>=0){
                Coordenada movimiento8 = new Coordenada(+2, -1);
                tablero[i][j].añadirPosiblesMovimientos(movimiento8);
            }
        }  
    }
   
    /**
     * Verifica todos los movimientos que el caballo puede hacer, si el caballo necesita volver atrás este método lo hace
     * @param posicionInicial Coordenada donde el caballo inicia
     * @return si encontró solución retorna true, de lo contrario retorna false
     */
    public boolean vueltaAtras(Coordenada posicionInicial){
        Coordenada coordenadaNueva;
        Coordenada coordenadaInsertar = new Coordenada();
        int coordenadaX=0;
        int coordenadaY=0;
        while (tableroListo() == false) { 
            if (isPrimeraVez() == true) {
                tablero[posicionInicial.getX()][posicionInicial.getY()].setOcupada(true);
                tablero[posicionInicial.getX()][posicionInicial.getY()].setPosicion(numeroMovimientos);
                int xInicial=posicionInicial.getX();
                int yInicial=posicionInicial.getY();
                coordenadaInicio = new Coordenada(xInicial, yInicial);
                listaMovimientos.insertarFinal(new Coordenada(coordenadaInicio.getX(), coordenadaInicio.getY()));
                numeroMovimientos += 1;
            }
            if ((tablero[coordenadaInicio.getX()][coordenadaInicio.getY()].getPosiblesMovimientos().size() <= 0) && (isPrimeraVez() == false)) {
                listaMovimientos.eliminarFinal();
                System.out.println("No hay solucion");
                return false;
            }else{
                if(tablero[posicionInicial.getX()][posicionInicial.getY()].getPosiblesMovimientos().isEmpty() == false){
                    coordenadaNueva = tablero[posicionInicial.getX()][posicionInicial.getY()].getPosiblesMovimientos().get(0);
                    coordenadaX = coordenadaNueva.getX();
                    coordenadaY = coordenadaNueva.getY();
                    if (tablero[posicionInicial.getX() + coordenadaX][posicionInicial.getY() + coordenadaY].isOcupada() != true) {
                       coordenadaInsertar.setX(coordenadaX+posicionInicial.getX());
                       coordenadaInsertar.setY(coordenadaY+posicionInicial.getY());
                       listaMovimientos.insertarFinal(new Coordenada(coordenadaInsertar.getX(), coordenadaInsertar.getY()));
                       tablero[coordenadaInsertar.getX()][coordenadaInsertar.getY()].setOcupada(true);
                       tablero[coordenadaInsertar.getX()][coordenadaInsertar.getY()].setPosicion(numeroMovimientos);
                       numeroMovimientos += 1;
                       posicionInicial.setX(coordenadaInsertar.getX());
                       posicionInicial.setY(coordenadaInsertar.getY());    
                    }else{
                        tablero[posicionInicial.getX()][posicionInicial.getY()].getPosiblesMovimientos().remove(0);
                    }
                }
            }
            if (tablero[posicionInicial.getX()][posicionInicial.getY()].getPosiblesMovimientos().isEmpty()) {
                int xNueva;
                int yNueva;
                int xUltima;
                int yUltima;
                Coordenada coordenadaUltima = listaMovimientos.getUltimaCoordenada();
                Coordenada coordenadaAnterior = listaMovimientos.getPenultimo();
                xNueva = coordenadaAnterior.getX();
                yNueva = coordenadaAnterior.getY();
                xUltima = coordenadaUltima.getX();
                yUltima = coordenadaUltima.getY();
                if(tablero[xNueva][yNueva].getPosiblesMovimientos().isEmpty()==false){
                    borrarEspecificoMovimiento(xNueva, yNueva, coordenadaUltima);
                }
                actualizarPosibles(new Coordenada(xUltima, yUltima));
                tablero[coordenadaUltima.getX()][coordenadaUltima.getY()].setPosicion(0);
                tablero[coordenadaUltima.getX()][coordenadaUltima.getY()].setOcupada(false);
                numeroMovimientos--;
                tablero[coordenadaUltima.getX()][coordenadaUltima.getY()].setOcupada(false);
                tablero[coordenadaUltima.getX()][coordenadaUltima.getY()].setPosicion(0);
                listaMovimientos.eliminarFinal();
                posicionInicial.setX(xNueva);
                posicionInicial.setY(yNueva);
            }
        }
        return true;
    }
    
    /**
     * Verifica si es la primera vez que se usa el método vueltaAtrás
     * @return true si es la primera vez, false de lo contrario
     */
    public boolean isPrimeraVez(){
        int count = 0;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[i][j].isOcupada() == true) {
                    count += 1;
                }
            }
        }
        if (count == 0) {
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Verifica si el tablero ya está totalmente ocupado 
     * @return true si todas las Celdas están ocupadas, false de lo contrario
     */
    public boolean tableroListo(){
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if(tablero[i][j].isOcupada() == false){
                    return false;
                }
            }
        }
        return true;
    }
   
    /**
     * Imprime el tablero
     * @return un string con un formato de matriz del tablero
     */
    public String imprimirTablero(){
        String print = "";
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                print +=String.format("%02d", tablero[i][j].getPosicion()) + " | ";
            }
            print += "\n";
        }
        return print;
    }
    
    /**
     * Verifica si el String que le ingresa se puede convertir a int
     * @param cadena String a convertir
     * @return true si el String ingresado es un número, sino retorna false
     */
    public boolean isNumero(String cadena){
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    /**
     * Este método verifica si las Coordenadas que el usuario quiere ingresar son válidas
     * @param x posición x de la Coordenada
     * @param y posición y de la Coordenada
     * @param tamaño tamaño del tablero
     * @return la Coordenada si los String ingresados son números
     * @throws ExceptionsCaballo Excepciones personalizadas
     */
    public Coordenada CoordenadasInt(String x, String y, int tamaño) throws ExceptionsCaballo{
        Coordenada coordenadaInicial;
        int coordenadaX;
        int coordenadaY;
        if (isNumero(x) == true && isNumero(y) == true) {
            coordenadaX = Integer.parseInt(x);
            coordenadaY = Integer.parseInt(y);
            if (coordenadaX < 0 || coordenadaY < 0) {
                throw new ExceptionsCaballo("La coordenada está fuera del tablero");
            }else if(coordenadaX >= tamaño || coordenadaY >= tamaño){
                throw new ExceptionsCaballo("La coordenada está fuera del tablero");
            }else{
                return coordenadaInicial = new Coordenada(coordenadaX, coordenadaY);
            }
        }else{
            throw new ExceptionsCaballo("Las coordenadas tienen que ser enteros");
        }
    }
}
