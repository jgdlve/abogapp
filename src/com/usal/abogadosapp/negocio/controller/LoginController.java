package com.usal.abogadosapp.negocio.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import com.usal.abogadosapp.negocio.dao.interfaces.UsuarioInterface;
import com.usal.abogadosapp.negocio.dto.Usuario;
import com.usal.abogadosapp.negocio.impl.UsuarioImplementacionJDBC;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoginController extends MainController implements Initializable{
	
	@FXML
	private Text actiontarget;

	@FXML
	private TextField txtUsuario;
	@FXML
	private TextField txtPassw;
    
    @FXML
    private void loginAction(ActionEvent event) {
    	UsuarioInterface usuario = new UsuarioImplementacionJDBC();
    	try {
			Usuario us = usuario.leer(txtUsuario.getText(),txtPassw.getText());
			if(us!=null){
				super.mainApp.initPanelPrincipal();
			}else{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("Error de identificacion");
				alert.setContentText("Usuario no existente");
				alert.showAndWait();
//				actiontarget.setText("Usuario no existente");
			}
		} catch (SQLException e ) {
			actiontarget.setText("Error en la conexion");
		}  catch(NullPointerException ex){
			actiontarget.setText("Error en la conexion");
		}
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

}
