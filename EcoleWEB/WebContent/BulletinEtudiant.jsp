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
            <h1 class="entete">UNIQ University- Page des Bulletins</h1>
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
    
  <form action="controleur5" method="get"  name="form5">
  <div class="container col-md-7" >
  <h1>Bulletin</h1>
  <div class="row">
  
  <table>
  
    <td> Reference Etudiant  	   :</td> <td> <input type="text"  name="refEtudiant" value ="${refEtudiant}" ></td>
   </tr>  
   <tr>
     
    </table>
   </div>
  </br>
  
   <table>
    <tr>
     <td class= "td"> <input  type="submit"  value="Recherche"  name="action5" class="button"></td> 
    </tr>
     
     </table>
     </br>
     </div>
    </form> 
    
    </div>
    
    
    
     <form action="controleur5" method="get"  name="form5">

     <hr/> 
  </br>
  </br>
  <table  border="1"  width="80%" align="center">
     <tr>
       <td>RefMatiere</td><th>Matiere</th><th>Notes</th><td>Coefficient</td>
     </tr>
     <c:set var="total" value="${0}"/>
     <c:set var="totalCoef" value="${0}"/>
     <c:set var="moyenne" value="${0}"/>
     <c:forEach   items="${notes1}"   var="e">
         <tr>
              <td>${e.matiere.refMatiere}</td>
              <td>${e.matiere.description}</td>
              <td>${e.valeur}</td>
              <td>${e.matiere.coef}</td>
             
         </tr>
     <c:set var="total" value="${total + e.valeur}"/>
     <c:set var="totalCoef" value="${totalCoef + e.matiere.coef}"/>
     </c:forEach>
     <c:set var="moyenne" value="${total/(totalCoef*0.1)}"/>
     <tr>
     <td></td>
     <td>Total</td>
     <td>${total}</td>
     <td>${totalCoef} </td>
     </tr>
     <tr>
     <td>Moyenne</td>
     <td>${moyenne}</td>
     </tr>
     <td></td>
     <td></td>
  </table>
  
 </form>

</body>
</html>