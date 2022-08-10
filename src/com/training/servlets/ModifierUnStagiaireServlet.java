package com.training.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.services.ServiceFormation;

/**
 * Servlet implementation class ModifierUnStagiaireServlet
 */
@WebServlet("/ModifierUnStagiaireServlet")
public class ModifierUnStagiaireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierUnStagiaireServlet() {
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
		
		long idStagiaire = Long.parseLong(request.getParameter("idStagiaire"));
		String nomStagiaire = request.getParameter("nomStagiaire");
		String prenomStagiaire = request.getParameter("prenomStagiaire");
		
		
		String telStagiaire = request.getParameter("telStagiaire");
		String emailStagiaire = request.getParameter("emailStagiaire");
		String adresseStagiaire = request.getParameter("adresseStagiaire");
		
		
	
		
		ServiceFormation sf = new ServiceFormation();
		sf.modifierStagiaire(idStagiaire,nomStagiaire,prenomStagiaire, telStagiaire,emailStagiaire, adresseStagiaire);
		
		response.sendRedirect("index.html");	
	}

}
