package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import model.Municipios;
import util.HibernateUtil;

public class MunicipiosDAO implements IMunicipiosDAO {

	private Session session;
	private Criteria criteria;

	public MunicipiosDAO() {
		this.session = HibernateUtil.getSessionFactory().openSession();
	}

	public void setSession(Session session) {
		this.session = session;
	}

	/**
	 * Salvar Municipio
	 */
	public void save(Municipios municipio) throws HibernateException {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(municipio);
		t.commit();
	}

	/**
	 * Encontrar municipio pelo Id
	 */
	public Municipios findById(int idmunicipio) {

		Municipios municipio = null;

		criteria = session.createCriteria(Municipios.class);

		criteria.add(Restrictions.eq("idmunicipio", idmunicipio));

		municipio = (Municipios) criteria.uniqueResult();

		return municipio;
	}

	/**
	 * Listar Todos os Municipios
	 */
	@SuppressWarnings("unchecked")
	public List<Municipios> listar() {

		List<Municipios> municipios = null;

		// Processamento dos dados

		criteria = session.createCriteria(Municipios.class);

		criteria.addOrder(Order.asc("nome"));

		municipios = criteria.list();

		return municipios;
	}

}
