package dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import model.Contratacao;
import util.HibernateUtil;

public class ContratacaoDAO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -9141579394237891883L;
	private Session session;
	private Criteria criteria;

	/**
	 * Salvar contratacao no banco
	 *
	 */
	public void save(Contratacao contratacao) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		org.hibernate.Transaction t = session.beginTransaction();
		session.persist(contratacao);
		t.commit();

	}

	public Contratacao findById(int idoferta, Date data, String hora) {
		session = HibernateUtil.getSessionFactory().openSession();

		Contratacao contratacao = new Contratacao();
		String hql = "from Contratacao where idoferta = :idoferta and and data =:data and hora =:hora";
		Query query = (Query) session.createQuery(hql);
		query.setParameter("idoferta", idoferta);
		query.setParameter("data", data);
		query.setParameter("hora", hora);
		contratacao = (Contratacao) query.uniqueResult();

		return contratacao;
	}

	@SuppressWarnings("unchecked")
	public List<Contratacao> listaContratacoes() {
		List<Contratacao> contratacoes = null;

		session = HibernateUtil.getSessionFactory().openSession();

		String hql = "from Contratacao where 1=1";
		Query query = (Query) session.createQuery(hql);
		contratacoes = query.list();

		return contratacoes;
	}

	/**
	 * @return the session
	 */
	public Session getSession() {
		return session;
	}

	/**
	 * @param session
	 *            the session to set
	 */
	public void setSession(Session session) {
		this.session = session;
	}

	/**
	 * @return the criteria
	 */
	public Criteria getCriteria() {
		return criteria;
	}

	/**
	 * @param criteria
	 *            the criteria to set
	 */
	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
