package dao;

import java.util.List;

import model.Oferta;

public interface IOfertaDAO {

public void save(Oferta oferta);

	public Oferta findById(int idoferta);

	public List<Oferta> listar();
	
	public void delete(Oferta oferta);
}
