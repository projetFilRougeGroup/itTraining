package com.training.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.services.ServiceFormation;

/**
 * Servlet implementation class ModifierLePrerequisServlet
 */
@WebServlet("/ModifierLePrerequisServlet")
public class ModifierLePrerequisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierLePrerequisServlet() {
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
		long idPrerequis = Long.parseLong(request.getParameter("idPrerequis"));
		String descriptionPrerequis = request.getParameter("descriptionPrerequis");
		String quizz = request.getParameter("quizz");
		
		
		ServiceFormation sf = new ServiceFormation();
		sf.modifierPrerequis(idPrerequis,descriptionPrerequis,quizz);
		
		response.sendRedirect("index.html");	
	}

}
