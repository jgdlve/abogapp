package com.usal.abogadosapp.application;
	
import java.io.IOException;

import com.usal.abogadosapp.negocio.controller.LoginController;
import com.usal.abogadosapp.negocio.controller.MainController;
import com.usal.abogadosapp.negocio.controller.PanelPrincipalController;
import com.usal.abogadosapp.negocio.dto.Ventanas;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class Main extends Application {
	
	private Stage ventanaPrincipal;  // stage principal
	private Stage ventanaLogin;		// stage secundario para login
	private BorderPane panelPrincipal;		
	private GridPane panelLogin;
	
	public Main(){
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	// punto de inicio de la app
	// paramtero Stage es la ventana principal
	//
	@Override
	public void start(Stage ventanaPrincipal) throws Exception {
		
		this.ventanaPrincipal = ventanaPrincipal;
		this.ventanaPrincipal.setTitle(Ventanas.VentanaPrincipal.getTitle());
		this.ventanaPrincipal.setMaximized(true);
		initLogin();
	
	}
	
	public void initLogin(){
		
		try {
			ventanaLogin = new Stage();
			ventanaLogin.setMinHeight(500);
			ventanaLogin.setMinWidth(500);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(Ventanas.Login.getPath()));
            panelLogin = (GridPane) loader.load();

            LoginController controller = loader.getController();
            controller.setMainApp(this);

            Scene scene = new Scene(panelLogin);
            ventanaLogin.setScene(scene);
            ventanaLogin.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public void initPanelPrincipal() {
        try {
        	ventanaLogin.close();
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(Ventanas.VentanaPrincipal.getPath()));
            panelPrincipal = (BorderPane) loader.load();
            
            PanelPrincipalController controllerPpal = loader.getController();
    		controllerPpal.setMainApp(this);
            // Show the scene containing the root layout.
            Scene scene = new Scene(panelPrincipal);
            ventanaPrincipal.setScene(scene);
            ventanaPrincipal.show();
            ventanaPrincipal.setResizable(false);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }	
	
	public Stage getPrimaryStage() {
        return ventanaPrincipal;
    }
	
	public void mostrarVentanaInterna(Ventanas ventana) {
        if (!ventana.getIsopen()) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(ventana.getPath()));
                AnchorPane contactABM = (AnchorPane) loader.load();
                int minWidth = 900;
                int minHeight = 600;
                MainController controller = loader.getController();
                controller.setMainApp(this);

                Stage internalStage = new Stage();
                internalStage.setTitle(ventana.getTitle());
                internalStage.initModality(Modality.WINDOW_MODAL);
                internalStage.initOwner(ventanaPrincipal);
                internalStage.setMinWidth(minWidth);
                internalStage.setMinHeight(minHeight);
                
                Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
                internalStage.setX((screenBounds.getWidth() - minWidth) / 2); 
                internalStage.setY((screenBounds.getHeight() - minHeight) / 2); 
                
                Scene scene = new Scene(contactABM);
                internalStage.setScene(scene);
                internalStage.show();
                
                ventana.setIsopen(true);
                internalStage.setOnHidden((WindowEvent we) -> {
                    ventana.setIsopen(false);
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
	
	
	
}
