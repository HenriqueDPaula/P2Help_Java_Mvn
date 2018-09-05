package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import model.Categoria;
import util.HibernateUtil;

public class CategoriaDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -931611547509901966L;
	private Session session;
	private Criteria criteria;

	public CategoriaDAO() {
		this.session = HibernateUtil.getSessionFactory().openSession();
	}

	public void setSession(Session session) {
		this.session = session;
	}

	/**
	 * Salvar Categoria(Não sera usado por enquanto)
	 * 
	 * @param categoria
	 * @throws HibernateException
	 */
	public void save(Categoria categoria) throws HibernateException {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(categoria);
		t.commit();
	}

	/**
	 * Encontrar Categoria pelo Id
	 * 
	 * @param idcategoria
	 * @return
	 */
	public Categoria findById(int idcategoria) {

		Categoria categoria = null;

		criteria = session.createCriteria(Categoria.class);

		criteria.add(Restrictions.eq("idcategoria", idcategoria));

		categoria = (Categoria) criteria.uniqueResult();

		return categoria;
	}

	/**
	 * Listar todas as categorias
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Categoria> listar() {

		List<Categoria> categorias = null;

		// Processamento dos dados

		criteria = session.createCriteria(Categoria.class);

		criteria.addOrder(Order.asc("descricao"));

		categorias = criteria.list();

		return categorias;
	}

}
