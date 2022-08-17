<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Résultat de recherche !</title>
</head>
<body>

Nombre de formation trouvé: ${fn:length(resultRechercheFromation)}
<br />
<c:forEach var="workload" items="${resultRechercheFromation}">
			
            <tr class="font" style="height: 32px"> 
            
            	<td>id Formation : ${workload.idFormation}</td>
            	
                <td >Nom Formation : ${workload.nomFormation}</td>
                <td>Référence : ${workload.referenceFormation}</td>
                <td >Prérequis : ${workload.prerequisFormation}</td>
                <td >Public : ${workload.publicFormation}</td>
                <td>Objectifs : ${workload.referenceFormation}</td>
                <td >Détails : ${workload.detailsFormation}</td>
                
                <td>Chapters : ${workload.chaptersFormation}</td>
                <td >Prix : ${workload.priceFormation}</td>
                <td >Durée : ${workload.dureeFormation}</td>
                <td>Domaine : ${workload.domaineFormation}</td>
             
            </tr>
</c:forEach>


<%-- ${resultRechercheFromation.nomFormation} --%>
</body>
</html>