package metier.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Paiement implements Serializable{
  @Id	
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long refPaiement;

  private double montant;
  private Date datePaiement;
  private String mois;
  @ManyToOne
  @JoinColumn(name="refEtudiant")
  private Etudiant etudiant;
    
 
public Etudiant getEtudiant() {
	return etudiant;
}
public void setEtudiant(Etudiant etudiant) {
	this.etudiant = etudiant;
}
public Long getRefPaiement() {
	return refPaiement;
}
public void setRefPaiement(Long refPaiement) {
	this.refPaiement = refPaiement;
}
public double getMontant() {
	return montant;
}
public void setMontant(double montant) {
	this.montant = montant;
}
public Date getDatePaiement() {
	return datePaiement;
}
public void setDatePaiement(Date datePaiement) {
	this.datePaiement = datePaiement;
}
public String getMois() {
	return mois;
}
public void setMois(String mois) {
	this.mois = mois;
}
public Paiement(double montant, Date datePaiement, String mois) {
	super();
	this.montant = montant;
	this.datePaiement = datePaiement;
	this.mois = mois;
}
public Paiement() {
	super();
}
  
}
