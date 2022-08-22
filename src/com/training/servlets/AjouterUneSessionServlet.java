package com.training.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.entites.Enseignant;
import com.training.entites.Session;
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
		
		
		
		long idSession =Integer.parseInt( request.getParameter("idSession"));
		String dateDebutSession = request.getParameter("dateDebutSession");
		String dateFinSession = request.getParameter("dateFinSession");
		String price=request.getParameter("price");
		long es_fk=Integer.parseInt(request.getParameter("es_fk"));
		
				
				
ServiceFormation sf = new ServiceFormation();
		sf.AjouterSession(idSession, dateDebutSession, dateFinSession, price,es_fk);
		
		
		response.sendRedirect("index.html");
	}

}
