package service;

import java.io.Serializable;

import dao.ContratacaoDAO;
import java.util.Date;
import model.Contratacao;

public class ContratacaoService implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -7070279403499175082L;
	private ContratacaoDAO contratacaoDAO;

	public ContratacaoService() {
		contratacaoDAO = new ContratacaoDAO();
	}

	/**
	 * Salvar contrata��o da oferta/servi�o no banco
	 *
	 * @param contratacao
	 *
	 */
	public void save(Contratacao contratacao) {
		this.contratacaoDAO.save(contratacao);
	}

	public Contratacao findById(int idoferta, Date data, String hora) {
		return this.contratacaoDAO.findById(idoferta, data, hora);
	}

	/**
	 * @return the contratacaoDAO
	 */
	public ContratacaoDAO getContratacaoDAO() {
		return contratacaoDAO;
	}

	/**
	 * @param contratacaoDAO
	 *            the contratacaoDAO to set
	 */
	public void setContratacaoDAO(ContratacaoDAO contratacaoDAO) {
		this.contratacaoDAO = contratacaoDAO;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	// Getter and Setter
}
