package com.training.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.training.services.ServiceFormation;

/**
 * Servlet implementation class ModifierUneFormationServlet
 */
@WebServlet("/ModifierUneFormationServlet")
public class ModifierUneFormationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierUneFormationServlet() {
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
		
		long idFormation = Long.parseLong(request.getParameter("idFormation"));
		String nomFormation = request.getParameter("nomFormation");
		String referenceFormation = request.getParameter("referenceFormation");
		
		
		String publicFormation = request.getParameter("publicFormation");
		String objectifsFormation = request.getParameter("objectifsFormation");
		String detailsFormation = request.getParameter("detailsFormation");
		
		String chaptersFormation = request.getParameter("chaptersFormation");
		int priceFormation = Integer.parseInt(request.getParameter("priceFormation"));
		int dureeFormation = Integer.parseInt(request.getParameter("dureeFormation"));
		
	
		
		ServiceFormation sf = new ServiceFormation();
		sf.modifierFormation(idFormation,referenceFormation,nomFormation, publicFormation,objectifsFormation, detailsFormation, chaptersFormation, priceFormation, dureeFormation);
		
		response.sendRedirect("index.html");	
		
	}

}
