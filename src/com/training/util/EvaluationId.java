package com.training.util;

import java.io.Serializable;

public class EvaluationId  implements Serializable {

	private static final long serialVersionUID = 1L;

	private long idStagiaire;

	 private long idSession;

	 public EvaluationId() {
		super();

	}

	 public long getIdStagiaire() {
		return idStagiaire;
	}

	public void setIdStagiaire(long idStagiaire) {
		this.idStagiaire = idStagiaire;
	}

	public long getIdSession() {
		return idSession;
	}

	public void setIdSession(long idSession) {
		this.idSession = idSession;
	}

	public EvaluationId(long idStagiaire, long idSession) {
		super();
		this.idStagiaire = idStagiaire;
		this.idSession = idSession;
	}

	public int hashCode() {
	  return (int)(idStagiaire + idSession);
	 }

	 public boolean equals(Object object) {
	  if (object instanceof EvaluationId) {
		  EvaluationId otherId = (EvaluationId) object;
	   return (otherId.idSession == this.idSession) && (otherId.idStagiaire == this.idStagiaire);
	  }
	  return false;
	 }

	}
