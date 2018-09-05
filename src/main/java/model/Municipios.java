package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "MUNICIPIOS")
public class Municipios implements Serializable {

	public Municipios() {

	}

	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = -4368862480019055630L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "municipio_sequence")
	@SequenceGenerator(name = "municipio_sequence", sequenceName = "municipio_auto")
	@Column(name = "IDMUNICIPIO", nullable = false)
	private Integer idmunicipio;

	@Column(name = "NOME", length = 200, nullable = false)
	private String nome;

	@Column(name = "UF", length = 200, nullable = false)
	private String uf;

	public Integer getIdmunicipio() {
		return idmunicipio;
	}

	public void setIdmunicipio(Integer idmunicipio) {
		this.idmunicipio = idmunicipio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idmunicipio == null) ? 0 : idmunicipio.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((uf == null) ? 0 : uf.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Municipios))
			return false;
		Municipios other = (Municipios) obj;
		if (idmunicipio == null) {
			if (other.idmunicipio != null)
				return false;
		} else if (!idmunicipio.equals(other.idmunicipio))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (uf == null) {
			if (other.uf != null)
				return false;
		} else if (!uf.equals(other.uf))
			return false;
		return true;
	}

}
