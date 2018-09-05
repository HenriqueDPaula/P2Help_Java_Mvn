package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "OFERTAS")
public class Oferta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8683267419897556649L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "oferta_sequence")
	@SequenceGenerator(name = "oferta_sequence", sequenceName = "oferta_auto")
	@Column(name = "IDOFERTA", nullable = false)
	private Integer idoferta;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATA_OFERTA", nullable = false)
	private Date dataOferta;

	@Column(name = "VALOR_HORA", nullable = false)
	private float valorHora;

	@Column(name = "TITULO", length = 200, nullable = false)
	private String titulo;

	@Column(name = "DESCRICAO", length = 400, nullable = true)
	private String descricao;

	@ManyToOne
	@JoinColumn(name = "IDUSUARIO")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "IDCATEGORIA")
	private Categoria categoria;

	@Column(name = "STATUS", length = 20, nullable = false)
	private char status;

	@ManyToOne
	@JoinColumn(name = "IDSISTEMA")
	private Sistema sistema;

	public Oferta() {

	}

	public Integer getIdoferta() {
		return idoferta;
	}

	public void setIdoferta(Integer idoferta) {
		this.idoferta = idoferta;
	}

	public Date getDataOferta() {
		return dataOferta;
	}

	public void setDataOferta(Date dataOferta) {
		this.dataOferta = dataOferta;
	}

	public float getValorHora() {
		return valorHora;
	}

	public void setValorHora(float valorHora) {
		this.valorHora = valorHora;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Sistema getSistema() {
		return sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((dataOferta == null) ? 0 : dataOferta.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((idoferta == null) ? 0 : idoferta.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		result = prime * result + ((sistema == null) ? 0 : sistema.hashCode());
		result = prime * result + status;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		result = prime * result + Float.floatToIntBits(valorHora);
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
		if (getClass() != obj.getClass())
			return false;
		Oferta other = (Oferta) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (dataOferta == null) {
			if (other.dataOferta != null)
				return false;
		} else if (!dataOferta.equals(other.dataOferta))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (idoferta == null) {
			if (other.idoferta != null)
				return false;
		} else if (!idoferta.equals(other.idoferta))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		if (sistema == null) {
			if (other.sistema != null)
				return false;
		} else if (!sistema.equals(other.sistema))
			return false;
		if (status != other.status)
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		if (Float.floatToIntBits(valorHora) != Float.floatToIntBits(other.valorHora))
			return false;
		return true;
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
