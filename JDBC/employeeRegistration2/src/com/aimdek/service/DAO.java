package com.aimdek.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.aimdek.model.employee;
import com.aimdek.persistance.connectionDb;



public class DAO {
	
static connectionDb d = new connectionDb();
	  
	
	
	public void save(employee e) {
		
		try {
		Connection con = d.getConnection();
		
		PreparedStatement ps = con.prepareStatement("INSERT INTO \"newTable\" values (?,?,?,?)");
		ps.setString(1,e.getName());
		ps.setString(2,e.getId());
		ps.setString(3,e.getEmail());
		ps.setString(4,e.getAge());
		ps.execute();
		}catch(Exception et) {
			System.err.println("error in saave()");
		}
		
	}
	
	
	public static List<employee> showAll() {
		List <employee> l = new ArrayList<employee>();
		try {
			Connection con = d.getConnection();
			Statement  st = con.createStatement();
			ResultSet rs = st.executeQuery("Select * from\"newTable\"");
			//System.err.print("'idharrr tak");
			while(rs.next()) {
				employee e = new employee();
				e.setId(rs.getString(2));
				e.setName(rs.getString(1));
				e.setEmail(rs.getString(3));
				e.setAge(rs.getString(4));
				l.add(e);
				
			}
		}
		catch(Exception t) {
			System.out.println("error in showe()");
		}
	return l;	
	}
	
	public static void del(String i) {
		
		try {
			Connection con = d.getConnection();
			PreparedStatement ps = con.prepareStatement("DELETE FROM public.\"newTable\"\r\n" + 
					"	WHERE id= ?;");
			ps.setString(1, i);
			
			ps.executeUpdate();
			
		}catch(Exception et) {}
		
	}


	public static employee getEById(String i) {
		employee e = new employee();
		try {
			Connection con = d.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM public.\"newTable\" where id= ?");
			ps.setString(1, i);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				e.setId(rs.getString(2));
				e.setName(rs.getString(1));
				e.setAge(rs.getString(3));
				e.setEmail(rs.getString(4));
			}
			
		}catch(Exception et) {}
		return e;
		
	}
	public static void update(String i) {
		employee e = new employee();
		try {
			Connection con = d.getConnection();
			PreparedStatement ps = con.prepareStatement("UPDATE public.\"newTable\"\r\n" + 
					"	SET name='updated'" + 
					"	WHERE id=?;");
			
			ps.setString(1, i);
		 ResultSet rs= ps.executeQuery();
		 
			while(rs.next()) {	
				e.setId(rs.getString(2));
				e.setName("updated");
				//e.getString(1).
				e.setAge(rs.getString(3));
			e.setEmail(rs.getString(4));
			}
			
		}catch(Exception et) {}
	}
	
//	public static employee getEById(String i) {
//		employee e = new employee();
//		try {
//			Connection con = d.getConnection();
//			PreparedStatement ps = con.prepareStatement("SELECT * FROM public.\"newTable\" where id= ?");
//			ps.setString(1, i);
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//				e.setId(rs.getString(2));
//				e.setName(rs.getString(1));
//				e.setAge(rs.getString(3));
//				e.setEmail(rs.getString(4));
//			}
//				
//		}catch(Exception et) {}
//		return e;
//	}


	
	
}
