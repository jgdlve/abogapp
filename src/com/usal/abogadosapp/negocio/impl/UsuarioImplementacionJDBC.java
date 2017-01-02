package com.usal.abogadosapp.negocio.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.usal.abogadosapp.connection.ConnectionMYSQL;
import com.usal.abogadosapp.negocio.dao.interfaces.UsuarioInterface;
import com.usal.abogadosapp.negocio.dto.Usuario;

public class UsuarioImplementacionJDBC implements UsuarioInterface{
	
	private ConnectionMYSQL objCon = new ConnectionMYSQL();

	@Override
	public Usuario leer(String u,String p) {
		
		Usuario obj = null;
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;		
		String strQuery = "SELECT * FROM usuarios WHERE usuario=? AND contraseña=?";
		try {
			con = objCon.getConn();	
			st =con.prepareStatement(strQuery);
			st.setString(1, u);
			st.setString(2, p);
			rs = st.executeQuery();
			
			while(rs.next()) {
				obj = new Usuario(rs.getInt("id"),rs.getString("usuario"),rs.getString("contraseña"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(st != null){
					st.close();
				}				
				if(con != null) {
					con.close();
				}				
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
		return obj;
	}

}
