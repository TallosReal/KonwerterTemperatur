/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konwertertemperatur;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 *
 * @author Tallos
 */
public class FXMLDocumentController implements Initializable {
	
	@FXML
	public TextField wejSt, wyjSt;
	public RadioButton wejCel, wejFahr, wejKel, wyjCel, wyjFahr, wyjKel;
	
	private char skWej, skWyj;
	private double stWej;
		
	private final DecimalFormat formater = new DecimalFormat( "###.## ");
	 	
	@FXML
	private void konwertujTemperature( ActionEvent event ) {
		
		if( wejCel.isSelected() ) { skWej = 'C'; }
		else if ( wejFahr.isSelected() ) { skWej = 'F'; }
		else if ( wejKel.isSelected() ) { skWej = 'K'; }
		else { skWej = ' '; }

		if( wyjCel.isSelected() ) { skWyj = 'C'; }
		else if ( wyjFahr.isSelected() ) { skWyj = 'F'; }
		else if ( wyjKel.isSelected() ) { skWyj = 'K'; }
		else { skWyj = ' '; }

		try {

			stWej = Double.parseDouble( wejSt.getText().replace( ',', '.' ) );
			Temperatura temp = new Temperatura( stWej , skWej );
			temp.konwertuj( skWyj );
			wyjSt.setText( formater.format( temp.ileStopni() ).replace( '.', ',' ) );

		} catch( NullPointerException | NumberFormatException pde ) {
			
			RadioButton[] skale = { wejCel, wejFahr, wejKel, wyjCel, wyjFahr, wyjKel };
			
			for ( RadioButton skala : skale ) {
				skala.setSelected( false );
			}
			
			wyjSt.setText( "Nie podano temperatury" );

		} catch( NoSuchScaleException nsse ) {

			wyjSt.setText( "Nie podano skali" );

		} catch ( TooLowTemperatureException tlte ) {
			
			RadioButton[] skale = { wejCel, wejFahr, wejKel };
			
			for ( RadioButton skala : skale ) {
				skala.setSelected( false );
			}
			
			wyjSt.setText( "Zbyt niska temperatura" );

		}
			
	}
	
	@Override
	public void initialize( URL url, ResourceBundle rb ) {
		// TODO
	}	
	
}
