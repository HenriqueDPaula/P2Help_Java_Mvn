package service;

import java.util.List;

import dao.SistemaDAO;
import model.Sistema;

public class SistemaService {

	private SistemaDAO sistemaDAO;

	/*
	 * Construtor instanciando a ClasseDAO
	 */
	public SistemaService() {

		this.sistemaDAO = new SistemaDAO();
	}

	/*
	 * M�todo para cadastrar Sistema
	 */
	public void save(Sistema sistema) {
		// TODO Auto-generated method stub
		this.sistemaDAO.save(sistema);
	}

	/*
	 * M�todo para encontrar Sistema pelo ID
	 */
	public Sistema FindById(int idsistema) {
		return this.sistemaDAO.findById(idsistema);
	}

	/*
	 * M�todo para listar ordenando por nome
	 */
	public List<Sistema> listar() {
		return this.sistemaDAO.listar();
	}
}
