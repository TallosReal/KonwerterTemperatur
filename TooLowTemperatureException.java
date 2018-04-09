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
public class TooLowTemperatureException extends Exception {
	
	public TooLowTemperatureException() {
		System.out.println( "Wyjątek: Temperatura poniżej 0 absolutnego!" );
	}

}