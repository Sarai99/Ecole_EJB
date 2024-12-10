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
            <h1 class="entete">UNIQ University- Page des Paiements</h1>
            <nav class="navbar">
               <ul>
                <li><a  href="VueEtudiant1.jsp" >Etudiant</a></li>
                <li><a  href="VueMatiere.jsp" >Matiere</a></li>
                <li><a  href="VuePaiment.jsp">Paiement</a></li>
                <li><a  href="VueNotes.jsp" >Notes</a></li> 
               </ul> 
            </nav>
    </header>

 <div class="container col-md-6" style="background-color:#6cbe6f;border-radius:30px;">
    </br>

  <form action="controleur3" method="get"  name="form3">
  <div class="container col-md-7" >
  <h1>Paiement</h1>
  <div class="row">
  
  <table>
  <tr>
    <td> Reference   :</td> <td> <input type="text"  name="refPaiement" value ="${refPaiement}"></td>
   </tr>
    <td>Montant	     :</td> <td> <input type="text"  name="montant"  value ="${montant}"></td>
   </tr>
   <tr>
    <td> DatePaiement  	  :</td> <td> <input type="text"  name="datePaiement" value ="${datePaiement}" ></td>
   </tr>  
   <tr>
   <tr>
     <td>Mois    :</td> <td> <input type="text"  name="mois" value ="${mois}"></td>
     </tr>
   <tr>
     <td>Reference :</td> <td> <input type="text"  name="refEtudiant" value ="${refEtudiant}"></td>
    </tr>
    </table>
   </div>
  </br>
 
	<table>
    <tr>
    <td class= "td"> <input  type="submit"  value="Ajouter"  name="action3" class="button"></td>
    <td class= "td"> <input  type="submit"  value="Modifier"  name="action3" class="button"></td>
     <td class= "td"> <input  type="submit"  value="Recherche"  name="action3" class="button"></td> 
    <td class= "td"> <input  type="submit"  value="Lister"  name="action3" class="button"></td>
    </tr>
     
     </table>
     </br>
     </div>
    </form> 
    
    </div>
 
  <form action="controleur3" method="get"  name="form3">
  <hr/>
 
  </br>
  </br>
  <table  border="1"  width="80%" align="center">
     <tr>
       <th>ID</th><th>MontantPaiement</th><th>DatePaiement</th><th>Mois</th><th>ReferenceEtudiant</th><th>Consultation</th><th>Suppression</th>
     </tr>
     <c:forEach   items="${paiement}"   var="e">
         <tr>
              <td>${e.refPaiement}</td>
              <td>${e.montant}</td>
              <td>${e.datePaiement}</td>
              <td>${e.mois}</td>
              <td>${e.etudiant.refEtudiant}</td>
              <td><a href="controleur3?montant=hdfjfb&datePaiement=tgfhj&mois=mni&etudiant.refEtudiant=1L&refPaiement=${e.refPaiement}&action3=Consulter" name="action3" style="color:black;text-decoration:none;border-radius:5px; box-shadow:1px 1px 1px 1px #5e689f;">Consulter</a></td>
              <td><a href="controleur3?montant=hdfjfb&datePaiement=tgfhj&mois=mni&etudiant.refEtudiant=1L&refPaiement=${e.refPaiement}&action3=Supprimer" name="action3" style="color:black;text-decoration:none;border-radius:5px; box-shadow:1px 1px 1px 1px #5e689f;">Supprimer</a></td>
       
         </tr>
     </c:forEach>
  </table>
  
 </form>

</body>
</html>