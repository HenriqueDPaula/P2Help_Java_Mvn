package model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/*
 * Entidade e nome da tabela para mapeamento
 */
@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3119457957054631514L;
	/*
	 * Id, valor e qual sequence informada
	 */

	/*
	 * Atributos a seres settados: Nome, CPF, Rg, Rg Emissor, Endereço, numero,
	 * bairro, complemento, e o id do municipio(fk)
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "usuario_sequence")
	@SequenceGenerator(name = "usuario_sequence", sequenceName = "usuario_auto")
	@Column(name = "IDUSUARIO", nullable = false)
	private Integer idusuario;

	@Column(name = "SENHA", length = 30, nullable = false)
	private String senha;
	@Column(name = "EMAIL", length = 200, nullable = false)
	private String email;

	@Column(name = "NOME", length = 200, nullable = false)
	private String nome;

	@Column(name = "CPF", length = 200, nullable = false)
	private String cpf;

	@Column(name = "RG", length = 200, nullable = false)
	private String rg;

	@Column(name = "RG_EMISSOR", length = 200, nullable = false)
	private String rgEmissor;

	@Column(name = "ENDERECO", length = 200, nullable = false)
	private String endereco;

	@Column(name = "NUMERO", length = 200, nullable = false)
	private String numero;

	@Column(name = "BAIRRO", length = 200, nullable = true)
	private String bairro;

	@Column(name = "COMPLEMENTO", length = 200, nullable = true)
	private String complemento;
	//
	// @Column(name = "ativo", length = 200, nullable = true)
	// private int ativo;

	@ManyToOne
	@JoinColumn(name = "idmunicipio")
	private Municipios municipio;

	/*
	 * Constructor
	 */
	public Usuario() {

	}

	/*
	 * Getters and Setters
	 */
	public Integer getIdusuario() {
		return idusuario;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha
	 *            the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the permissao
	 */

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getRgEmissor() {
		return rgEmissor;
	}

	public void setRgEmissor(String rgEmissor) {
		this.rgEmissor = rgEmissor;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Municipios getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipios municipio) {
		this.municipio = municipio;
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
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + ((complemento == null) ? 0 : complemento.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((idusuario == null) ? 0 : idusuario.hashCode());
		result = prime * result + ((municipio == null) ? 0 : municipio.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
		result = prime * result + ((rgEmissor == null) ? 0 : rgEmissor.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
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
		Usuario other = (Usuario) obj;
		if (bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
			return false;
		if (complemento == null) {
			if (other.complemento != null)
				return false;
		} else if (!complemento.equals(other.complemento))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (idusuario == null) {
			if (other.idusuario != null)
				return false;
		} else if (!idusuario.equals(other.idusuario))
			return false;
		if (municipio == null) {
			if (other.municipio != null)
				return false;
		} else if (!municipio.equals(other.municipio))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		if (rgEmissor == null) {
			if (other.rgEmissor != null)
				return false;
		} else if (!rgEmissor.equals(other.rgEmissor))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}

	// /**
	// * @return the ativo
	// */
	// public int getAtivo() {
	// return ativo;
	// }
	//
	// /**
	// * @param ativo the ativo to set
	// */
	// public void setAtivo(int ativo) {
	// this.ativo = ativo;
	// }

}
