package com.usal.abogadosapp.negocio.controller;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import com.usal.abogadosapp.negocio.dao.interfaces.ExpedienteInterface;
import com.usal.abogadosapp.negocio.dto.Expediente;
import com.usal.abogadosapp.negocio.dto.Ventanas;
import com.usal.abogadosapp.negocio.impl.ExpedienteImplementacionJDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PanelExpedientesController extends MainController implements Initializable{
	
	private ObservableList<Expediente> listaExpedientes = FXCollections.observableArrayList();
	
	@FXML
	private Text targetBuscar;
	@FXML
	private TableColumn<Expediente, String> numero;
    @FXML
    private TableColumn<Expediente, String> titulo;
    @FXML
    private TableColumn<Expediente, String> actor;
    @FXML
    private TableColumn<Expediente, String> objeto;
    @FXML
    private TableColumn<Expediente, Date> fecha;
	@FXML
	private ComboBox<String> comboBuscar;
	@FXML
	private TextField txtBuscar;
	@FXML
	private TableView<Expediente> tablaExpedientes;
	@FXML
	private Button btnBuscar;
	
	private ObservableList<String> buscarList = FXCollections.observableArrayList("Nº Expediente","Actor");
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comboBuscar.setValue("Nº Expediente");
		comboBuscar.setItems(buscarList);
	}
	
	@FXML
	public void clickItem(MouseEvent event){
		if (event.getClickCount() == 2) {
			Stage stage = (Stage) txtBuscar.getScene().getWindow();
	        stage.close();
	        super.mainApp.mostrarVentanaInterna(Ventanas.PanelEstadoExpediente);
		}
	}
	
	@FXML
	private void buscar(ActionEvent event){
		ExpedienteInterface exp = new ExpedienteImplementacionJDBC();
		Expediente e=exp.buscarXnum(txtBuscar.getText());
		if(e!=null){
			listaExpedientes.add(e);
			this.cargarTabla();
		}else{
			targetBuscar.setText("no existe el expediente");
		}
	}
	
	private void cargarTabla(){
		numero.setCellValueFactory(new PropertyValueFactory<Expediente, String>("numero"));
        titulo.setCellValueFactory(new PropertyValueFactory<Expediente, String>("titulo"));
        actor.setCellValueFactory(new PropertyValueFactory<Expediente, String>("actor"));
        objeto.setCellValueFactory(new PropertyValueFactory<Expediente, String>("objeto"));
        fecha.setCellValueFactory(new PropertyValueFactory<Expediente, Date>("fecha"));
        tablaExpedientes.setItems(this.getExpedientes());
	}
	
	private ObservableList<Expediente> getExpedientes() {
        return listaExpedientes;
    }
	
	

}
