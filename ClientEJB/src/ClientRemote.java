import java.sql.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import metier.EtudiantRemote;
import metier.entities.Etudiant;
import metier.entities.Matiere;
import metier.entities.Notes;
import metier.entities.Paiement;

public class ClientRemote {
    public static void main(String[] args) {
    	
        try {
 	Context  ctx = new InitialContext();
 	String appName = "";
 	String moduleName="EcoleEJB";
 	String beanName = "EtudiantEJBImpl";
 	String remoteInterface=EtudiantRemote.class.getName();
 	String name= "ejb:"+appName+"/"+moduleName+"/"+beanName+ "!"+remoteInterface;		
 	EtudiantRemote proxy = (EtudiantRemote)ctx.lookup(name);

 	 //proxy.addEtudiant(new Etudiant("Sarai","Dieudonne","OUEST",2500.00,"Groupe A","DI183310"));
 	//proxy.ModifierEtudiant(1L,new Etudiant("Makensy","Saint Louis","OUEST",2500.00,"Groupe B","ST190234"));
 	//proxy.SuprimerEtudiant(1L);
 	
	
    
 	  //proxy.addPaiement(new Paiement(2000,null,"Janvier"),1L);
 	//proxy.addPaiement(new Paiement());
 	//proxy.addPaiement(new Paiement());
 	  
 	    Matiere m = new Matiere();
	    m.setDescription("");
	    m.setCoef(1l);
 	 // proxy.addMatiere(m);
 	//proxy.addMatiere(new Matiere());
 	//proxy.addMatiere(new Matiere());
 	
 	 proxy.addNotes(new Notes(100),1L,1L);
 	//proxy.addNotes(new Notes());
 	//proxy.addNotes(new Notes());


 	List<Etudiant> liste = proxy.listeEtudiant();
    for (Etudiant et:liste){
	System.out.println(et.getRefEtudiant()+"|"+et.getPrenom()+"|"+et.getNom()+"|"+et.getDepartement()+"|"+ et.getGroupe()+"|"+ et.getScolarite()+ "|"+et.getCode());
    }
	
	List<Paiement> listeP = proxy.listePaiement();
	for (Paiement paie:listeP){
		System.out.println(paie.getRefPaiement()+"|"+paie.getMontant()+"|"+paie.getDatePaiement()+"|"+paie.getMois()+"|"+paie.getEtudiant());
	  }
	
	List<Matiere> listem = proxy.listeMatiere();
	for (Matiere mat:listem){
		System.out.println(mat.getRefMatiere()+"|"+mat.getDescription()+"|"+mat.getCoef());
	  }
	
	List<Notes> listen = proxy.listeNotes();
	for (Notes no:listen){
		System.out.println(no.getIdNote()+"|"+no.getMatiere()+"|"+no.getEtudiant1()+"|"+no.getValeur());
	  }
         } catch (NamingException e) {
 	    e.printStackTrace(); 
         }		
      }

	@Override
	public String toString() {
		return "ClientRemote []";
	}

}
