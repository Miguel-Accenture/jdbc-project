package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.model.ElementoModel;
import com.model.UserModel;

public class ElementoDAO {

	private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost/frutapp?autoReconnect=true&useSSL=false";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "MyNewPassword";

	private Connection getConnection() {

		Connection conn = null;

		try {

			Class.forName(DB_DRIVER);
			conn = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;

	}

	public ArrayList<ElementoModel> findAllElemento() {

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		ArrayList<ElementoModel> elementos = new ArrayList<ElementoModel>();

		try {

			conn = getConnection();

			pst = conn.prepareStatement("SELECT * FROM elemento");

			rs = pst.executeQuery();
			while (rs.next()) {

				ElementoModel elemento = new ElementoModel(rs.getInt("pk_elemento"),
						rs.getString("str_nombre_elemento"));

				elementos.add(elemento);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				if (pst != null)
					pst.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return elementos;

	}

	public ElementoModel findElementoById(int id) {

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		ElementoModel elemento = new ElementoModel();

		try {

			conn = getConnection();

			pst = conn.prepareStatement("SELECT * FROM elemento WHERE pk_elemento = ?");

			pst.setInt(1, id);
			rs = pst.executeQuery();

			if (rs.next()) {

				elemento = new ElementoModel(rs.getInt("pk_elemento"), rs.getString("str_nombre_elemento"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				if (pst != null)
					pst.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return elemento;

	}

	public ElementoModel createElemento(String str_nombre_elemento) {

		Connection conn = null;
		PreparedStatement pstInsert = null;
		PreparedStatement pstSelect = null;
		ResultSet rs = null;

		ElementoModel elemento = null;

		try {

			conn = getConnection();

			pstInsert = conn.prepareStatement("INSERT INTO elemento(str_nombre_elemento) VALUES(?)");

			pstInsert.setString(1, str_nombre_elemento);

			if (pstInsert.executeUpdate() == 1) {

				pstSelect = conn.prepareStatement("SELECT * FROM elemento WHERE str_nombre_elemento = ?");

				pstSelect.setString(1, str_nombre_elemento);
				rs = pstSelect.executeQuery();

				if (rs.next()) {

					elemento = new ElementoModel(rs.getInt("pk_elemento"), rs.getString("str_nombre_elemento"));
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstInsert != null)
					pstInsert.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				if (pstSelect != null)
					pstSelect.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return elemento;

	}

	public Boolean updateElemento(ElementoModel elemento) {

		Connection conn = null;
		PreparedStatement pst = null;

		Boolean updated = false;

		try {

			conn = getConnection();

			pst = conn.prepareStatement("UPDATE elemento SET str_nombre_elemento = ?");

			pst.setString(1, elemento.getStr_nombre_elemento());

			if (pst.executeUpdate() == 1) {
				updated = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (pst != null)
					pst.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return updated;

	}

	public Boolean deleteElemento(ElementoModel elemento) {

		Connection conn = null;
		PreparedStatement pst = null;

		Boolean deleted = false;

		try {

			conn = getConnection();

			pst = conn.prepareStatement("DELETE FROM elemento WHERE pk_elemento = ?");

			pst.setInt(1, elemento.getPk_elemento());

			if (pst.executeUpdate() == 1) {
				deleted = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (pst != null)
					pst.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return deleted;

	}

	public Boolean deleteElement(ElementoModel elemento) {

		Connection conn = null;
		PreparedStatement pst = null;

		Boolean deleted = false;

		try {

			conn = getConnection();

			pst = conn.prepareStatement("DELETE FROM elemento WHERE str_nombre_elemento = ?");

			pst.setString(1, elemento.getStr_nombre_elemento());

			if (pst.executeUpdate() == 1) {
				deleted = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (pst != null)
					pst.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return deleted;

	}

}
