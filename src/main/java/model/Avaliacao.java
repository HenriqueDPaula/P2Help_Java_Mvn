
package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "AVALIACAO")
public class Avaliacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5260819040137629327L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "avaliacao_sequence")
	@SequenceGenerator(name = "avaliacao_sequence", sequenceName = "avaliacao_sequence")
	@Column(name = "IDAVALIACAO", nullable = false)
	private Integer idavaliacao;

	@OneToOne()
	@JoinColumn(name = "IDCONTRATACAO")
	private Contratacao idcontratacao;

	@Column(name = "NOTA_ATENDIMENTO", nullable = true)
	private Integer atendimento;

	@Column(name = "NOTA_SERVICO", nullable = true)
	private Integer servico;

	@Column(name = "COMENTARIO", nullable = true)
	private String comentario;

	public Avaliacao() {

	}

	// public Contratacao getIdcontratacao() {
	// return idcontratacao;
	// }
	//
	// public void setIdcontratacao(Contratacao idcontratacao) {
	// this.idcontratacao = idcontratacao;
	// }

	public Integer getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Integer atendimento) {
		this.atendimento = atendimento;
	}

	public Integer getServico() {
		return servico;
	}

	public void setServico(Integer servico) {
		this.servico = servico;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
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
		result = prime * result + ((atendimento == null) ? 0 : atendimento.hashCode());
		result = prime * result + ((comentario == null) ? 0 : comentario.hashCode());
		result = prime * result + ((idcontratacao == null) ? 0 : idcontratacao.hashCode());

		result = prime * result + ((servico == null) ? 0 : servico.hashCode());
		return result;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the contratacao
	 */
	public Contratacao getContratacao() {
		return idcontratacao;
	}

	/**
	 * @param contratacao
	 *            the contratacao to set
	 */
	public void setContratacao(Contratacao contratacao) {
		this.idcontratacao = contratacao;
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
		if (!(obj instanceof Avaliacao))
			return false;
		Avaliacao other = (Avaliacao) obj;
		if (atendimento == null) {
			if (other.atendimento != null)
				return false;
		} else if (!atendimento.equals(other.atendimento))
			return false;
		if (comentario == null) {
			if (other.comentario != null)
				return false;
		} else if (!comentario.equals(other.comentario))
			return false;
		if (idcontratacao == null) {
			if (other.idcontratacao != null)
				return false;
		} else if (!idcontratacao.equals(other.idcontratacao))
			return false;

		if (servico == null) {
			if (other.servico != null)
				return false;
		} else if (!servico.equals(other.servico))
			return false;
		return true;
	}

	/**
	 * @return the idcontratacao
	 */
	public Contratacao getIdcontratacao() {
		return idcontratacao;
	}

	/**
	 * @param idcontratacao
	 *            the idcontratacao to set
	 */
	public void setIdcontratacao(Contratacao idcontratacao) {
		this.idcontratacao = idcontratacao;
	}

	/**
	 * @return the idavaliacao
	 */
	public Integer getIdavaliacao() {
		return idavaliacao;
	}

	/**
	 * @param idavaliacao
	 *            the idavaliacao to set
	 */
	public void setIdavaliacao(Integer idavaliacao) {
		this.idavaliacao = idavaliacao;
	}

	//
	// @Entity
	// @Table(name = "TBL_PESSOA")
	// public class Pessoa {
	// @Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	// @Column(name = "PK_PESSOA")
	// private Long id;
	//
	// @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL,
	// fetch = FetchType.LAZY, optional = true)
	// private Pet pet;
	// }
	//
	// @Entity
	// @Table(name = "TBL_PET")
	// public class Pet {
	// @Id
	// private Long id;
	//
	// @MapsId
	// @OneToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name = "PK_PESSOA")
	// private Pessoa pessoa;
	//
	// }
	// Equals and HashCode
}