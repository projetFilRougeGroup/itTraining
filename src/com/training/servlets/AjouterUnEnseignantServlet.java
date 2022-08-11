package com.training.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.services.ServiceFormation;

/**
 * Servlet implementation class AjouterUnEnseignantServlet
 */
@WebServlet("/AjouterUnEnseignantServlet")
public class AjouterUnEnseignantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterUnEnseignantServlet() {
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
		String nomEnseignant = request.getParameter("nomEnseignant");
		String prenomEnseignant = request.getParameter("prenomEnseignant");
		
		String emailEnseignant = request.getParameter("emailEnseignant");
		String telEnseignant = request.getParameter("telEnseignant");
		String adresseEnseignant = request.getParameter("adresseEnseignant");
		
		ServiceFormation SF = new ServiceFormation();
		
		SF.addEnseignant(nomEnseignant, prenomEnseignant, emailEnseignant, telEnseignant, adresseEnseignant);
		
		response.sendRedirect("enseignant.jsp");
	}

}
