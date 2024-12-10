import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import metier.EtudiantLocal;
import metier.entities.Etudiant;
import metier.entities.Matiere;
import metier.entities.Notes;
import metier.entities.Paiement;

@WebService
public class EcoleService {
	@EJB
	private  EtudiantLocal   metier ;
	@WebMethod
	public Etudiant addEtudiant(
			@WebParam(name="prenom") String prenom,
			@WebParam(name="nom") String  nom,
			@WebParam(name="departement")String departement,
			@WebParam(name="scolarite")double scolarite,
			@WebParam(name="groupe")String groupe,
			@WebParam(name="code")String code
			) {
		
		return metier.addEtudiant(new Etudiant(prenom,nom,departement,scolarite,groupe,code));
	}
	@WebMethod
	public Etudiant getEtudiant(
			@WebParam(name="refEtudiant")Long refEtudiant
			) {
		return metier.getEtudiant(refEtudiant);
	}
	@WebMethod
	public List<Etudiant> listeEtudiant() {
		return metier.listeEtudiant();
	}
	@WebMethod
	public void SuprimerEtudiant(
			@WebParam (name="refEtudiant") Long refEtudiant
			) {
		metier.SuprimerEtudiant(refEtudiant);
	}
	@WebMethod
	public void ModifierEtudiant(
			@WebParam(name="refEtudiant") Long refEtudiant,
			@WebParam(name="prenom") String prenom,
			@WebParam(name="nom") String  nom,
			@WebParam(name="departement")String departement,
			@WebParam(name="scolarite")double scolarite,
			@WebParam(name="groupe")String groupe,
			@WebParam(name="code")String code
			) {
		metier.ModifierEtudiant(refEtudiant,new Etudiant(prenom,nom,departement,scolarite,groupe,code));
	}

	@WebMethod
	public Paiement addPaiement(
			@WebParam(name="montant") double montant,
			@WebParam(name="datePaiemnt") java.sql.Date datePaiement, 
			@WebParam (name="mois")String mois,
			@WebParam(name="refEtudiant") Long refEtudiant
			) {
		 datePaiement = (java.sql.Date) new Date();
		return metier.addPaiement(new Paiement(montant,datePaiement,mois),refEtudiant);
	}
	@WebMethod
	public Paiement getPaiement(
			@WebParam(name="refPaiement")Long refPaiement
			) {
		return metier.getPaiement(refPaiement);
	}
    @WebMethod
	public List<Paiement> listePaiement() {
		return metier.listePaiement();
	}
    @WebMethod
	public void SuprimerPaiement(
			@WebParam(name="refPaiement") Long refPaiement
			) {
		metier.SuprimerPaiement(refPaiement);
	}
    @WebMethod
	public void ModifierPaiement(
			@WebParam(name="refPaiement") Long refPaiement,
			@WebParam(name="montant") double montant,
			@WebParam(name="datePaiemnt") java.sql.Date datePaiement, 
			@WebParam (name="mois")String mois
			) {
		
		metier.ModifierPaiement(refPaiement,new Paiement(montant,datePaiement,mois));
	}

    
    @WebMethod
	public Matiere addMatiere(
			@WebParam(name="refMatiere") Long refMatiere,
			@WebParam(name="description") String description,
			@WebParam(name="coef") Long coef
			) {
    	Matiere m = new Matiere();
    	  m.setDescription(description);
    	  m.setCoef(coef);
		return metier.addMatiere(m);
	}
    @WebMethod
	public Matiere getMatiere(
			@WebParam(name="refMatiere")Long refMatiere
			) {
		return metier.getMatiere(refMatiere);
	}
    @WebMethod
	public List<Matiere> listeMatiere() {
		return metier.listeMatiere();
	}
    @WebMethod
	public void SuprimerMatiere(
			@WebParam(name="refMatiere")Long refMatiere
			) {
		metier.SuprimerMatiere(refMatiere);
	}
    @WebMethod
	public void ModifierMatiere(
			@WebParam(name="refMatiere") Long refMatiere,
			@WebParam(name="description") String description,
			@WebParam(name="coef") Long coef
			) {
		Matiere m = new Matiere();
  	    m.setDescription(description);
  	    m.setCoef(coef);
		metier.ModifierMatiere(refMatiere,m);
	}
    
    @WebMethod
	public Notes addNotes(
			@WebParam(name="idNote") Long idNote,
			@WebParam(name="valeur") double valeur,
			@WebParam(name="refEtudiant") Long refEtudiant,
			@WebParam(name="refMatiere") Long refMatiere
			) {
		return metier.addNotes(new Notes( valeur),refEtudiant,refMatiere);
	}
    @WebMethod
	public Notes getNotes(
			@WebParam(name="idNote")Long refNote
			) {
		return metier.getNotes(refNote);
	}
    @WebMethod
	public List<Notes> listeNotes() {
		return metier.listeNotes();
	}
    @WebMethod
	public void SuprimerNotes(
			@WebParam(name="idNote") Long refNote
			) {
		metier.SuprimerNotes(refNote);
	}
    @WebMethod
	public void ModifierNotes(
			@WebParam(name="idNote") Long idNote,
			@WebParam(name="valeur") double valeur
			) {
		metier.ModifierNotes(idNote,new Notes(valeur));
	} 
	
}
