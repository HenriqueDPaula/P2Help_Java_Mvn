package dao;

import java.util.List;

import model.Categoria;

public interface ICategoriaDAO {
	
	public void save(Categoria categoria);

	public Categoria findById(int idcategoria);

	public List<Categoria> listar();

}
