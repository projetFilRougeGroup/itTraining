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

<title>Supprimer une formation !</title>
</head>
<body>

	<form action="SupprimerUneFormationServlet" method="POST">
	
				<label for="idFormation">Id de la formation</label>
			  	<input id="idFormation" name="idFormation" type="text"/>
			
			    <input value="Supprimer !" type="submit"/>
	</form>

</body>
</html>