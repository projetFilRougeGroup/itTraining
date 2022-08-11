package com.training.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.services.ServiceFormation;

/**
 * Servlet implementation class ModifierUnEnseignantServlet
 */
@WebServlet("/ModifierUnEnseignantServlet")
public class ModifierUnEnseignantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierUnEnseignantServlet() {
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
		long idEnseignant = Long.parseLong(request.getParameter("idEnseignant"));
		String nomEnseignant = request.getParameter("nomEnseignant");
		String prenomEnseignant = request.getParameter("prenomEnseignant");
		
		
		String telEnseignant = request.getParameter("telEnseignant");
		String emailEnseignant = request.getParameter("emailEnseignant");
		String adresseEnseignant = request.getParameter("adresseEnseignant");
		
		
	
		
		ServiceFormation sf = new ServiceFormation();
		sf.modifierEnseignant(idEnseignant,nomEnseignant,prenomEnseignant, telEnseignant,emailEnseignant, adresseEnseignant);
		
		response.sendRedirect("enseignant.jsp");	
	}

}
