package service;

import java.io.Serializable;
import java.util.List;

import dao.OfertaDAO;
import model.Oferta;
import model.Usuario;

public class OfertaService implements Serializable {

	/**
	 * Atributos e SerialVersion
	 */
	private static final long serialVersionUID = -894570698311045270L;
	private OfertaDAO ofertaDAO;
	private Oferta oferta;

	/**
	 * Construtor instanciando a classe OfertaDAO
	 */
	public OfertaService() {
		ofertaDAO = new OfertaDAO();
	}

	/**
	 * Salvar Oferta
	 * 
	 * @param oferta
	 */
	public void save(Oferta oferta) {

		ofertaDAO.save(oferta);
	}

	/**
	 * Listar Ofertas
	 * 
	 * @return ofertaDAO.listar
	 */
	public List<Oferta> listarOfertas() {
		return this.ofertaDAO.listar();
	}

	/**
	 * Atualizar Oferta
	 * 
	 * @param oferta
	 */
	public void atualizar(Oferta oferta) {
		this.ofertaDAO.atualizar(oferta);
	}

	/**
	 * Listar oferta pelo seu id
	 * 
	 * @param idoferta
	 * @return
	 */
	public Oferta findById(int idoferta) {
		return this.ofertaDAO.findById(idoferta);
	}

	public List<Oferta> listById(int idusuario) {
		return this.ofertaDAO.listById(idusuario);
	}

	/**
	 * Apagar oferta
	 * 
	 * @param oferta
	 */
	public void delete(Oferta oferta) {
		this.ofertaDAO.delete(oferta);

	}

	/**
	 * Getters and Setters
	 * 
	 * @return
	 */
	public OfertaDAO getOfertaDAO() {
		return ofertaDAO;
	}

	public void setOfertaDAO(OfertaDAO ofertaDAO) {
		this.ofertaDAO = ofertaDAO;
	}

	public Oferta getOferta() {
		return oferta;
	}

	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
