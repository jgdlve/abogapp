package com.usal.abogadosapp.negocio.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.usal.abogadosapp.connection.ConnectionMYSQL;
import com.usal.abogadosapp.negocio.dao.interfaces.ExpedienteInterface;
import com.usal.abogadosapp.negocio.dto.Expediente;

public class ExpedienteImplementacionJDBC implements ExpedienteInterface {
	
	private ConnectionMYSQL objCon = new ConnectionMYSQL();
	
	@Override
	public Expediente buscarXnum(String num) {
		
		Expediente exp = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			
			con = objCon.getConn();
			String query ="SELECT * FROM expedientes WHERE numero=?";
			st =con.prepareStatement(query);
			st.setString(1, num);
			rs = st.executeQuery();	
			while(rs.next()) {
				exp=new Expediente();
				exp.setNumero(rs.getString("numero"));
				exp.setTitulo(rs.getString("titulo"));
				exp.setActor(rs.getString("actor"));
				exp.setObjeto(rs.getString("objeto"));
				exp.setFecha(rs.getDate("fecha"));
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	
		return exp;
	}

}
