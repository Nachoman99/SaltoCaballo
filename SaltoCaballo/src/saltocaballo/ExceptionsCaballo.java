/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saltocaballo;

/**
 * Esta clase se encarga del manejo de las excepciones
 * @version 27/04/2019
 * @author Kevin Trejos
 */
public class ExceptionsCaballo extends Exception{

    /**
     * Constructor para excepciones personalizadas
     * @param mensaje mensaje a mostrar
     */
    public ExceptionsCaballo(String mensaje) {
        super(mensaje);
    }   
}
