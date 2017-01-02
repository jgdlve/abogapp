package com.usal.abogadosapp.negocio.dao.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;
import com.usal.abogadosapp.negocio.dto.Abogado;

public interface AbogadoInterface {
	
	public abstract ArrayList<Abogado> leer() throws SQLException;
	public abstract boolean guardar(Abogado ab);
	public abstract boolean modificar(Abogado ab);
	public abstract boolean eliminar(Abogado ab);

}
