package com.aimdek.persistance;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aimdek.persistance.*;
import com.aimdek.service.*;
import com.aimdek.model.*;

/**
 * Servlet implementation class saveServlet
 */
@WebServlet("/saveServlet")
public class saveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public saveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String Name , Email,Id, Age;
		Name = request.getParameter("name");
		Id = request.getParameter("id");
		Email = request.getParameter("email");
		Age = request.getParameter("age");
		employee e = new employee();
		e.setAge(Age);
		e.setId(Id);
		e.setEmail(Email);
		e.setName(Name);
		DAO d = new DAO();
		
		d.save(e);
		out.print("ADDED VALUE ");
		out.print("<p><a href =\"Index.html\"> ADD ANOTHER");
		out.print("<p><a href =\"viewServlet\"> VIEWWW");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
