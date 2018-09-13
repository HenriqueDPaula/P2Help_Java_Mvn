package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/*
 * Declarando Entidade e nome da tabela para Mapeamento
 */
@Entity
@Table(name = "SISTEMAS")
public class Sistema implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2917099059447534916L;

	/*
	 * Constructor
	 */
	public Sistema() {

	}

	public Sistema(String fabricante, String nome) {
		this.fabricante = fabricante;
		this.nome = nome;
	}

	/*
	 * Id e sequences do banco
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sistema_sequence")
	@SequenceGenerator(name = "sistema_sequence", sequenceName = "sistema_auto")
	@Column(name = "IDSISTEMA", nullable = false)
	private Integer idsistema;

	/*
	 * Atributos: Fabricante e nome do sistema
	 */

	@Column(name = "FABRICANTE", nullable = false)
	private String fabricante;

	@Column(name = "NOME", nullable = false)
	private String nome;

	/*
	 * Getters and Setters
	 */
	public Integer getIdsistema() {
		return idsistema;
	}

	public void setIdsistema(Integer idsistema) {
		this.idsistema = idsistema;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fabricante == null) ? 0 : fabricante.hashCode());
		result = prime * result + ((idsistema == null) ? 0 : idsistema.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Sistema other = (Sistema) obj;
		if (fabricante == null) {
			if (other.fabricante != null)
				return false;
		} else if (!fabricante.equals(other.fabricante))
			return false;
		if (idsistema == null) {
			if (other.idsistema != null)
				return false;
		} else if (!idsistema.equals(other.idsistema))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
