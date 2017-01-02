package com.usal.abogadosapp.negocio.dao.interfaces;

import java.sql.SQLException;
import com.usal.abogadosapp.negocio.dto.Usuario;

public interface UsuarioInterface {
	
	public abstract Usuario leer(String u, String p) throws SQLException,NullPointerException;
//	public abstract boolean guardar(Usuario us);
//	public abstract boolean modificar(Usuario us);
//	public abstract boolean eliminar(Usuario us);

}
