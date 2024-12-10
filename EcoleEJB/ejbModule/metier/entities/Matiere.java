package metier.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Matiere implements Serializable{
	@Override
	public String toString() {
		return "" + refMatiere + "";
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long refMatiere;
    private String description;
    private Long coef;
    
    @OneToMany(mappedBy="matiere",orphanRemoval = true, cascade= CascadeType.PERSIST)
    private Collection<Notes>  note;
	
    
	public Long getRefMatiere() {
		return refMatiere;
	}
	public void setRefMatiere(Long refMatiere) {
		this.refMatiere = refMatiere;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getCoef() {
		return coef;
	}
	public void setCoef(Long coef) {
		this.coef = coef;
	}
   
    
    
}
