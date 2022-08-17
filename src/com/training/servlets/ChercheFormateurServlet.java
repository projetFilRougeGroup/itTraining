package com.training.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.entites.Enseignant;
import com.training.services.ServiceFormation;

/**
 * Servlet implementation class ChercheFormateur
 */
@WebServlet("/ChercheFormateurServlet")
public class ChercheFormateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
     * @see HttpServlet#HttpServlet()
     */
    public ChercheFormateurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String skill=request.getParameter("skill");
		
		 List <Enseignant>form_list=new ArrayList<>();
		  form_list=new ServiceFormation().rechercheFormateur(skill);

		  request.setAttribute("formList",form_list);
		  
		 System.out.println("formList " + form_list);

		  // out.println("emp_list " + emp_list);

		 
		  RequestDispatcher dispatcher = 
		   getServletContext().getRequestDispatcher("/viewFormateur.jsp");
		  dispatcher.forward(request,response);
		  response.sendRedirect("index.html");
			
		  } 
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
		
		
			
			
		
	
	}}


