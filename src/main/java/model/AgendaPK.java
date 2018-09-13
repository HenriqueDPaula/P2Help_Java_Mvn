package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe para definir as chaves primárias(compostas) da classe Agenda
 **/
@Embeddable
public class AgendaPK implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8913733314598981150L;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATA_HORA", nullable = false)
	private Date dataEhora;

	@ManyToOne
	@JoinColumn(name = "IDOFERTA")
	private Oferta oferta;

	public AgendaPK() {

	}

	public AgendaPK(Date dataHora, Oferta oferta) {
		this.dataEhora = dataHora;
		this.oferta = oferta;
	}

	public Date getDataEhora() {
		return dataEhora;
	}

	public void setDataEhora(Date dataEhora) {
		this.dataEhora = dataEhora;

	}

	/**
	 * @return the oferta
	 */
	public Oferta getOferta() {
		return oferta;
	}

	/**
	 * @param oferta
	 *            the oferta to set
	 */
	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
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
		result = prime * result + ((dataEhora == null) ? 0 : dataEhora.hashCode());
		result = prime * result + ((oferta == null) ? 0 : oferta.hashCode());
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
		if (!(obj instanceof AgendaPK))
			return false;
		AgendaPK other = (AgendaPK) obj;
		if (dataEhora == null) {
			if (other.dataEhora != null)
				return false;
		} else if (!dataEhora.equals(other.dataEhora))
			return false;
		if (oferta == null) {
			if (other.oferta != null)
				return false;
		} else if (!oferta.equals(other.oferta))
			return false;
		return true;
	}

}