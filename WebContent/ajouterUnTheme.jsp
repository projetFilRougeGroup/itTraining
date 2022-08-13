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

<title>Ajout d'un theme</title>
</head>
<body>

	<form action="AjouterUnThemeServlet" method="POST">
	
		<table>
			<caption>création d'un nouveau theme</caption>
			<tr>
			    <td>Nom du theme</td>
			    <td><input name="nomTheme" type="text"/></td>
			</tr>
			
			<tr>
			    <td></td>
			    <td><input type="submit" value="Ajouter!"/></td>
			</tr>
		</table>
	
	</form>
	
<!--  <c:url var="thisURL" value="index.html" />
<a href="<c:out value="${thisURL}"/>">Retour à l'accueil</a>-->
<a href="index.html">Retour à l'accueil</a>
</body>
</html>