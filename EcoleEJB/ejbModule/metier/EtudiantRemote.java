package metier;

import java.util.List;

import javax.ejb.Remote;

import metier.entities.Etudiant;
import metier.entities.Matiere;
import metier.entities.Notes;
import metier.entities.Paiement;

@Remote
public interface EtudiantRemote {
    public Etudiant addEtudiant(Etudiant etu);
    public Etudiant getEtudiant(Long refEtudiant);
    public List<Etudiant> listeEtudiant();
    public void SuprimerEtudiant(Long refEtudiant);
    public void ModifierEtudiant(Long refEtudiant,Etudiant et);

    public Paiement addPaiement(Paiement p, Long refEtudiant);
    public Paiement getPaiement(Long refPaiement);
    public List<Paiement> listePaiement();
    public void SuprimerPaiement(Long refPaiement);
    public void ModifierPaiement(Long refPaiement,Paiement paie);

    public Matiere   addMatiere(Matiere  m);
    public Matiere getMatiere(Long refMatiere);
    public List<Matiere> listeMatiere();
    public void SuprimerMatiere(Long refMatiere);
    public void ModifierMatiere(Long refMatiere,Matiere mat);

    public Notes   addNotes(Notes  no,Long refEtudiant,Long refMatiere);
    public Notes getNotes(Long refNote);
    public List<Notes> listeNotes();
    public void SuprimerNotes(Long refNote);
    public void ModifierNotes(Long refNote,Notes no);

    public List<Notes> listNotes1(Long refEtudiant);
    
    
}


