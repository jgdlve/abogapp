package com.usal.abogadosapp.negocio.dto;

public class Usuario {
	
	private int id;
	private String usuario;
	private String passw;
	
	public Usuario(int id, String us, String passw){
		this.id=id;
		this.usuario=us;
		this.passw=passw;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassw() {
		return passw;
	}
	public void setPassw(String passw) {
		this.passw = passw;
	}
	
	

}
