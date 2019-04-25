package com.main;

import java.util.Iterator;

import com.jdbc.ElementoDAO;
import com.jdbc.UserDAO;
import com.model.ElementoModel;
import com.model.UserModel;

public class Main {

	public static void userDAOtest() {

		UserDAO userDAO = new UserDAO();

		Iterator<UserModel> it = userDAO.findAllUsers().iterator();
		System.out.println("call findAllUsers method");
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		System.out.println("\ncall findUserById method");
		System.out.println(userDAO.findUserById(2));

		System.out.println("\ncall findUserByEmailAndPassword method");
		System.out.println(userDAO.findUserByEmailAndPassword("admin@admin.com", "123456"));

		System.out.println("\ncall findUserByEmail method");
		System.out.println(userDAO.findUserByEmail("admin@admin.com"));

		System.out.println("\ncall createUser method");
		UserModel createdUser = userDAO.createUser("Created user", "123456", "created@admin.com", false);
		System.out.println(createdUser);

		createdUser.setStr_nombre_usuario("Updated user");
		createdUser.setStr_pass_usuario("7890");
		createdUser.setStr_email_usuario("updatedd@admin.com");
		createdUser.setBool_admin_usuario(true);

		System.out.println("\ncall updateUser method");
		if (userDAO.updateUser(createdUser)) {
			System.out.println(createdUser + " updated");
		}

		System.out.println("\ncall deleteUser method");
		if (userDAO.deleteUser(createdUser)) {
			System.out.println(createdUser + " deleted");
		}

	}

	public static void elementosDAOtest() {

		ElementoDAO elementoDAO = new ElementoDAO();

		Iterator<ElementoModel> it = elementoDAO.findAllElemento().iterator();
		System.out.println("call findAllelementos method");
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		System.out.println("\ncall findElementoById method");
		System.out.println(elementoDAO.findElementoById(2));

		System.out.println("\ncall createElemento method");
		ElementoModel createdElemento = elementoDAO.createElemento("Kiwi");
		System.out.println(createdElemento);

		createdElemento.setStr_nombre_elemento("Kiwi actualiazado");

		System.out.println("\ncall updateElemento method");
		if (elementoDAO.updateElemento(createdElemento)) {
			System.out.println(createdElemento + " updated");
		}

		System.out.println("\ncall deleteElemento method");
		if (elementoDAO.deleteElemento(createdElemento)) {
			System.out.println(createdElemento + " deleted");
		}

		System.out.println("\ncall deleteElement method");
		if (elementoDAO.deleteElement(createdElemento)) {
			System.out.println(createdElemento + " deleted");
		}

	}

	public static void main(String[] args) {

		// userDAOtest();
		elementosDAOtest();
	}

}
