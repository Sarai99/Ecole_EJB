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
            <h1 class="entete">UNIQ University- Page des Etudiants</h1>
            <nav class="navbar">
               <ul>
                <li><a  href="VueEtudiant1.jsp" >Etudiant</a></li>
                <li><a  href="VueMatiere.jsp" >Matiere</a></li>
                <li><a  href="VuePaiment.jsp">Paiement</a></li>
                <li><a  href="VueNotes.jsp" >Notes</a></li> 
                <li><a  href="BulletinEtudiant.jsp" >BulletinEtudiant</a></li> 
               </ul> 
            </nav>
    </header>


  
  
   <div class="container col-md-6" style="background-color:#6cbe6f; border-radius:30px;">

    </br>
  
  <form action="controleur1" method="get"  name="form1">
  <div class="container col-md-7" >
  <h1>Etudiant</h1>
  <div class="row">
 
    <table>
  <tr>
    <td> Reference  :</td> <td> <input type="text"  name="refEtudiant" value ="${refEtudiant}"></td>
   </tr>
  <tr>
    <td> Prenom     :</td> <td> <input type="text"  name="prenom" value ="${prenom}" ></td>
   </tr>  
   <tr>
    <td>Nom	      :</td> <td> <input type="text"  name="nom"  value ="${nom}"></td>
   </tr>
   <tr>
     <td>Departement  :</td> <td> <input type="text"  name="departement" value ="${departement}"></td>
    </tr>
     <tr>
     <td>Scolarite    :</td> <td> <input type="text"  name="scolarite" value ="${scolarite}"></td>
     </tr>
     <tr>
     <td>Groupe        :</td> <td> <input type="text"  name="groupe" value ="${groupe}"></td>
     </tr>
     <tr>
     <td>Code      :</td> <td> <input type="text"  name="code" value ="${code}"></td>
    </tr>
    </table>
   </div>
  </br>
   <table>
    <tr>
    <td class= "td"> <input  type="submit"  value="Ajouter"  name="action1" class="button"></td>
    <td class= "td"> <input  type="submit"  value="Modifier"  name="action1" class="button"></td>
     <td class= "td"> <input  type="submit"  value="Recherche"  name="action1" class="button"></td> 
    <td class= "td"> <input  type="submit"  value="Lister"  name="action1" class="button"></td>
    </tr>
     
     </table>
     </br>
     </div>
    </form> 
    
    </div>
  
    
    
   <form action="controleur1" method="get"  name="form11">
   
     <hr/>
 
  </br>
  </br>
  <table  border="1"  width="80%" align="center">
     <tr>
       <th>ID</th><th>PrenomEtudiant</th><th>NomEtudiant</th><th>Departement</th><th>Scolarite</th><th>Groupe</th><th>Code</th><th>Consultation</th><th>Suppression</th>
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
              <td><a href="controleur1?prenom=tgfhj&nom=hdfjfb&departement=yugf&scolarite=45.7&groupe=uyg&code=hgfd&refEtudiant=${e.refEtudiant}&action1=Consulter" name="action1" style="color:black;text-decoration:none;border-radius:5px; box-shadow:1px 1px 1px 1px #5e689f;">Consulter</a></td>
              <td><a href="controleur1?prenom=tgfhj&nom=hdfjfb&departement=yugf&scolarite=45.7&groupe=uyg&code=hgfd&refEtudiant=${e.refEtudiant}&action1=Supprimer" name="action1" style="color:black;text-decoration:none;border-radius:5px; box-shadow:1px 1px 1px 1px #5e689f;">Supprimer</a></td>
       
         </tr>
     </c:forEach>
  </table>
  
 </form>

</body>
</html>