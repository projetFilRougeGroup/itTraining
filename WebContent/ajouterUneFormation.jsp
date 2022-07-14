<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Formation</title>
</head>
<body>

	<form action="AjouterUneFormationServlet" method="POST">
	
		<table style="border: 2px solid green">
			<caption>L'ajout/création d'une formation</caption>
			
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
			    <td>Prérequis de la formation</td>
			    <td><input name="prerequisFormation" type="text"/></td>
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
			    <td>Domaine de la formation</td>
			    <td><input name="domaineFormation" type="text"/></td>
			</tr>
			
			<tr>
			    <td></td>
			    <td><input type="submit" value="Envoyer !"/></td>
			</tr>
		</table>
	
	</form>
	

</body>
</html>