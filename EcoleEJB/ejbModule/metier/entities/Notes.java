package metier.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Notes implements Serializable {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private Long idNote;
   
 public Matiere getMatiere() {
	return matiere;
}


public void setMatiere(Matiere matiere) {
	this.matiere = matiere;
}


private double valeur;
   
 
   
   public Notes() {
	super();
}
  

public Notes(double valeur) {
	super();
	this.valeur = valeur;
}


@ManyToOne
   @JoinColumn(name="refEtudiant")
   private Etudiant etudiant1;

@ManyToOne
@JoinColumn(name="refMatiere")
private Matiere matiere;



public Long getIdNote() {
	return idNote;
}


public void setIdNote(Long idNote) {
	this.idNote = idNote;
}


public Etudiant getEtudiant1() {
	return etudiant1;
}


public void setEtudiant1(Etudiant etudiant1) {
	this.etudiant1 = etudiant1;
}


public double getValeur() {
	return valeur;
}


public void setValeur(double valeur) {
	this.valeur = valeur;
}
   
}
