package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Oferta;
import model.Usuario;
import util.HibernateUtil;
import util.Util;

public class OfertaDAO implements IOfertaDAO {

	private Criteria criteria;
	private Session session;
	private Usuario usuario;

	public OfertaDAO() {
		usuario = (Usuario) Util.getSessionParameter("usuarioL");
		session = HibernateUtil.getSessionFactory().openSession();
	}
	/**
	 * Cadastrar Oferta no Banco
	 */
	@Override
	public void save(Oferta oferta) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.persist(oferta);
		t.commit();

	}

	/**
	 * Encontrar oferta pelo seu id
	 */
	@Override
	public Oferta findById(int idoferta) {

		Oferta oferta = null;

		String hql = "from Oferta where idoferta =:idoferta";
		Query query = (Query) session.createQuery(hql);
		query.setParameter("idoferta", idoferta);
		oferta = (Oferta) query.uniqueResult();

		return oferta;
	}

	/**
	 * Listar ofertas pelo id do usuario
	 * 
	 * @param idusuario
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Oferta> listById(int idusuario) {

		List<Oferta> listOferta = null;

		session = HibernateUtil.getSessionFactory().openSession();

		String hql = "from Oferta where idusuario =:idusuario";
		Query query = (Query) session.createQuery(hql);
		query.setParameter("idusuario", idusuario);
		listOferta = query.list();

		return listOferta;
	}

	/**
	 * Atualizar oferta
	 * 
	 * @param oferta
	 */
	public void atualizar(Oferta oferta) {
		session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(oferta);
		t.commit();

	}

	/**
	 * Listar todas as ofertas
	 */
	@SuppressWarnings("unchecked")
	public List<Oferta> listar() {

		String sql = "from Oferta where idusuario <> :idusuario";
		Query query = session.createQuery(sql);
		query.setParameter("idusuario", usuario.getIdusuario());
		// Criteria criteria = session.createCriteria(Oferta.class);

		List<Oferta> listaOfertas = query.list();

		return listaOfertas;
	}

	/**
	 * Apagar Oferta
	 */
	@Override
	public void delete(Oferta oferta) {
		//
		// Oferta ofertaDelete = null;
		// Query q = session.createQuery("from Ofertas where idoferta = :idoferta ");
		// q.setParameter("idoferta", oferta.getIdoferta());
		// ofertaDelete = (Oferta) q.list().get(0);
		//
		// Agenda agenda;
		// for (Agenda agenda1 : agenda.getIdagenda().getOferta()) {
		// session.delete(agenda);
		// }
		// session.delete(oferta);

		session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		AgendaDAO agendaDAO = new AgendaDAO();
		agendaDAO.deleteByOferta(oferta.getIdoferta());

		session.delete(oferta);
		t.commit();

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

}
