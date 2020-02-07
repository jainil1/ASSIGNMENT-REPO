package com.aimdek.persistance;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aimdek.service.DAO;

/**
 * Servlet implementation class updateServlet
 */
@WebServlet("/updateServlet")
public class updateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public updateServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out= response.getWriter();
		String id = request.getParameter("id");
		
		DAO.update(id);
		response.sendRedirect("viewServlet");
//		
//		out.print("<form action='editServlet' method='get'>");
//		out.print("<div name>");
//		out.print("ENTER NAME to update for id :<p>");
//		out.print("<input type='hidden' name='id'   value='"+id+"'/>");
//		out.print("<input type='text' name='name'>");
//		out.print("<input type='submit' name='name'>");	
//		out.print("</form>") ;
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
