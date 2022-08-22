
<%@page import="com.training.entites.Enseignant"%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import ="java.util.List" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>La recherche d'une formateur !</h1>

	<form action="ChercheFormateurServlet" method="POST">
		
			
				    <label for="rech">
				    Trouver une formateur  !
				    </label>
				   <p> <input type="text" name="skill" placeholder="search by skill of prof."/>
				    <input type="submit" value="Chercher !"/>
	 
  </form>    
  
  <form action="ChercheFormateurbysessionidServlet" method="POST">
		
			
				    <label for="rech">
				    Trouver une formateur  !
				    </label>
				   <p> <input type="text" name="skill" placeholder="search by Session id of prof."/>
				    <input type="submit" value="Chercher !"/>
	 
  </form>    
    
</body>
</html>