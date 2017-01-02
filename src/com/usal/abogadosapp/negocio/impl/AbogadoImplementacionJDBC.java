package com.usal.abogadosapp.negocio.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.usal.abogadosapp.connection.ConnectionMYSQL;
import com.usal.abogadosapp.negocio.dao.interfaces.AbogadoInterface;
import com.usal.abogadosapp.negocio.dto.Abogado;

public class AbogadoImplementacionJDBC implements AbogadoInterface{
	
	private ConnectionMYSQL objCon = new ConnectionMYSQL();

	@Override
	public ArrayList<Abogado> leer() {
		
		ArrayList<Abogado> listaRetorno = null;
		Abogado obj = null;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;		
		String strQuery = "SELECT * FROM abogados";
		try {
			con = objCon.getConn();
			st = con.createStatement();
			rs = st.executeQuery(strQuery);			
			while(rs.next()) {
				obj = new Abogado(rs.getInt("id"),rs.getString("cuit"),rs.getString("nombre"),rs.getString("apellido"));
				if(listaRetorno == null) {
					listaRetorno = new ArrayList<Abogado>();
				}
				listaRetorno.add(obj);
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
		return listaRetorno;
	}

	@Override
	public boolean guardar(Abogado obj) {
		String strQuery = "INSERT INTO abogados (nombre, apellido, cuit, telefono, direccion) VALUES (?, ?, ?, ?, ?)";
		Connection con = null;
		Statement st = null;
		PreparedStatement pst = null;
		try {
			con = objCon.getConn();
			con.setAutoCommit(false);
			st = con.createStatement();		
			pst = con.prepareStatement(strQuery);
			pst.setString(1, obj.getFirstName().trim());
			pst.setString(2, obj.getLastName().trim());
			pst.setString(3, obj.getCuit().trim());
			pst.setString(4, obj.getTelefono().trim());
			pst.setString(5, obj.getStreet().trim());
			pst.executeUpdate();
			con.commit();			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				con.rollback();
				return false;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}			
		} finally {
			try {
				if(st != null){
					st.close();
				}
				if(pst != null) {
					pst.close();
				}
				if(con != null) {
					con.close();
				}				
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
		return true;
	}

	@Override
	public boolean modificar(Abogado obj) {
		String strQuery = "UPDATE abogados SET nombre = ?, apellido = ?, cuit = ?, telefono = ?, direccion = ?"
				+ " WHERE cuit = ?";
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = objCon.getConn();
			con.setAutoCommit(false);
			pst = con.prepareStatement(strQuery);			
			pst.setString(1, obj.getFirstName().trim());
			pst.setString(2, obj.getLastName().trim());
			pst.setString(3, obj.getCuit().trim());
			pst.setString(4, obj.getTelefono().trim());
			pst.setString(5, obj.getStreet().trim());
			pst.setString(6, obj.getCuit().trim());
			pst.executeUpdate();
			con.commit();			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				con.rollback();
				return false;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}			
		} finally {
			try {				
				if(pst != null) {
					pst.close();
				}
				if(con != null) {
					con.close();
				}				
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
		return true;
	}

	@Override
	public boolean eliminar(Abogado obj) {
		Connection con = null;
		PreparedStatement pst = null;
		String strQuery = "DELETE FROM abogados WHERE cuit = ?";
		try {
			con = objCon.getConn();
			con.setAutoCommit(false);
			pst = con.prepareStatement(strQuery);				
			pst.setString(1, obj.getCuit().trim());
			pst.executeUpdate();
			con.commit();			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}			
		} finally {
			try {				
				if(pst != null) {
					pst.close();
				}
				if(con != null) {
					con.close();
				}				
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
		return true;
		
	}

}
