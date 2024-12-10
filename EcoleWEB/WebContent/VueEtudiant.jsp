<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Etudiant</h1>
</br>
  <form action="controleur" method="post" >
  <table>
  <tr>
    <td> Reference  	 Etudiant   :</td> <td> <input type="text"  name="refEtudiant" value ="${refEtudiant}"></td>
   </tr>
  <tr>
    <td> Prenom  	 Etudiant   :</td> <td> <input type="text"  name="prenom" value ="${prenom}" ></td>
   </tr>  
   <tr>
    <td>Nom	     Etudiant   :</td> <td> <input type="text"  name="nom"  value ="${nom}"></td>
   </tr>
   <tr>
     <td>Departement Etudiant :</td> <td> <input type="text"  name="departement" value ="${departement}"></td>
    </tr>
     <tr>
     <td>Scolarite   Etudiant   :</td> <td> <input type="text"  name="scolarite" value ="${scolarite}"></td>
     </tr>
     <tr>
     <td>Groupe      Etudiant   :</td> <td> <input type="text"  name="groupe" value ="${groupe}"></td>
     </tr>
     <tr>
     <td>Code        Etudiant   :</td> <td> <input type="text"  name="code" value ="${code}"></td>
    </tr>
    
    
    <tr>
    <td> <input  type="submit"  value="Ajouter"  name="action" style="color:red" style="background-color:#3cb371"></td>
    <td> <input  type="submit"  value="Modifier"  name="action" style="color:red" style="background-color:#3cb371"></td>
     <td> <input  type="submit"  value="Consulter"  name="action" style="color:red" style="background-color:#3cb371"></td> 
    <td> <input  type="submit"  value="Lister"  name="action" style="color:red" style="background-color:#3cb371"></td>
    </tr>
     
     </table>
     <hr/>
 
  </br>
  </br>
  <table  border="1"  width="80%" align="center">
     <tr>
       <th>ID</th><th>PrenomEtudiant</th><th>NomEtudiant</th><th>Departement</th><th>Scolarite</th><th>Groupe</th><th>Code</th>
     </tr>
     <c:forEach   items="${etudiant}"   var="e">
         <tr>
              <td>${e.refEtudiant}</td>
              <td>${e.prenom}</td>
              <td>${e.nom}</td>
              <td>${e.departement}</td>
              <td>${e.scolarite}</td>
              <td>${e.groupe}</td>
              <td>${e.code}</td>
         </tr>
     </c:forEach>
  </table>
  
 </form>
</body>
</html>