package metier;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.entities.Etudiant;
import metier.entities.Matiere;
import metier.entities.Notes;
import metier.entities.Paiement;

@Stateless
public class EtudiantEJBImpl implements EtudiantRemote,EtudiantLocal{

	@PersistenceContext
	private EntityManager  em;
	
	@Override
	public Etudiant addEtudiant(Etudiant etu) {
		// TODO Auto-generated method stub
		em.persist(etu);
		return etu;
		
	}

	@Override
	public Etudiant getEtudiant(Long refEtudiant) {
		// TODO Auto-generated method stub
		Etudiant etu = em.find(Etudiant.class, refEtudiant);
	    if (etu==null) throw new RuntimeException("Etudiant Introuvable");
		return etu;
		}

	@SuppressWarnings("unchecked")
	@Override
	public List<Etudiant> listeEtudiant() {
		// TODO Auto-generated method stub
		Query req = em.createQuery("select e from Etudiant e");
		return req.getResultList();
	}

	@Override
	public void SuprimerEtudiant(Long refEtudiant) {
		// TODO Auto-generated method stub
		Etudiant etu = em.find(Etudiant.class, refEtudiant);
		  if (etu==null) throw new RuntimeException("Etudiant Introuvable");
		  em.remove(etu);
		  
	}
	
	

	@SuppressWarnings("unused")
	@Override
	public void ModifierEtudiant(Long refEtudiant,Etudiant et) {
		// TODO Auto-generated method stub
		  Etudiant etu = em.find(Etudiant.class, refEtudiant);
		   etu.setPrenom(et.getPrenom());
		   etu.setNom(et.getNom());
		   etu.setDepartement(et.getDepartement());		   
		   etu.setGroupe(et.getGroupe());
		   etu.setScolarite(et.getScolarite());
		   etu.setCode(et.getCode());
		   if (etu==null) throw new RuntimeException("Etudiant Introuvable");
		   em.persist(etu);

	}

	@Override
	public Paiement addPaiement(Paiement p,Long refEtudiant) {
		// TODO Auto-generated method stub
		Etudiant et=em.find(Etudiant.class,refEtudiant);
		p.setEtudiant(et);
		em.persist(p);
		return p;
	}

	@Override
	public Paiement getPaiement(Long refPaiement) {
		// TODO Auto-generated method stub
		Paiement p = em.find(Paiement.class, refPaiement);
		if (p==null) throw new RuntimeException("Paiement Introuvable");
		return p;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Paiement> listePaiement() {
		// TODO Auto-generated method stub
		Query req = em.createQuery("select e from Paiement e");
		return req.getResultList();
	}

	@Override
	public void SuprimerPaiement(Long refPaiement) {
		// TODO Auto-generated method stub
		Paiement p = em.find(Paiement.class, refPaiement);
		if (p==null) throw new RuntimeException("Paiement Introuvable");
	   em.remove(p);
	}

	@Override
	public void ModifierPaiement(Long refPaiement,Paiement paie) {
		// TODO Auto-generated method stub
		Paiement p = em.find(Paiement.class,refPaiement);
	    p.setMontant(paie.getMontant());
 	    p.setDatePaiement(paie.getDatePaiement());		   
 	    p.setMois(paie.getMois());
 	    p.setEtudiant(paie.getEtudiant());
	    em.persist(p);
	}

	@Override
	public Matiere addMatiere(Matiere m) {
		// TODO Auto-generated method stub
		em.persist(m);
		return m;
	}

	@Override
	public Matiere getMatiere(Long refMatiere) {
		// TODO Auto-generated method stub
		Matiere m = em.find(Matiere.class, refMatiere);
		if (m==null) throw new RuntimeException("Matiere Introuvable");
		return m;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Matiere> listeMatiere() {
		// TODO Auto-generated method stub
		Query req = em.createQuery("select e from Matiere e");
		return req.getResultList();
	}

	@Override
	public void SuprimerMatiere(Long refMatiere) {
		// TODO Auto-generated method stu
		Matiere m = em.find(Matiere.class, refMatiere);
		  if (m==null) throw new RuntimeException("Matiere Introuvable");
		  em.remove(m);
		}
	

	@Override
	public void ModifierMatiere(Long refMatiere,Matiere mat) {
		// TODO Auto-generated method stub
	   Matiere m = em.find(Matiere.class, refMatiere);
	   m.setDescription(mat.getDescription());
	   m.setCoef(mat.getCoef());
	   em.persist(m);
	}

	@Override
	public Notes addNotes(Notes no,Long refEtudiant,Long refMatiere) {
		// TODO Auto-generated method stub
		Etudiant et=em.find(Etudiant.class,refEtudiant);
		no.setEtudiant1(et);
		Matiere m=em.find(Matiere.class,refMatiere);
		no.setMatiere(m);
		em.persist(no);
		return no;
	}

	@Override
	public Notes getNotes(Long refNote) {
		// TODO Auto-generated method stub
		Notes no = em.find(Notes.class, refNote);
		if (no==null) throw new RuntimeException("Note Introuvable");
		return no;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Notes> listeNotes() {
		// TODO Auto-generated method stub
		Query req = em.createQuery("select e from Notes e");
		return req.getResultList();
	}

	@Override
	public void SuprimerNotes(Long refNote) {
		// TODO Auto-generated method stub
		Notes no = em.find(Notes.class, refNote);
		if (no==null) throw new RuntimeException("Note Introuvable");
	    em.remove(no);
	}

	@Override
	public void ModifierNotes(Long idNote,Notes no) {
		// TODO Auto-generated method stub
		Notes note = em.find(Notes.class, idNote);
		note.setMatiere(no.getMatiere());
        note.setEtudiant1(no.getEtudiant1());
   	    note.setValeur(no.getValeur());		   
	    em.persist(note);

	}

	@Override
	public List<Notes> listNotes1(Long refEtudiant) {
		// TODO Auto-generated method stub
		Query req = em.createQuery("select e from Notes e where e.etudiant1.refEtudiant=:x");
		req.setParameter("x", refEtudiant);
		return req.getResultList();
	}

	
	
}
