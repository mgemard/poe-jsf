package poe.jsf;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class HelloBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nom;

	public String getNom() {

		return nom;

	}

	public void setNom(String nom) {

		this.nom = nom;

	}

}
