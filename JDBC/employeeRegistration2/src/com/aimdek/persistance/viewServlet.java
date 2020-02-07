package com.aimdek.persistance;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aimdek.persistance.*;


@WebServlet("/viewServlet")
public class viewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public viewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		 connectionDb d = new connectionDb();
		try {	
			Connection con = d.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * from \"newTable\" ");
			while(rs.next()) {
				out.print("<br>");
				out.print("NAME:");
				out.print("  <tab> "+ rs.getString(1));
				out.print("<br>");
				out.print("ID:");
				out.print("  <tab> "+ rs.getString(2));
				//String temp = rs.getString(2);
				out.print("<br>");
				out.print("EMAIL:");
				out.print("<tab>"+ rs.getString(3));
				out.print("<br>");
				out.print("AGE:");
				out.print(" <tab>"+ rs.getString(4));
				out.print("<br>");out.print("<br>");
				//out.print("<a href='DeleteServlet?id=\"+rs.getString(2)+\"'> DELETE </a>");
				out.print("<a href='deleteServlet?id="+rs.getString(2)+"'> DELETE </a>");
				out.print("<br>");
				out.print("<a href='updateServlet?id="+rs.getString(2)+"'> UPDATE </a>");
				out.print("<br>");out.print("<br>");out.print("<br>");out.print("<br>");
				out.print("<p>");
				
			}
			out.print("<a href='Index.html'>GO HOME</a>");
		}catch(Exception et) {
			System.out.println("error");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
