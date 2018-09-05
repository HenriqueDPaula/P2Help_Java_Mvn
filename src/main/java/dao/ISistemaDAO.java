package dao;

import java.util.List;

import model.Sistema;

public interface ISistemaDAO {

	public void save(Sistema sistema);

	public List<Sistema> listar();

	public Sistema findById(int idsistema);
	
//	public List<Sistema> findByName(String sistema);
}
