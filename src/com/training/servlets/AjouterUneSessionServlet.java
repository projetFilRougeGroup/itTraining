package com.training.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.services.ServiceFormation;

/**
 * Servlet implementation class AjouterUneSessionServlet
 */
@WebServlet("/AjouterUneSessionServlet")
public class AjouterUneSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterUneSessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		
//		String dateDebutSession = request.getParameter("dateDebutSession");
//		Date dateFinSession = request.getParameter("dateFinSession");
		
//		ServiceFormation sf = new ServiceFormation();
		//sf.addPrerequis(dateDebutSession, dateFinSession);
		
		response.sendRedirect("index.html");
	}

}
