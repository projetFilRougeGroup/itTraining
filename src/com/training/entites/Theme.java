package com.training.entites;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Theme {

	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idTheme;
	private String nomTheme;
	
	@ManyToMany
	private Set<Theme> superthemes = new HashSet<Theme>();
	
	@ManyToMany (cascade=CascadeType.PERSIST,mappedBy="superthemes")
	private Set<Theme> sousthemes = new HashSet<Theme>();
	
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

	public Set<Theme> getSuperthemes() {
		return superthemes;
	}

	public void setSuperthemes(Set<Theme> superthemes) {
		this.superthemes = superthemes;
	}

	public Set<Theme> getSousthemes() {
		return sousthemes;
	}

	public void setSousthemes(Set<Theme> sousthemes) {
		this.sousthemes = sousthemes;
	}

	@Override
	public String toString() {
		return "Theme [idTheme=" + idTheme + ", nomTheme=" + nomTheme + ", superthemes=" + superthemes + ", sousthemes="
				+ sousthemes + "]";
	}


	
}
