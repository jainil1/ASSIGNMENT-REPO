package com.aimdek.persistance;

import java.sql.Connection;
import java.sql.DriverManager;

public class connectionDb {
	public static Connection getConnection() {
		Connection con =null;
		System.err.print("baaa");
		try {
			 
			Class.forName("org.postgresql.Driver");
		    con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "admin");
		    System.err.print("ccaaa");
		}catch(Exception e) {
			System.err.println("Mistake Is in coonecting class ");
		}
		
		return con;
	}

}
