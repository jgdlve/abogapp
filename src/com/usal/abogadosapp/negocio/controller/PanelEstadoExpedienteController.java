package com.usal.abogadosapp.negocio.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.usal.abogadosapp.negocio.dto.Ventanas;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class PanelEstadoExpedienteController extends MainController implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {	
	}
	
	
	@FXML
	private Button btnVolver;
	
	@FXML
	public void actionVolver(MouseEvent event){
		Stage stage = (Stage) btnVolver.getScene().getWindow();
		stage.close();
		super.mainApp.mostrarVentanaInterna(Ventanas.PanelExpedientes);
	}
	
	

}
