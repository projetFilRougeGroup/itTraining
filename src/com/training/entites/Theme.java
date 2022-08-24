package com.training.entites;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Theme implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 3314484641330329423L;

	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idTheme;
	
	private String nomTheme;

	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="idSupertheme")
	private Theme supertheme;

	@OneToMany(mappedBy="supertheme")
	private Set<Theme> soustheme;// = new HashSet<Employee>();

	@ManyToMany (cascade=CascadeType.PERSIST)
	private Set<Formation> formation = new HashSet<Formation>();
	
	
	
	public Theme() {
		super();
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

	public Theme getSupertheme() {
		return supertheme;
	}

	public void setSupertheme(Theme supertheme) {
		this.supertheme = supertheme;
		supertheme.getSoustheme().add(this);
	}
	public Set<Theme> getSoustheme() {
		return soustheme;
	}

	public void setSoustheme(Set<Theme> soustheme) {
		this.soustheme = soustheme;
	}

	public Set<Formation> getFormation() {
		return formation;
	}

	public void setFormation(Set<Formation> formation) {
		this.formation = formation;
	}

	@Override
	public int hashCode() {
		return Objects.hash( idTheme, nomTheme);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Theme other = (Theme) obj;
		try {
			return (idTheme == other.idTheme)	&& Objects.equals(nomTheme, other.nomTheme);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public String toString() {
		return "Theme [idTheme=" + idTheme + ", nomTheme=" + nomTheme + ", formation=" 	+ formation + ", supertheme=" 	+ supertheme.toString() + "]";
	}
	
}
