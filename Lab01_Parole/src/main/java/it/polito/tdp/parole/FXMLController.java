package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;
import it.polito.tdp.parole.model.ParoleConListe;

import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	ParoleConListe elenco ;
	boolean primaParola=true;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;
    
    @FXML
    private TextArea txtTempo;

    @FXML
    void doInsert(ActionEvent event) {
    	long startTime=System.nanoTime();
    	String par=txtParola.getText();
    	txtParola.setText("");
    	if(par.compareTo("")==0)
    		return;
    	if(!par.matches("[a-zA-Z ]+"))
    		return;
    	elenco.addParola(par);
    	List<String> lista= elenco.getElenco();
    	txtResult.clear();
    	for(String p:lista) {
    		txtResult.appendText(p+"\n");
    		} 
    	long tempoEsecuzione=(System.nanoTime()-startTime)/1000;
    	txtTempo.setText("Tempo di esecuzione: "+tempoEsecuzione+" microsecondi");
    }

    @FXML
    void doReset(ActionEvent event) {
    	long startTime=System.nanoTime();
    	txtResult.clear();
    	elenco.reset();
    	long tempoEsecuzione=(System.nanoTime()-startTime)/1000;
    	txtTempo.setText("Tempo di esecuzione: "+tempoEsecuzione+" microsecondi");
    }

    @FXML
    void doCancella(ActionEvent event) {
    	long startTime=System.nanoTime();
    	String par=txtResult.getSelectedText();
    	elenco.removeParola(par);
    	txtResult.clear();
    	List<String> lista=elenco.getElenco();
    	for(String p:lista) {
    		txtResult.appendText(p+"\n");
    		} 	
    	long tempoEsecuzione=(System.nanoTime()-startTime)/1000;
    	txtTempo.setText("Tempo di esecuzione: "+tempoEsecuzione+" microsecondi");
    }
    
    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new ParoleConListe() ;
    }
}
