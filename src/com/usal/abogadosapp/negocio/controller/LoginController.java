package com.usal.abogadosapp.negocio.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.usal.abogadosapp.application.Main;
import com.usal.abogadosapp.negocio.dao.interfaces.UsuarioInterface;
import com.usal.abogadosapp.negocio.dto.Usuario;
import com.usal.abogadosapp.negocio.impl.UsuarioImplementacionJDBC;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoginController extends MainController implements Initializable{
	
//	@FXML
//	private Label actiontarget;
	
	@FXML
	private Text actiontarget;

	@FXML
	private TextField txtUsuario;
	@FXML
	private TextField txtPassw;

    public LoginController() {
    }

    @FXML
    private void initialize() { 	
    }
    
    @FXML
    private void loginAction(ActionEvent event) {
    	
    	UsuarioInterface usuario = new UsuarioImplementacionJDBC();
    	try {
			Usuario us = usuario.leer(txtUsuario.getText(),txtPassw.getText());
			
			if(us!=null){
				mainApp.initPanelPrincipal();
			}else{
//				Alert alert = new Alert(AlertType.ERROR);
//				alert.setTitle("Error");
//				alert.setHeaderText("Error de identificacion");
//				alert.setContentText("Usuario no existente");
//
//				alert.showAndWait();
				actiontarget.setText("Usuario no existente");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
