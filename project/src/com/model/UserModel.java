package com.model;

public class UserModel {

	private int pk_usuario;
	private String str_nombre_usuario;
	private String str_pass_usuario;
	private String str_email_usuario;
	private Boolean bool_admin_usuario;

	public UserModel() {

		setPk_usuario(0);
		setStr_nombre_usuario(null);
		setStr_pass_usuario(null);
		setStr_email_usuario(null);
		setBool_admin_usuario(null);

	}

	public UserModel(int pk_usuario, String str_nombre_usuario, String str_pass_usuario, String str_email_usuario,
			Boolean bool_admin_usuario) {

		setPk_usuario(pk_usuario);
		setStr_nombre_usuario(str_nombre_usuario);
		setStr_pass_usuario(str_pass_usuario);
		setStr_email_usuario(str_email_usuario);
		setBool_admin_usuario(bool_admin_usuario);

	}

	public int getPk_usuario() {
		return pk_usuario;
	}

	private void setPk_usuario(int pk_usuario) {
		this.pk_usuario = pk_usuario;
	}

	public String getStr_nombre_usuario() {
		return str_nombre_usuario;
	}

	public void setStr_nombre_usuario(String str_nombre_usuario) {
		this.str_nombre_usuario = str_nombre_usuario;
	}

	public String getStr_pass_usuario() {
		return str_pass_usuario;
	}

	public void setStr_pass_usuario(String str_pass_usuario) {
		this.str_pass_usuario = str_pass_usuario;
	}

	public String getStr_email_usuario() {
		return str_email_usuario;
	}

	public void setStr_email_usuario(String str_email_usuario) {
		this.str_email_usuario = str_email_usuario;
	}

	public Boolean getBool_admin_usuario() {
		return bool_admin_usuario;
	}

	public void setBool_admin_usuario(Boolean bool_admin_usuario) {
		this.bool_admin_usuario = bool_admin_usuario;
	}

	@Override
	public String toString() {
		return "User [" + getPk_usuario() + " / " + getStr_nombre_usuario() + " / " + getStr_pass_usuario() + " / "
				+ getStr_email_usuario() + " / " + getBool_admin_usuario() + "]";
	}

}
