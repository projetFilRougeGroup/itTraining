<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" type="text/css" href="css/rechercheFormation.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
<title>Ajouter Une Session</title>
</head>
<body>
	
	<form action="AjouterUneSessionServlet" method="POST">
	
		<table>
			<caption>Création d'une session</caption>
			<tr>
			    <td>ID_formation</td>
			    <td><input name="ID_Formation" type="text"/></td>
			</tr>			
			
			<tr>
			    <td>Date début session (dd-MM-yyyy)</td>
			    <td><input name="dateDebut" type="text"/></td>
			</tr>
			<tr>
			    <td>Date de fin de session(dd-MM-yyyy)</td>
			    <td><input name="dateFin" type="text"/></td>
			</tr>
			
			<tr>
			    <td>Prix</td>
			    <td><input name="prixsession" type="text"/></td>
			</tr>

			
			<tr>
			    <td></td>
			    <td><input type="submit" value="Créer session!"/></td>
			</tr>
		</table>
	</form>


<c:url var="thisURL" value="index.html">
</c:url>
<a href="<c:out value="${thisURL}"/>">Retour à l'accueil</a>

</body>
</html>