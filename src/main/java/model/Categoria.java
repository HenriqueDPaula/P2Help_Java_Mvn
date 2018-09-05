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
@Table(name = "CATEGORIAS")
public class Categoria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5059953894990587901L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "categoria_sequence")
	@SequenceGenerator(name = "categoria_sequence", sequenceName = "categoria_auto")
	@Column(name = "IDCATEGORIA", nullable = false)
	private Integer idcategoria;

	@Column(name = "DESCRICAO", length = 200, nullable = false)
	private String descricao;

	@Column(name = "CATEGORIAMAE", nullable = true)
	private Integer categoriaMae;

	public Categoria() {

	}

	public Integer getIdcategoria() {
		return idcategoria;
	}

	public void setIdcategoria(Integer idcategoria) {
		this.idcategoria = idcategoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getCategoriaMae() {
		return categoriaMae;
	}

	public void setCategoriaMae(Integer categoriaMae) {
		this.categoriaMae = categoriaMae;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoriaMae == null) ? 0 : categoriaMae.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((idcategoria == null) ? 0 : idcategoria.hashCode());
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
		Categoria other = (Categoria) obj;
		if (categoriaMae == null) {
			if (other.categoriaMae != null)
				return false;
		} else if (!categoriaMae.equals(other.categoriaMae))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (idcategoria == null) {
			if (other.idcategoria != null)
				return false;
		} else if (!idcategoria.equals(other.idcategoria))
			return false;
		return true;
	}
}
