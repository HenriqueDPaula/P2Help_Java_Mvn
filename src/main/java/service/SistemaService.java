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
	 * Método para cadastrar Sistema
	 */
	public void save(Sistema sistema) {
		// TODO Auto-generated method stub
		this.sistemaDAO.save(sistema);
	}

	/*
	 * Método para encontrar Sistema pelo ID
	 */
	public Sistema FindById(int idsistema) {
		return this.sistemaDAO.findById(idsistema);
	}

	/*
	 * Método para listar ordenando por nome
	 */
	public List<Sistema> listar() {
		return this.sistemaDAO.listar();
	}
}
