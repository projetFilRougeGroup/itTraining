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

<title>Modifier une formation</title>
</head>
<body>


<form action="ModifierUneFormationServlet" method="POST">
	
		<table>
			<caption>Modification d'une formation</caption>
			
			<tr>
			    <td>Id de la formation</td>
			    <td><input name="idFormation" type="text"/></td>
			</tr>
			<tr>
			    <td>Référence de la formation</td>
			    <td><input name="referenceFormation" type="text"/></td>
			</tr>
			<tr>
			    <td>Nom de la formation</td>
			    <td><input name="nomFormation" type="text"/></td>
			</tr>
			
			
			
			<tr>
			    <td>Public de la formation</td>
			    <td><input name="publicFormation" type="text"/></td>
			</tr>
			
			<tr>
			    <td>Objectifs de la formation</td>
			    <td><input name="objectifsFormation" type="text"/></td>
			</tr>
			
			<tr>
			    <td>Détails de la formation</td>
			    <td><input name="detailsFormation" type="text"/></td>
			</tr>
			
			<tr>
			    <td>Chapters de la formation</td>
			    <td><input name="chaptersFormation" type="text"/></td>
			</tr>
			
			<tr>
			    <td>Price de la formation</td>
			    <td><input name="priceFormation" type="text"/></td>
			</tr>
			
			<tr>
			    <td>Durée de la formation</td>
			    <td><input name="dureeFormation" type="text"/></td>
			</tr>
			
			
			
			<tr>
			    <td></td>
			    <td><input type="submit" value="Modifier !"/></td>
			</tr>
		</table>
	
	</form>




</body>
</html>