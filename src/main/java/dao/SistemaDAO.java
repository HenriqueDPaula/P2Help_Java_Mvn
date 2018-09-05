package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import model.Sistema;
import util.HibernateUtil;

public class SistemaDAO implements ISistemaDAO {

	private Session session;
	private Criteria criteria;

	public SistemaDAO() {
		this.session = HibernateUtil.getSessionFactory().openSession();
	}

	public void setSession(Session session) {
		this.session = session;
	}

	/**
	 * Salvar Sistema
	 */
	public void save(Sistema sistema) throws HibernateException {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(sistema);
		t.commit();
	}

	/**
	 * Encontrar o sistema pelo id
	 */
	public Sistema findById(int idsistema) {

		Sistema sistema = null;

		criteria = session.createCriteria(Sistema.class);

		criteria.add(Restrictions.eq("idsistema", idsistema));

		sistema = (Sistema) criteria.uniqueResult();

		return sistema;
	}

	/**
	 * listar todos os sistemas
	 */
	@SuppressWarnings("unchecked")
	public List<Sistema> listar() {

		List<Sistema> sistemas = null;

		criteria = session.createCriteria(Sistema.class);

		criteria.addOrder(Order.asc("nome"));

		sistemas = criteria.list();

		return sistemas;
	}

	// @SuppressWarnings("unchecked")
	// @Override
	// public List<Sistema> findByName(String sistema) {
	// String hql = "SELECT nome FROM Curso curso " + "INNER JOIN curso.disciplina
	// AS disciplina";
	// return (List<Sistema>) session.createQuery(hql).list();
	//
	// }

}