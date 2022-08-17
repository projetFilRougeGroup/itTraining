package com.training.servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;

import com.training.entites.Enseignant;
import com.training.entites.Formation;
import com.training.entites.Prerequis;
import com.training.services.ServiceFormation;

/**
 * Servlet implementation class AjouterformateurServlet
 */
@WebServlet("/AjouterformateurServlet")
public class AjouterformateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(AjouterformateurServlet.class); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterformateurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		long idEnseignant = Long.parseLong(request.getParameter("idEnseignant")); //comment?
		String  nomEnseignant =request.getParameter("nomEnseignant");
		String telEnseignant = request.getParameter("telEnseignant");
		
		String prenomEnseignant=request.getParameter("prenomEnseignant");
		String emailEnseignant=request.getParameter("emailEnseignant");
		String adresseEnseignant=request.getParameter("adresseEnseignant");
		String skill=request.getParameter("skill");
		
		ServiceFormation sf = new ServiceFormation();
		sf.AjouterFormateur( nomEnseignant, prenomEnseignant, emailEnseignant, telEnseignant, adresseEnseignant,skill);
		
		response.sendRedirect("index.html");
		
		

		
	}

}
