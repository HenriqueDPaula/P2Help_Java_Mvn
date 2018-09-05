package service;

import java.util.List;


import dao.CategoriaDAO;
import model.Categoria;

public class CategoriaService {

	private CategoriaDAO categoriaDAO;

	/*
	 * Construtor instanciando a ClasseDAO
	 */
	public CategoriaService() {

		this.categoriaDAO = new CategoriaDAO();
	}

	/*
	 * M�todo para cadastrar Sistema
	 */
	public void save(Categoria categoria) {
		// TODO Auto-generated method stub
		this.categoriaDAO.save(categoria);
	}

	/*
	 * M�todo para encontrar Categoria pelo ID
	 */
	public Categoria FindById(int idcategoria) {
		return this.categoriaDAO.findById(idcategoria);
	}

	/*
	 * M�todo para listar ordenando por nome
	 */
	public List<Categoria> listar() {
		return this.categoriaDAO.listar();
	}
}
