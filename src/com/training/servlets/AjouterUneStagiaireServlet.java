package com.training.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.services.ServiceFormation;

/**
 * Servlet implementation class AjouterUneStagiaireServlet
 */
@WebServlet("/AjouterUneStagiaireServlet")
public class AjouterUneStagiaireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterUneStagiaireServlet() {
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
		String nomStagiaire = request.getParameter("nomStagiaire");
		String prenomStagiaire = request.getParameter("prenomStagiaire");
		
		String emailStagiaire = request.getParameter("emailStagiaire");
		String telStagiaire = request.getParameter("telStagiaire");
		String adresseStagiaire = request.getParameter("adresseStagiaire");
		
		ServiceFormation SF = new ServiceFormation();
		
		SF.addStagiaire(nomStagiaire, prenomStagiaire, emailStagiaire, telStagiaire, adresseStagiaire);
		//System.out.println("coco !!");
		//RequestDispatcher rd = request.getRequestDispatcher("ajouterUneFormation.jsp");
		//rd.forward(request, response);
		response.sendRedirect("index.html");
	}

}
