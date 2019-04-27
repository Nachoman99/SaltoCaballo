/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saltocaballo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author Kevin Trejos
 */
public class Tablero {
    private Celda[][] tablero;
    private int numeroMovimientos = 1;
    private Coordenada coordenadaInicio;
    private Lista listaMovimientos=new Lista();

    
    public Tablero() {

    }
    
    /**
     * Constructor
     */
    public Tablero(int tamaño) {
        if (tamaño < 5) {
            JOptionPane.showMessageDialog(null, "El tamaño del tablero no puede ser menor a 5");
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

    public int getNumeroMovimientos() {
        return numeroMovimientos;
    }

    public void setNumeroMovimientos(int numeroMovimientos) {
        this.numeroMovimientos = numeroMovimientos;
    }

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
     * Este método verifica los posibles movimientos que el caballo tiene
     */
    //este metodo hay que llamarlo antes de todo para cargar las celdas con sus moviemientos
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
    
   public void borrarEspecificoMoviento(int xOriginal, int yOriginal, Coordenada cordenadaBorrar){
//        int indiceBorrar=0;
//        //System.out.println("lista= "+tablero[xOriginal][yOriginal].getPosiblesMovimientos());
//        Iterator iterador = tablero[xOriginal][yOriginal].getPosiblesMovimientos().iterator();
//        while (iterador.hasNext()) {
//            Coordenada cordenada1 = (Coordenada)iterador.next();
//            if((cordenada1.getX() == tablero[cordenadaBorrar.getX()][cordenadaBorrar.getY()].getPosiblesMovimientos().get(indiceBorrar))&&(cordenada1.getY() == yComparar)){
//                tablero[xOriginal][yOriginal].getPosiblesMovimientos().remove(indiceBorrar);
//                System.out.println("se borro la posicion maaaaaaaaaaaaalaaaa");
//            }
//            indiceBorrar+=1;
//            
//            
//        }
//        
        
        
        int limite= tablero[xOriginal][yOriginal].getPosiblesMovimientos().size();
        //System.out.println("limite= "+limite);
        if(limite>=0){  
             for (int i = 0; i < limite ; i++) {
                 //System.out.println("Porque no sirve=" +tablero[xOriginal][yOriginal].getPosiblesMovimientos());
                 //System.out.println("I= "+i );
                 Coordenada cordenada1=tablero[xOriginal][yOriginal].getPosiblesMovimientos().get(i);
                 //System.out.println("Xanterior= "+xOriginal+" Yanterior= "+yOriginal);
                 //System.out.println("Xmovimiento= "+cordenada1.getX()+" Ymovimiento= "+cordenada1.getY());
                 if(((xOriginal+cordenada1.getX()) == cordenadaBorrar.getX())&&((yOriginal+cordenada1.getY()) == cordenadaBorrar.getY())){
                     tablero[xOriginal][yOriginal].getPosiblesMovimientos().remove(i);
                     //System.out.println("se borro la posicion maaaaaaaaaaaaalaaaa");
                     limite--;
                     

                 }
             }
 
        }
                
    }


    
    
    public void borrarMovientosPosibles(Coordenada coordendaActualizar){
        int i=coordendaActualizar.getX();
        int j = coordendaActualizar.getY();
        tablero[i][j].setPosiblesMovimientos(null);
    }
    
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
     * 
     * @param x
     * @param y
     */
    public void posiblesMovimientosEspecifico(int x, int y){
        ArrayList movimientos = tablero[x][y].getPosiblesMovimientos();
        System.out.println("Posibles movimientos de "+'('+x+','+y+')'+"\n"+movimientos.toString());  
    }
    
//    public void vueltaAtras(Lista listaMovimientos, Coordenada posicionInicial){
//        if (isPrimeraVez() == true) {
//            tablero[posicionInicial.getX()][posicionInicial.getY()].setOcupada(true);
//            tablero[posicionInicial.getX()][posicionInicial.getY()].setPosicion(numeroMovimientos);
//            int xInicial=posicionInicial.getX();
//            int yInicial=posicionInicial.getY();
//            coordenadaInicio = new Coordenada(xInicial, yInicial);
//            numeroMovimientos += 1;
//        }
//        if ((tablero[coordenadaInicio.getX()][coordenadaInicio.getY()].getPosiblesMovimientos().size() <= 0) && (isPrimeraVez() == false)) {
//            System.out.println("Se terminó el proceso");
//            return;
//        }else{
//            Coordenada coordenadaNueva;
//            int coordenadaY;
//            int coordenadaX;
//            boolean realizoMovimiento = true;
//            for (int i = 0; i < tablero[posicionInicial.getX()][posicionInicial.getY()].getPosiblesMovimientos().size(); i++) {
//                coordenadaNueva = tablero[posicionInicial.getX()][posicionInicial.getY()].getPosiblesMovimientos().get(i);
//                coordenadaX = coordenadaNueva.getX();
//                coordenadaY = coordenadaNueva.getY();
//                if (tablero[posicionInicial.getX() + coordenadaX][posicionInicial.getY() + coordenadaY].isOcupada() == false) {
//                    System.out.println("Tablero");
//                    Coordenada coordenadaInsertar = new Coordenada();
//                    coordenadaInsertar.setX(coordenadaX+posicionInicial.getX());
//                    coordenadaInsertar.setY(coordenadaY+posicionInicial.getY());
//                    listaMovimientos.insertarFinal(coordenadaInsertar);
//                    tablero[coordenadaInsertar.getX()][coordenadaInsertar.getY()].setOcupada(true);
//                    tablero[coordenadaInsertar.getX()][coordenadaInsertar.getY()].setPosicion(numeroMovimientos);
//                    numeroMovimientos += 1;
//                    realizoMovimiento = false;
//                    System.out.println(imprimirTablero());
//                    vueltaAtras(listaMovimientos, coordenadaInsertar);
//                    return;
//                }
//            }
//            if (realizoMovimiento == true) {
//                if (hayPenultimo() == true) {
//                    
//                    Coordenada coordenadaUltima = listaMovimientos.getUltimaCoordenada();
//                    Coordenada coordenadaAnterior = listaMovimientos.getPenultimo();
//                    coordenadaX = coordenadaAnterior.getX();
//                    coordenadaY = coordenadaAnterior.getY();
//                   
//                    tablero[coordenadaUltima.getX()][coordenadaUltima.getY()].setPosicion(-1);
//                    tablero[coordenadaUltima.getX()][coordenadaUltima.getY()].setOcupada(false);
//                     borrarEspecificoMoviento(coordenadaX, coordenadaY, coordenadaUltima);
//                    borrarMovientosPosibles(coordenadaUltima);
//                    actualizarPosibles(coordenadaUltima);
//                   
//                    
//                    //tablero[coordenadaX][coordenadaY].eliminarPosiblesMovimientos(coordenadaUltima);
//                    
//                    
//                    System.out.println(tablero[coordenadaX][coordenadaY].getPosiblesMovimientos());
//                    tablero[coordenadaX][coordenadaY].setPosicion(numeroMovimientos - 2);
//                    numeroMovimientos += - 1;
//                    
//                    try {
//                        listaMovimientos.eliminarFinal();
//                    } catch (ExceptionsCaballo e) {
//                        System.out.println(e);
//                    }
//                    System.out.println("Tablero cuando retrocede");
//                    System.out.println(imprimirTablero());
//                    
//                    vueltaAtras(listaMovimientos, coordenadaAnterior);
//                    return;
//                }else{
//                    System.out.println("No tiene solución");
//                    return;
//                }   
//            }
//        }
//    }
    
    
 public boolean vueltaAtras(Coordenada posicionInicial){
       
        Coordenada coordenadaNueva;
        Coordenada coordenadaInsertar = new Coordenada();
        int coordenadaX=0;
        int coordenadaY=0;
        boolean realizoMovimiento;
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
                    //realizoMovimiento = true;
                    if (tablero[posicionInicial.getX() + coordenadaX][posicionInicial.getY() + coordenadaY].isOcupada() != true) {
                       //System.out.println("Tablero");
                       coordenadaInsertar.setX(coordenadaX+posicionInicial.getX());
                       coordenadaInsertar.setY(coordenadaY+posicionInicial.getY());
                       listaMovimientos.insertarFinal(new Coordenada(coordenadaInsertar.getX(), coordenadaInsertar.getY()));

                        //System.out.println("Lista al insertar Valor= "+listaMovimientos.imprimirLista());

                       tablero[coordenadaInsertar.getX()][coordenadaInsertar.getY()].setOcupada(true);
                       tablero[coordenadaInsertar.getX()][coordenadaInsertar.getY()].setPosicion(numeroMovimientos);
                       numeroMovimientos += 1;
                       //realizoMovimiento = false;
                       //System.out.println(imprimirTablero());
                       posicionInicial.setX(coordenadaInsertar.getX());
                       posicionInicial.setY(coordenadaInsertar.getY());    
                    }else{
                        //System.out.println("borrado");
                        //System.out.println(posicionInicial+" lista= "+tablero[posicionInicial.getX()][posicionInicial.getY()].getPosiblesMovimientos());
                        tablero[posicionInicial.getX()][posicionInicial.getY()].getPosiblesMovimientos().remove(0);
                       // System.out.println(posicionInicial+" lista= "+tablero[posicionInicial.getX()][posicionInicial.getY()].getPosiblesMovimientos());
                    }
                    
                }
                
                //vueltaAtras(listaMovimientos, coordenadaInsertar);
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
                    borrarEspecificoMoviento(xNueva, yNueva, coordenadaUltima);
                    //tablero[xNueva][yNueva].getPosiblesMovimientos().remove(0);
                }
               
                
                //borrarMovientosPosibles(new Coordenada(xUltima, yUltima));
                actualizarPosibles(new Coordenada(xUltima, yUltima));
                tablero[coordenadaUltima.getX()][coordenadaUltima.getY()].setPosicion(-1);
                tablero[coordenadaUltima.getX()][coordenadaUltima.getY()].setOcupada(false);

                //tablero[coordenadaX][coordenadaY].eliminarPosiblesMovimientos(coordenadaUltima);
                //System.out.println("Movientos antes de borrar= "+tablero[xNueva][yNueva].getPosiblesMovimientos());
                //System.out.println("numero de movientos= "+numeroMovimientos);
                numeroMovimientos--;
                //tablero[coordenadaUltima.getX()][coordenadaUltima.getY()].setPosicion(numeroMovimientos);
                tablero[coordenadaUltima.getX()][coordenadaUltima.getY()].setOcupada(false);
                tablero[coordenadaUltima.getX()][coordenadaUltima.getY()].setPosicion(-1);
                
                listaMovimientos.eliminarFinal();
             
                //System.out.println("Tablero cuando retrocede");
                //System.out.println(imprimirTablero());
                posicionInicial.setX(xNueva);
                posicionInicial.setY(yNueva);
                
                //System.out.println("CAmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmbio========="+listaMovimientos.imprimirLista());
              
                
                
                //vueltaAtras(listaMovimientos, coordenadaAnterior);
            }
        }
        System.out.println("Resultado");
        return true;
    }



    
    public void eliminarPrimerMovientoPosible(int x,int y){
        tablero[x][y].eliminarMovimiento(0);
    }
    
    public Celda[][] copiarTablero(){
        Celda[][] tableroCopia = new Celda[tablero.length][tablero.length];
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                tableroCopia[i][j] = tablero[i][j];
            }
        }
        return tableroCopia;
    }
    
    public boolean hayPenultimo(){
        int count = 0;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[i][j].isOcupada() == true) {
                    count += 1;
                }
            }
        }
        if (count >= 3) {
            return true;
        } else {
            return false;
        }
    }
    
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
    //metodo solo para pruebas se puede borrar despues
    public void ponerTrue(){
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                tablero[i][j].setOcupada(true);
            }
        }
        //tablero[0][0].setOcupada(false);
    }
    
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
}
