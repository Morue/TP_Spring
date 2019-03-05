package fr.iocean.dta.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Employee {

	@Id
	@GeneratedValue
	private Long identifiant;
	private String prenom;
	private String nomEmployee;
	private String numSecu;
	private BigDecimal salaire;
	private LocalDate dateEmbauche;

	@ManyToOne
	private Entreprise entreprise;

	public Employee() {
		super();
	}

	public Employee(Long identifiant, String prenom, String nomEmployee, String numSecu, BigDecimal salaire,
			LocalDate dateEmbauche) {
		super();
		this.identifiant = identifiant;
		this.prenom = prenom;
		this.nomEmployee = nomEmployee;
		this.numSecu = numSecu;
		this.salaire = salaire;
		this.dateEmbauche = dateEmbauche;
	}

	public Long getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(Long identifiant) {
		this.identifiant = identifiant;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNomEmployee() {
		return nomEmployee;
	}

	public void setNomEmployee(String nomEmployee) {
		this.nomEmployee = nomEmployee;
	}

	public String getNumSecu() {
		return numSecu;
	}

	public void setNumSecu(String numSecu) {
		this.numSecu = numSecu;
	}

	public BigDecimal getSalaire() {
		return salaire;
	}

	public void setSalaire(BigDecimal salaire) {
		this.salaire = salaire;
	}

	public LocalDate getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(LocalDate dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	@Override
	public String toString() {
		return "Employee [identifiant=" + identifiant + ", prenom=" + prenom + ", nomEmployee=" + nomEmployee
				+ ", numSecu=" + numSecu + ", salaire=" + salaire + ", dateEmbauche=" + dateEmbauche + "]";
	}

}
