/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konwertertemperatur;

/**
 *
 * @author Tallos
 */
public class NoSuchScaleException extends Exception {
	
	public NoSuchScaleException() {
		System.out.println( "Wyjątek: Nie ma takiej skali." );
	}
	
}
