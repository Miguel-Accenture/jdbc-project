package com.main;

import java.util.Iterator;

import com.jdbc.UserDAO;
import com.model.UserModel;

public class Main {

	public static void main(String[] args) {

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

}
