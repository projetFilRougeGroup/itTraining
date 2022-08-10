package com.training.entites;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Theme {

	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idTheme;
	
	private String nomTheme;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	private Theme supertheme = new Theme();

	
	@ManyToMany (cascade=CascadeType.PERSIST)
	private Set<Formation> formation = new HashSet<Formation>();
	
	
	
	public Theme() {
		
	}
	
	public Theme(long idTheme, String nomTheme) {
		super();
		this.idTheme = idTheme;
		this.nomTheme = nomTheme;
	}
	
	public Theme(String nomTheme) {
		super();
		this.nomTheme=nomTheme;
	}

	public long getIdTheme() {
		return idTheme;
	}

	public void setIdTheme(long idTheme) {
		this.idTheme = idTheme;
	}

	public String getNomTheme() {
		return nomTheme;
	}

	public void setNomTheme(String nomTheme) {
		this.nomTheme = nomTheme;
	}

//	public Theme getSupertheme() {
//		return supertheme;
//	}
//
//	public void setSupertheme(Theme supertheme) {
//		this.supertheme = supertheme;
//	}

	public Set<Formation> getFormation() {
		return formation;
	}

	public void setFormation(Set<Formation> formation) {
		this.formation = formation;
	}

	@Override
	public String toString() {
		return "Theme [idTheme=" + idTheme + ", nomTheme=" + nomTheme + ", formation="
				+ formation + "]";
	}
	
}
