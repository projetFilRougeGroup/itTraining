package com.training.util;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import com.training.entites.Session;
import com.training.entites.Stagiaire;

@Embeddable
public class EvaluationId implements Serializable {

	@Column(name = "idSession")
	private Long IdSession;
	
	@Column(name = "IdStagiaire")
	private Long IdStagiaire;

	public EvaluationId() {
		super();
	}	
	
	
	public EvaluationId(Long idSession, Long idStagiaire) {
		super();
		IdSession = idSession;
		IdStagiaire = idStagiaire;
	}

	public Long getIdSession() {
		return IdSession;
	}

	public void setIdSession(Long idSession) {
		IdSession = idSession;
	}

	public Long getIdStagiaire() {
		return IdStagiaire;
	}

	public void setIdStagiaire(Long idStagiaire) {
		IdStagiaire = idStagiaire;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((IdSession == null) ? 0 : IdSession.hashCode());
		result = prime * result + ((IdStagiaire == null) ? 0 : IdStagiaire.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EvaluationId other = (EvaluationId) obj;
		if (IdSession == null) {
			if (other.IdSession != null)
				return false;
		} else if (!IdSession.equals(other.IdSession))
			return false;
		if (IdStagiaire == null) {
			if (other.IdStagiaire != null)
				return false;
		} else if (!IdStagiaire.equals(other.IdStagiaire))
			return false;
		return true;
	}

	}
