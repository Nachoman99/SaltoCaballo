/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saltocaballo;

/**
 *
 * @author Nacho
 */
public class SaltoCaballo {

    /**
     * Main
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Tablero tablero = new Tablero();
        tablero.posiblesMoviemientos();
        tablero.posiblesMovimientosEspecifico(2, 2);
    }
    
}
