package com.usal.abogadosapp.negocio.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.usal.abogadosapp.application.Main;
import com.usal.abogadosapp.negocio.dto.Abogado;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class PanelAbogadosController extends MainController implements Initializable{
	
	private ObservableList<Abogado> listaAbogados = FXCollections.observableArrayList();
	
    @FXML
    private TableView<Abogado> tablaAbogados;
    @FXML
    private TableColumn<Abogado, String> nombre;
    @FXML
    private TableColumn<Abogado, String> apellido;
    @FXML
    private TableColumn<Abogado, String> cuit;
    @FXML
    private TableColumn<Abogado, String> direccion;
    @FXML
    private TableColumn<Abogado, String> telefono;
    
    @FXML
    private Button btnAgregar;
    @FXML
    private Button btnModificar;
    @FXML
    private Button btnEliminar;
    
    @FXML
    private TextField txtCuit;
    @FXML
    private TextField txtNombre;

    public PanelAbogadosController() {
    	this.leer();
    }

    private void leer() {
		
    	listaAbogados.add(new Abogado(1,"20-32323232-5","Joshua", "de la Vega"));
    	listaAbogados.add(new Abogado(2,"20-32323232-5","Agustina", "Lombardo"));
    	listaAbogados.add(new Abogado(3,"20-32323232-5","Kevin", "de la Vega"));
		
	}
    
    public void cargarTabla(){
        tablaAbogados.setItems(this.getPersonData());
    }
    
    @FXML
    private void btnAgregarAction(ActionEvent event) {
        // Button was clicked, do something...
    	System.out.println("se presiono el boton agregar");
        
    }
    @FXML
    private void btnModificarAction(ActionEvent event) {
        // Button was clicked, do something...
    	System.out.println("se presiono el boton modificar");
        
    }
    @FXML
    private void btnEliminarAction(ActionEvent event){
    	System.out.println("se presiono el boton eliminar");
    }
    
    public ObservableList<Abogado> getPersonData() {
        return listaAbogados;
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		nombre.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        apellido.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        cuit.setCellValueFactory(cellData -> cellData.getValue().cuitProperty());
        direccion.setCellValueFactory(cellData -> cellData.getValue().streetProperty());
        telefono.setCellValueFactory(cellData -> cellData.getValue().telefonoProperty());
        btnAgregar.setOnAction(this::btnAgregarAction);
        btnModificar.setOnAction(this::btnModificarAction);
        btnEliminar.setOnAction(this::btnEliminarAction);
        txtCuit.setDisable(true);
        txtNombre.setDisable(true);
	}
}