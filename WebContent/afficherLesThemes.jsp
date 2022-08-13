<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List, java.text.*" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/index.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" type="text/css" href="css/rechercheFormation.css">
<link rel="stylesheet" type="text/css" href="css/tableaux.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
<title>Afficher tous les themes</title>
</head>
<body>

	<form action="AfficherLesThemesServlet" method="POST">
		<label for="affich">
				   Afficher tous les themes
				   <!--  , avec leur supertheme s'ils en ont un !-->
		</label>
	<input type="submit" value="Afficher !"/>
	</form>
	<br />
	<c:forEach var="workload" items="${resultRechercheThemes}">
	
				<table>
		            <tr> 
		            
		            	<td>id Theme</td>
		                <td>Nom Theme</td>
<!-- 		                <td>Nom Supertheme</td>
		                <td>Liste Noms Sousthemes</td> -->
		            </tr>
		            <tr>
			            <td>${workload.idTheme}</td>
			            <td>${workload.nomTheme}</td>
<%-- 			            <td>${workload.supertheme}</td>
			            <td>${workload.liste_sousthemes}</td> --%>
	            </table>
	</c:forEach>


<c:url var="thisURL" value="index.html">
</c:url>
<a href="<c:out value="${thisURL}"/>">Retour à l'accueil</a>

</body>
</html>