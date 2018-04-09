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
public class Temperatura {
	
	private double stopnie;
	private char skala;
		
	public Temperatura( double st, char sk ) throws NoSuchScaleException, TooLowTemperatureException {
		
		if( weryfikujSkale( sk ) ) {
			if( weryfikujStopnie( st, sk ) ) {
				stopnie = st;
				skala = sk;
			} else {
				throw new TooLowTemperatureException();
			}		
		} else {
			throw new NoSuchScaleException();
		}
		
	}
	
	public double ileStopni() {
		
		return stopnie;
		
	}
	
	public void konwertuj ( char sk ) throws NoSuchScaleException {
		
		if( weryfikujSkale( sk ) ) {
			switch (skala) {
				case 'C':
					if( sk == 'F' ) {
						stopnie = stopnie * 1.8 + 32;
					} else if ( sk == 'K' ) {
						stopnie = stopnie + 273.15;
					}	break;
				case 'F':
					if( sk == 'C' ) {
						stopnie = ( stopnie - 32 ) / 1.8;
					} else if ( sk == 'K' ) {
						stopnie = ( stopnie + 459.67 ) / 1.8;
					}	break;
				case 'K':
					if( sk == 'C' ) {
						stopnie = stopnie - 273.15;
					} else if( sk == 'F' ) {
						stopnie = stopnie / 1.8 - 459.67;
					}	break;
				default:
					break;
			}
			skala = sk;
		} else {
			throw new NoSuchScaleException();
		}

	}
	
	private boolean weryfikujSkale( char sk ) {
		return sk == 'C' || sk == 'F' || sk == 'K';
	}
	
	private boolean weryfikujStopnie( double st, char sk ) {
		return !(( sk == 'C' && st < -273.15 ) || ( sk == 'F' && st < -459.67 ) || ( sk == 'K' && st < 0 ));
	}
	
}