package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.model.UserModel;

public class UserDAO {

	private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost/frutapp?autoReconnect=true&useSSL=false";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";

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

	public ArrayList<UserModel> findAllUsers() {

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		ArrayList<UserModel> users = new ArrayList<UserModel>();

		try {

			conn = getConnection();

			pst = conn.prepareStatement("SELECT * FROM usuario");

			rs = pst.executeQuery();
			while (rs.next()) {

				UserModel user = new UserModel(rs.getInt("pk_usuario"), rs.getString("str_nombre_usuario"),
						rs.getString("str_pass_usuario"), rs.getString("str_email_usuario"),
						rs.getBoolean("bool_admin_usuario"));

				users.add(user);
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

		return users;

	}

	public UserModel findUserById(int id) {

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		UserModel user = new UserModel();

		try {

			conn = getConnection();

			pst = conn.prepareStatement("SELECT * FROM usuario WHERE pk_usuario = ?");

			pst.setInt(1, id);
			rs = pst.executeQuery();

			if (rs.next()) {

				user = new UserModel(rs.getInt("pk_usuario"), rs.getString("str_nombre_usuario"),
						rs.getString("str_pass_usuario"), rs.getString("str_email_usuario"),
						rs.getBoolean("bool_admin_usuario"));

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

		return user;

	}

	public UserModel findUserByEmailAndPassword(String str_email_usuario, String str_pass_usuario) {

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		UserModel user = null;

		try {

			conn = getConnection();

			pst = conn.prepareStatement("SELECT * FROM usuario WHERE str_email_usuario = ? AND str_pass_usuario = ?");

			pst.setString(1, str_email_usuario);
			pst.setString(2, str_pass_usuario);
			rs = pst.executeQuery();

			if (rs.next()) {

				user = new UserModel(rs.getInt("pk_usuario"), rs.getString("str_nombre_usuario"),
						rs.getString("str_pass_usuario"), rs.getString("str_email_usuario"),
						rs.getBoolean("bool_admin_usuario"));

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

		return user;

	}

	public UserModel findUserByEmail(String str_email_usuario) {

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		UserModel user = new UserModel();

		try {

			conn = getConnection();

			pst = conn.prepareStatement("SELECT * FROM usuario WHERE str_email_usuario = ?");

			pst.setString(1, str_email_usuario);
			rs = pst.executeQuery();

			if (rs.next()) {

				user = new UserModel(rs.getInt("pk_usuario"), rs.getString("str_nombre_usuario"),
						rs.getString("str_pass_usuario"), rs.getString("str_email_usuario"),
						rs.getBoolean("bool_admin_usuario"));

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

		return user;

	}

	public UserModel createUser(String str_nombre_usuario, String str_pass_usuario, String str_email_usuario,
			Boolean bool_admin_usuario) {

		Connection conn = null;
		PreparedStatement pstInsert = null;
		PreparedStatement pstSelect = null;
		ResultSet rs = null;

		UserModel user = null;

		try {

			conn = getConnection();

			pstInsert = conn.prepareStatement(
					"INSERT INTO usuario(str_nombre_usuario, str_pass_usuario, str_email_usuario, bool_admin_usuario) VALUES(?, ?, ?, ?)");

			pstInsert.setString(1, str_nombre_usuario);
			pstInsert.setString(2, str_pass_usuario);
			pstInsert.setString(3, str_email_usuario);
			pstInsert.setBoolean(4, bool_admin_usuario);

			if (pstInsert.executeUpdate() == 1) {

				pstSelect = conn.prepareStatement("SELECT * FROM usuario WHERE str_email_usuario = ?");

				pstSelect.setString(1, str_email_usuario);
				rs = pstSelect.executeQuery();

				if (rs.next()) {

					user = new UserModel(rs.getInt("pk_usuario"), rs.getString("str_nombre_usuario"),
							rs.getString("str_pass_usuario"), rs.getString("str_email_usuario"),
							rs.getBoolean("bool_admin_usuario"));

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

		return user;

	}

	public Boolean updateUser(UserModel user) {

		Connection conn = null;
		PreparedStatement pst = null;

		Boolean updated = false;

		try {

			conn = getConnection();

			pst = conn.prepareStatement(
					"UPDATE usuario SET str_nombre_usuario = ?, str_pass_usuario = ?, str_email_usuario = ?, bool_admin_usuario = ? WHERE pk_usuario = ?");

			pst.setString(1, user.getStr_nombre_usuario());
			pst.setString(2, user.getStr_pass_usuario());
			pst.setString(3, user.getStr_email_usuario());
			pst.setBoolean(4, user.getBool_admin_usuario());
			pst.setInt(5, user.getPk_usuario());

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

	public Boolean deleteUser(UserModel user) {

		Connection conn = null;
		PreparedStatement pst = null;

		Boolean deleted = false;

		try {

			conn = getConnection();

			pst = conn.prepareStatement("DELETE FROM usuario WHERE pk_usuario = ?");

			pst.setInt(1, user.getPk_usuario());

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
