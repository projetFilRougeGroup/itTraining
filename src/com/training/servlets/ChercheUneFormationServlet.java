package com.training.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.services.ServiceFormation;

/**
 * Servlet implementation class ChercheUneFormationServlet
 */
@WebServlet("/ChercheUneFormationServlet")
public class ChercheUneFormationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChercheUneFormationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idFormation = Integer.parseInt(request.getParameter("idFormation"));
		String referenceFormation = request.getParameter("referenceFormation");
		String nomFormation = request.getParameter("nomFormation");
		
		ServiceFormation sf = new ServiceFormation();
		
		sf.rechercheFormation(nomFormation);
		//sf.rechercheFormation(idFormation);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
