package com.training.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;

import com.training.services.ServiceFormation;

/**
 * Servlet implementation class AjouterUnThemeServlet
 */
@WebServlet("/AjouterUnThemeServlet")
public class AjouterUnThemeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(AjouterUnThemeServlet.class);
	       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterUnThemeServlet() {
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
		
		String NomTheme = request.getParameter("nomTheme");
		logger.info("nom du theme ajouté: " + NomTheme);
		
		ServiceFormation sf = new ServiceFormation();
		sf.addTheme(NomTheme);
		//sf.addTheme("test");
		response.sendRedirect("ajouterUnTheme.jsp");
		
	}

}

