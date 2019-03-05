package fr.iocean.dta.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Entreprise {

	@Id
	@GeneratedValue
	private Long id;
	private String nomEntreprise;
	@OneToMany(mappedBy = "entreprise")
	private List<Employee> listEmployees;

	public Entreprise() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomEntreprise() {
		return nomEntreprise;
	}

	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}

	public List<Employee> getListEmployees() {
		return listEmployees;
	}

	public void setListEmployees(List<Employee> listEmployees) {
		this.listEmployees = listEmployees;
	}

	@Override
	public String toString() {
		return "Entreprise [identifiant=" + id + ", nomEntreprise=" + nomEntreprise + ", listEmployees="
				+ listEmployees + "]";
	}

}
