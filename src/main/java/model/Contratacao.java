package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CONTRATACAO")
public class Contratacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3450470364290060049L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "contratacao_sequence")
	@SequenceGenerator(name = "contratacao_sequence", sequenceName = "contratacao_sequence")
	@Column(name = "IDCONTRATACAO", nullable = false)
	private Integer idcontratacao;

	@OneToOne
	@JoinColumns({ @JoinColumn(name = "IDOFERTA", referencedColumnName = "IDOFERTA"),
			@JoinColumn(name = "DATA_HORA", referencedColumnName = "DATA_HORA"), })
	private Agenda agenda;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATA_CONTRATACAO", nullable = false)
	private Date dataContratacao;

	@Column(name = "STATUS", length = 20, nullable = false)
	private char status;

	public Contratacao() {

	}

	public Contratacao(Agenda agenda, Date data, char status) {
		this.agenda = agenda;
		this.dataContratacao = data;
		this.status = status;
	}

	/**
	 * @return the idcontratacao
	 */
	public Integer getIdcontratacao() {
		return idcontratacao;
	}

	/**
	 * @param idcontratacao
	 *            the idcontratacao to set
	 */
	public void setIdcontratacao(Integer idcontratacao) {
		this.idcontratacao = idcontratacao;
	}

	public Agenda getAgenda() {
		return agenda;
	}

	/**
	 * @param idcontratacao
	 *            the idcontratacao to set
	 */
	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	/**
	 * @return the dataContratacao
	 */
	public Date getDataContratacao() {
		return dataContratacao;
	}

	/**
	 * @param dataContratacao
	 *            the dataContratacao to set
	 */
	public void setDataContratacao(Date dataContratacao) {
		this.dataContratacao = dataContratacao;
	}

	/**
	 * @return the status
	 */
	public char getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(char status) {
		this.status = status;
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
		result = prime * result + ((agenda == null) ? 0 : agenda.hashCode());
		result = prime * result + ((dataContratacao == null) ? 0 : dataContratacao.hashCode());
		result = prime * result + ((idcontratacao == null) ? 0 : idcontratacao.hashCode());
		result = prime * result + status;
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
		if (!(obj instanceof Contratacao))
			return false;
		Contratacao other = (Contratacao) obj;
		if (agenda == null) {
			if (other.agenda != null)
				return false;
		} else if (!agenda.equals(other.agenda))
			return false;
		if (dataContratacao == null) {
			if (other.dataContratacao != null)
				return false;
		} else if (!dataContratacao.equals(other.dataContratacao))
			return false;
		if (idcontratacao == null) {
			if (other.idcontratacao != null)
				return false;
		} else if (!idcontratacao.equals(other.idcontratacao))
			return false;
		if (status != other.status)
			return false;
		return true;
	}

}