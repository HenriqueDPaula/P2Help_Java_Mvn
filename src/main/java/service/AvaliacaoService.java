package service;

import java.io.Serializable;

import dao.AvaliacaoDAO;
import model.Avaliacao;

public class AvaliacaoService implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2200053989475426132L;
	private AvaliacaoDAO avaliacaoDAO;

	public AvaliacaoService() {
		avaliacaoDAO = new AvaliacaoDAO();
	}

	public void save(Avaliacao avaliacao) {
		this.avaliacaoDAO.save(avaliacao);
	}

	/**
	 * @return the avaliacaoDAO
	 */
	public AvaliacaoDAO getAvaliacaoDAO() {
		return avaliacaoDAO;
	}

	/**
	 * @param avaliacaoDAO
	 *            the avaliacaoDAO to set
	 */
	public void setAvaliacaoDAO(AvaliacaoDAO avaliacaoDAO) {
		this.avaliacaoDAO = avaliacaoDAO;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	// Getter and Setter
}
