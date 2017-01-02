package com.usal.abogadosapp.negocio.controller;

import java.net.URL;
import java.util.ResourceBundle;
import com.usal.abogadosapp.negocio.dto.Ventanas;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


public class PanelPrincipalController extends MainController implements Initializable {
	
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void abrirVentanaLogin(ActionEvent event) {
        super.mainApp.mostrarVentanaInterna(Ventanas.Login);
    }
    
    @FXML
    private void abrirVentanaPrincipal(ActionEvent event) {
        super.mainApp.mostrarVentanaInterna(Ventanas.VentanaPrincipal);
    }
    
    @FXML
    private void abrirVentanaEmpleados(ActionEvent event) {
        super.mainApp.mostrarVentanaInterna(Ventanas.PanelAbogados);
    }
    
    @FXML
    private void abrirVentanaExpedientes(ActionEvent event) {
        super.mainApp.mostrarVentanaInterna(Ventanas.PanelExpedientes);
    }
    
    

    
    @FXML
    private void salir(ActionEvent event) {
        Platform.exit();
    }

}
