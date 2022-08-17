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
<title>Session</title>
</head>
<body>
	
	<form action="AjouterUneSessionServlet" method="POST">
	
		<table>
			<caption>Création d'une session</caption>
			
			
			<tr>
			    <td>Date début session</td>
			    <td><input name="referenceFormation" type="text"/></td>
			</tr>
			<tr>
			    <td>Date de fin de session</td>
			    <td><input name="nomFormation" type="text"/></td>
			</tr>
			
			<tr>
			    <td>Prix</td>
			    <td><input name="prerequisFormation" type="text"/></td>
			</tr>
			
			
			<tr>
			    <td></td>
			    <td><input type="submit" value="Ajouter !"/></td>
			</tr>
		</table>
	
	</form>

</body>
</html>