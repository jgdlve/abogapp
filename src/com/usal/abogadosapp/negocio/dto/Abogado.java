package com.usal.abogadosapp.negocio.dto;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Abogado {

	private final IntegerProperty id;
	private final StringProperty cuit;
    private final StringProperty nombre;
    private final StringProperty apellido;
    private final StringProperty direccion;
    private final StringProperty telefono;

    
    public Abogado(int id, String cuit, String nom, String ap) {
    	this.id = new SimpleIntegerProperty(id);
    	this.cuit = new SimpleStringProperty(cuit);
        this.nombre = new SimpleStringProperty(nom);
        this.apellido = new SimpleStringProperty(ap);
        this.telefono = new SimpleStringProperty("47997654");
        // Some initial dummy data, just for convenient testing.
        this.direccion = new SimpleStringProperty("some street");
    }

    public String getFirstName() {
        return nombre.get();
    }

    public void setFirstName(String firstName) {
        this.nombre.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return nombre;
    }

    public String getLastName() {
        return apellido.get();
    }

    public void setLastName(String lastName) {
        this.apellido.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return apellido;
    }

    public String getStreet() {
        return direccion.get();
    }

    public void setStreet(String street) {
        this.direccion.set(street);
    }

    public StringProperty streetProperty() {
        return direccion;
    }

	public final IntegerProperty idProperty() {
		return this.id;
	}
	

	public final int getId() {
		return this.idProperty().get();
	}
	

	public final void setId(int id) {
		this.idProperty().set(id);
	}
	

	public final StringProperty cuitProperty() {
		return this.cuit;
	}
	

	public final String getCuit() {
		return this.cuitProperty().get();
	}
	

	public final void setCuit(String cuit) {
		this.cuitProperty().set(cuit);
	}

	public final StringProperty telefonoProperty() {
		return this.telefono;
	}
	

	public final String getTelefono() {
		return this.telefonoProperty().get();
	}
	

	public final void setTelefono(String telefono) {
		this.telefonoProperty().set(telefono);
	}
	
	
}
