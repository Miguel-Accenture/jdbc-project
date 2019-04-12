package com.model;

public class ElementoModel {
	
	private int pk_elemento;
	private String str_nombre_elemento;
	
	public ElementoModel() {
		setPk_elemento(0);
		setStr_nombre_elemento(null);
	}

	public ElementoModel(int pk_elemento, String str_nombre_elemento) {
		
		setPk_elemento(pk_elemento);
		setStr_nombre_elemento(str_nombre_elemento);
	}

	public int getPk_elemento() {
		return pk_elemento;
	}
	
	public String getStr_nombre_elemento() {
		return str_nombre_elemento;
	}
	
	public void setStr_nombre_elemento(String str_nombre_elemento) {
		this.str_nombre_elemento = str_nombre_elemento;
	}
	
	public void setPk_elemento(int pk_elemento) {
		this.pk_elemento = pk_elemento;
	}

	@Override
	public String toString() {
		return "ElementoModel [pk_elemento=" + pk_elemento + ", str_nombre_elemento=" + str_nombre_elemento + "]";
	}
	
	
	

}
