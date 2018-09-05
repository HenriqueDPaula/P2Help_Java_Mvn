package model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AGENDA")
public class Agenda implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2009650666198404555L;

	@EmbeddedId
	private AgendaPK idagenda;
	
	

	@ManyToOne
	@JoinColumn(name = "IDUSUARIO", nullable = true)
	private Usuario usuario;

	public Agenda() {

	}

	public AgendaPK getIdagenda() {
		return idagenda;
	}

	public void setIdagenda(AgendaPK idagenda) {
		this.idagenda = idagenda;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idagenda == null) ? 0 : idagenda.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Agenda))
			return false;
		Agenda other = (Agenda) obj;
		if (idagenda == null) {
			if (other.idagenda != null)
				return false;
		} else if (!idagenda.equals(other.idagenda))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

}