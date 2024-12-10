package metier.entities;


import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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
public class Etudiant implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long refEtudiant;
	private String prenom;
	private String  nom;
	private String departement;
	private double scolarite;
	private String groupe;
	private String code;
	
    @OneToMany(mappedBy="etudiant", orphanRemoval = true, cascade= CascadeType.PERSIST)
    private Collection<Paiement>  paiement;
	
    
    @OneToMany(mappedBy="etudiant1" ,orphanRemoval = true, cascade= CascadeType.PERSIST)
    private Collection<Notes>  note;
	
	@Override
	public String toString() {
		return ""+ refEtudiant+"";
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDepartement() {
		return departement;
	}
	public void setDepartement(String departement) {
		this.departement = departement;
	}
	public double getScolarite() {
		return scolarite;
	}
	public void setScolarite(double scolarite) {
		this.scolarite = scolarite;
	}
	public String getGroupe() {
		return groupe;
	}
	public void setGroupe(String groupe) {
		this.groupe = groupe;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Etudiant() {
		super();
	}
	public Etudiant(String prenom, String nom, String departement,
			double scolarite, String groupe, String code) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.departement = departement;
		this.scolarite = scolarite;
		this.groupe = groupe;
		this.code = code;
	}
	public Long getRefEtudiant() {
		return refEtudiant;
	}
	public void setRefEtudiant(Long refEtudiant) {
		this.refEtudiant = refEtudiant;
	}
	

}
