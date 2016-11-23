package com.app.mvc.util;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6793636192781919561L;

	private static Connection con;

	public static Connection getConnection() {
		if (con == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("Driver Loaded");
			} catch (ClassNotFoundException e) {
				System.err.println(e.getMessage());
			}
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/getcitydealz", "root", "root123");
				System.out.println("Connected :)");
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
		return con;
	}

	/*
	 * public static void main(String[] args) { getConnection();
	 * 
	 * DataSource ds = (DataSource)ApplicationContext.getBean("dataSource");
	 * Connection c = ds.getConnection(); }
	 */
}
