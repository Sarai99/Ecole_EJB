<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="Style.css"  type="text/css">
<link rel="stylesheet"  href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body class="body">
<header>
            <h1 class="avant">Salut chers amis</h1>
            <h1 class="entete">UNIQ University- Page des Notes</h1>
            <nav class="navbar">
               <ul>
                <li><a  href="VueEtudiant1.jsp" >Etudiant</a></li>
                <li><a  href="VueMatiere.jsp" >Matiere</a></li>
                <li><a  href="VuePaiment.jsp">Paiement</a></li>
                <li><a  href="VueNotes.jsp" >Notes</a></li> 
               </ul> 
            </nav>
    </header>


   <div class="container col-md-6" style="background-color:#6cbe6f; border-radius:30px;">
    </br>
    
  <form action="controleur4" method="get"  name="form3">
  <div class="container col-md-7" >
  <h1>Notes</h1>
  <div class="row">
  
  <table>
  <tr>
    <td> Reference  	 :</td> <td> <input type="text"  name="idNote" value ="${idNote}"></td>
   </tr>
    <td>Reference Matiere	      :</td> <td> <input type="text"  name="refMatiere"  value ="${refMatiere}"></td>
   </tr>
   <tr>
    <td> Reference Etudiant  	   :</td> <td> <input type="text"  name="refEtudiant" value ="${refEtudiant}" ></td>
   </tr>  
   <tr>
   <tr>
     <td>Valeur    :</td> <td> <input type="text"  name="valeur" value ="${valeur}"></td>
     </tr>
    </table>
   </div>
  </br>
  
   <table>
    <tr>
    <td class= "td"> <input  type="submit"  value="Ajouter"  name="action4" class="button"></td>
    <td class= "td"> <input  type="submit"  value="Modifier"  name="action4" class="button"></td>
     <td class= "td"> <input  type="submit"  value="Recherche"  name="action4" class="button"></td> 
    <td class= "td"> <input  type="submit"  value="Lister"  name="action4" class="button"></td>
    </tr>
     
     </table>
     </br>
     </div>
    </form> 
    
    </div>
    
     <form action="controleur4" method="get"  name="form3">

     <hr/> 
  </br>
  </br>
  <table  border="1"  width="80%" align="center">
     <tr>
       <th>ID</th><th>RefMaitiere</th><th>RefEtudiant</th><th>Valeur</th><th>Consultation</th><th>Suppression</th>
     </tr>
     <c:forEach   items="${notes}"   var="e">
     
         <tr>
              <td>${e.idNote}</td>
              <td>${e.matiere.refMatiere}</td>
              <td>${e.etudiant1.refEtudiant}</td>
              <td>${e.valeur}</td>
              <td><a href="controleur4?matiere.refMatiere=1L&etudiant1.refEtudiant=2L&valeur=90.0&idNote=${e.idNote}&action4=Consulter" name="action4" style="color:black;text-decoration:none;border-radius:5px; box-shadow:1px 1px 1px 1px #5e689f;">Consulter</a></td>
              <td><a href="controleur4?matiere.refMatiere=1L&etudiant1.refEtudiant=2L&valeur=90.0&idNote=${e.idNote}&action4=Supprimer" name="action4" style="color:black;text-decoration:none;border-radius:5px; box-shadow:1px 1px 1px 1px #5e689f;">Supprimer</a></td>
       
         </tr>
     </c:forEach>
  </table>
  
 </form>

</body>
</html>