/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author fernandopucci
 */
public class InvalidMapException extends Exception {

    public InvalidMapException(String mensagem) {

        super("Mapa Inválido! " + mensagem);

    }

}
