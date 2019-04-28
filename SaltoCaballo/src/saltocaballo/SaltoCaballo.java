/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saltocaballo;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showInputDialog;

/**
 * Esta es la clase main donde se crea un menu para que el usuario utilize diferentes metodos de otras clases
 * @version 27/04/2019
 * @author Jose Ignacio
 */
public class SaltoCaballo {

    /**
     * Main
     */
    public static void main(String[] args) throws ExceptionsCaballo {

        int salirX;
        int tamaño = 0;
        String tamañoString;
        boolean salir = false;
        Tablero tablero = new Tablero();
        int coordenadaX;
        int coordenadaY;
        long t1;
        long t2;
        double tiempo = 0;
        boolean continuar = false;
        boolean proceso = false;
        boolean coordenadas = false;
        Coordenada coordenadaInicial = new Coordenada();
        boolean solucion = true;
        
        while (salir == false) {
            String opcionString = JOptionPane.showInputDialog("Por favor elija una de las siguientes opciones: \n"
                + "1) Insertar tamaño de la matriz \n"
                + "2) Elegir coordenadas de inicio \n"
                + "3) Calcular recorrido \n"
                + "4) Mostrar el tiempo de duración del cálculo del recorrido \n"
                + "5) Imprimir la matriz y el recorrido \n"
                + "6) Salir del programa");
            int opcion=-1;
            if (opcionString == null || opcionString.equals("")) {
                if (opcionString == null) {
                    salirX = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea salir?", "SALIR", JOptionPane.YES_NO_OPTION);
                    if (salirX == 0) {
                        salir = true;
                    }else{
                        salir = false;
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Por favor ingrese algún valor");
                    salir = false;
                }
            }else{
                opcion = Integer.parseInt(opcionString);
            }   
            if (opcionString != null && opcion > 0 && opcion <= 6) {
                switch(opcion){
                    case 1:
                        continuar = false;
                        tamañoString = JOptionPane.showInputDialog("Digite el tamaño de la matriz");
                        if (tamañoString != null) {
                            tamaño = Integer.parseInt(tamañoString);
                            try {
                                tablero = new Tablero(tamaño);
                            } catch (ExceptionsCaballo e) {
                                JOptionPane.showMessageDialog(null, e.getMessage());
                            }
                            continuar = true;
                        }else{
                        continuar = false;
                        }
                    break;
                    case 2:
                        proceso = false;
                        coordenadas = false;
                        if (continuar == true) {
                            coordenadas = false;
                            String str = JOptionPane.showInputDialog("Digite la coordenada X a iniciar");
                            String str2 = JOptionPane.showInputDialog("Digite la coordenada Y a iniciar");
                            try {
                                coordenadaInicial = tablero.CoordenadasInt(str, str2, tamaño);
                                coordenadas = true;
                                tablero = new Tablero(tamaño);
                            } catch (ExceptionsCaballo e) {
                                JOptionPane.showMessageDialog(null, e.getMessage());
                            }
                            
                        }else{
                        JOptionPane.showMessageDialog(null, "Por favor digite el tamaño de la matriz primero");
                        }
                        break;
                    case 3:
                        if (coordenadas == true) {
                            try {
                                tablero = new Tablero(tamaño);
                            } catch (ExceptionsCaballo e) {
                                JOptionPane.showMessageDialog(null, e.getMessage());
                            }
                            
                            tablero.posiblesMovimientos();
                            t1 = System.nanoTime();
                            solucion = tablero.vueltaAtras(coordenadaInicial);
                            t2 = System.nanoTime();
                            tiempo = (double) (t2 - t1) / 1000000000;
                            proceso = true;
                        }else{
                            proceso = false;
                            JOptionPane.showMessageDialog(null, "Por favor digite las coordenadas de inicio primero");
                        }
                        break;
                    case 4:
                        if (proceso == true) {
                            JOptionPane.showMessageDialog(null, "La duración del recorrido en segundos es: " + tiempo); 
                        }else{
                            JOptionPane.showMessageDialog(null, "Antes de mostrar el tiempo de ejecución por favor\n"
                                    + "calcule recorrido primero");
                        }
                        break;
                    case 5:
                        if (proceso == true) {
                            if (solucion == true) {
                                JOptionPane.showMessageDialog(null, "El recorrido es: \n" + tablero.getListaMovimientos());
                                JOptionPane.showMessageDialog(null, "La matriz resuelta es: \n\n" + tablero.imprimirTablero());
                            }else{
                                JOptionPane.showMessageDialog(null, "La coordenada elegida no tiene solución");
                            }  
                        }else{
                            JOptionPane.showMessageDialog(null, "Por favor antes de mostrar el tablero elija la opción 3");
                        }
                        break;
                    case 6:
                        JOptionPane.showMessageDialog(null, "Hasta pronto");
                        salir = true;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Toco la X");
                        salir = true;
                        break;
                }  
            }    
        }  
    }  
}
