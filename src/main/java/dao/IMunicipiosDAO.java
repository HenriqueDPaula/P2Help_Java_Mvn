package dao;

import java.util.List;

import model.Municipios;

public interface IMunicipiosDAO {

	public void save(Municipios municipio);

	public Municipios findById(int idmunicipio);

	public List<Municipios> listar();
}
