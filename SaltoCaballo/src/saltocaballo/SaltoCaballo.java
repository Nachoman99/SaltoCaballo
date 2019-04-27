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
//        long t1;
//        long t2;
//        boolean solucion;
//        Tablero tablero = new Tablero();
//        //System.out.println(tablero.imprimirTablero());
//        tablero.posiblesMovimientos();
//        Coordenada coordenada = new Coordenada(0, 2);
//        t1 = System.nanoTime();
//        solucion=tablero.vueltaAtras(coordenada);
//        t2 = System.nanoTime();
//        System.out.println("\nTiempo en procesar(En nanosegundos): " + (t2 - t1));
//        
//        double conversion = (double) (t2 - t1) / 1000000000;
//        System.out.println("Tiempo en procesar(En segundos): "+conversion);
//        System.out.println("EL tablero tuvo solucion= "+solucion);
//        System.out.println(tablero.imprimirTablero());




        int tamaño;
        boolean salir = false;
        Tablero tablero = new Tablero();
        int coordenadaX;
        int coordenadaY;
        long t1;
        long t2;
        double tiempo = 0;
        Coordenada coordenadaInicial = new Coordenada();
        while (salir == false) {
            int opcion;
            opcion = Integer.parseInt(JOptionPane.showInputDialog("Por favor elija una de las siguientes opciones: \n"
                    + "1) Insertar tamaño de la matriz \n"
                    + "2) Elegir coordenadas de salida \n"
                    + "3) Calcular recorrido \n"
                    + "4) Mostrar el tiempo de duración del cálculo del recorrido \n"
                    + "5) Imprimir la matriz y el recorrido \n"
                    + "6) Salir del programa"));
            switch(opcion){
                case 1:
                    tamaño = Integer.parseInt(JOptionPane.showInputDialog("Digite el tamaño de la matriz"));
                    tablero = new Tablero(tamaño);
                    break;
                case 2:
                    coordenadaX = Integer.parseInt(JOptionPane.showInputDialog("Digite la coordenada X a iniciar"));
                    coordenadaY = Integer.parseInt(JOptionPane.showInputDialog("Digite la coordenada Y a iniciar"));
                    coordenadaInicial = new Coordenada(coordenadaX, coordenadaY);
                    break;
                case 3:
                    tablero.posiblesMovimientos();
                    t1 = System.nanoTime();
                    tablero.vueltaAtras(coordenadaInicial);
                    t2 = System.nanoTime();
                    tiempo = (double) (t2 - t1) / 1000000000;
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "La duración del recorrido en segundos es: " + tiempo);
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "La matriz resuelta es: \n\n" + tablero.imprimirTablero());
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Hasta pronto");
                    salir = true;
                    break;
            }
        }

        
    }  
}
