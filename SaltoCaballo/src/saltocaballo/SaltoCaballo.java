/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saltocaballo;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Nacho
 */
public class SaltoCaballo {

    /**
     * Main
     */
    public static void main(String[] args) {

        Tablero tablero = new Tablero();
//System.out.println(tablero.imprimirTablero());
        tablero.posiblesMovimientos();
        Coordenada coordenada = new Coordenada(0, 0);
        Lista lista = new Lista();
        tablero.vueltaAtras(lista, coordenada);
        System.out.println(tablero.imprimirTablero());
        //tablero.posiblesMovimientosEspecifico(3, 0);
//        System.out.println("Esta lista= "+tablero.tableroListo());
  //      tablero.ponerTrue();
    //    System.out.println("Esta lista= "+tablero.tableroListo());
//        boolean salir = false;
//        while (salir == false) {
//            int opcion;
//            opcion = Integer.parseInt(JOptionPane.showInputDialog("Por favor elija una de las siguientes opciones: \n"
//                    + "1) Insertar tamaño de la matriz \n"
//                    + "2) Elegir coordenadas de salida \n"
//                    + "3) Calcular recorrido \n"
//                    + "4) Mostrar el tiempo de duración del cálculo del recorrido \n"
//                    + "5) Imprimir la matriz y el recorrido \n"
//                    + "6) Salir del programa"));
//            switch(opcion){
//                case 1:
//                    
//                    break;
//                case 2:
//                    
//                    break;
//                case 3:
//                    
//                    break;
//                case 4:
//                    
//                    break;
//                    
//                case 5:
//                    
//                    break;
//                case 6:
//                    JOptionPane.showMessageDialog(null, "Hasta pronto");
//                    salir = true;
//                    break;
//            }
//        }
    }  
}
