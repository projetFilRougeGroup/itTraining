<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>R�sultat de recherche !</title>
</head>
<body>

Nombre de formation trouv�: ${fn:length(resultRechercheFromation)}
<br />
<c:forEach var="workload" items="${resultRechercheFromation}">
			
            <tr class="font" style="height: 32px"> 
            
            	<td>id Formation : ${workload.idFormation}</td>
            	
                <td >Nom Formation : ${workload.nomFormation}</td>
                <td>R�f�rence : ${workload.referenceFormation}</td>
                <td >Pr�requis : ${workload.prerequisFormation}</td>
                <td >Public : ${workload.publicFormation}</td>
                <td>Objectifs : ${workload.referenceFormation}</td>
                <td >D�tails : ${workload.detailsFormation}</td>
                
                <td>Chapters : ${workload.chaptersFormation}</td>
                <td >Prix : ${workload.priceFormation}</td>
                <td >Dur�e : ${workload.dureeFormation}</td>
                <td>Domaine : ${workload.domaineFormation}</td>
             
            </tr>
</c:forEach>


<%-- ${resultRechercheFromation.nomFormation} --%>
</body>
</html>