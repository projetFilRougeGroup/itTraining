package com.training.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.services.ServiceFormation;

/**
 * Servlet implementation class AjouterUneFormationServlet
 */
@WebServlet("/AjouterUneFormationServlet")
public class AjouterUneFormationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterUneFormationServlet() {
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
		// TODO Auto-generated method stub
		// doGet(request, response);
		
		String nomFormation = request.getParameter("nomFormation");
		String referenceFormation = request.getParameter("referenceFormation");
		
		String publicFormation = request.getParameter("publicFormation");
		String objectifsFormation = request.getParameter("objectifsFormation");
		String detailsFormation = request.getParameter("detailsFormation");
		
		String chaptersFormation = request.getParameter("chaptersFormation");
		int priceFormation = Integer.parseInt(request.getParameter("priceFormation"));
		int dureeFormation =Integer.parseInt(request.getParameter("dureeFormation"));
	
		
		ServiceFormation SF = new ServiceFormation();
		
		SF.addFormation(nomFormation, referenceFormation, publicFormation, objectifsFormation, detailsFormation, chaptersFormation,priceFormation, dureeFormation);
		//System.out.println("coco !!");
		//RequestDispatcher rd = request.getRequestDispatcher("ajouterUneFormation.jsp");
		//rd.forward(request, response);
		response.sendRedirect("index.html");
		
	}

}
