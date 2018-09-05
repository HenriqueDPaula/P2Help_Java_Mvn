package defaultpackage;
import java.text.ParseException;

import dao.MunicipiosDAO;
import dao.OfertaDAO;
import model.Municipios;
import model.Oferta;
import model.Sistema;
import model.Usuario;
import service.CategoriaService;
import service.MunicipioService;
import service.OfertaService;
import service.SistemaService;
import service.UsuarioService;

public class teste {

	static Usuario usuario = new Usuario();
	static UsuarioService usuarioService = new UsuarioService();
	static Municipios municipio = new Municipios();
	static MunicipioService municipioService = new MunicipioService();
	static MunicipiosDAO municipioDAO = new MunicipiosDAO();
	static SistemaService sistemaService = new SistemaService();
	static CategoriaService categoriaService = new CategoriaService();
	static OfertaDAO ofertaDAO = new OfertaDAO();
	static Oferta oferta = new Oferta();
	// static Sistema sistema = new Sistema();
	static OfertaService ofertaService = new OfertaService();
	static Sistema sistema;

	public static void main(String[] args) throws ParseException {

//		AgendaPK ap = new AgendaPK();
//		String data = "20/05/2018";
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//		Date dataa = sdf.parse(data);
//		ap.setData(dataa);
//
//		String hora = "20:21";
//		SimpleDateFormat sdff = new SimpleDateFormat("HH:mm");
//		Date horaa = sdff.parse(hora);
//		ap.setHora(horaa);
//
//		oferta = ofertaService.findById();
//		ap.setOferta(oferta);
//
//		Usuario usuario = usuarioService.findById(69);
//		Agenda agenda = new Agenda();
//		agenda.setUsuario(usuario);
//
//		agenda.setIdagenda(ap);
		// String email = "email@.com";
		// String senha = "1233";
		// usuario = usuarioService.login(email, senha);
		// System.out.println(usuario.getEmail() + usuario.getNome());

		// oferta = new Oferta();
		// ofertaDAO = new OfertaDAO();
		// List<Oferta> list = new ArrayList<Oferta>();
		// list = ofertaDAO.listar();
		// for (Oferta oferta : list) {
		// System.out.println(oferta.getTitulo());
		// }
		// oferta.setDescricao("Serva que vai");
		// Categoria categoria = new Categoria();
		// categoria = categoriaService.FindById(26);
		// oferta.setCategoria(categoria);
		// Usuario usuario = new Usuario();
		// usuario = usuarioService.findById(66);
		// oferta.setUsuario(usuario);
		// Sistema sistema = new Sistema();
		// sistema = sistemaService.FindById(22);
		// oferta.setSistema(sistema);
		// char s = 's';
		// oferta.setStatus(s);
		// oferta.setTitulo("suporte a eclipse");
		// oferta.setValorHora(22.22f);
		// java.util.Date date = new java.util.Date();
		// long t = date.getTime();
		// java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(t);
		// oferta.setDataOferta(sqlTimestamp);
		// ofertaService.save(oferta);

		//
		// usuario = new Usuario();
		// usuario.setBairro("xaxim");
		// usuario.setComplemento("casa");
		// usuario.setCpf("12633939937");
		// usuario.setEmail("Henrique@email");
		// usuario.setEndereco("gerharddddd");
		// usuario.setNumero("1111");
		// municipio = municipioService.FindById(61);
		// usuario.setMunicipio(municipio);
		// usuario.setNome("Henrique");
		// usuario.setRg("1315555151");
		// usuario.setRgEmissor("pr");
		// usuario.setSenha("senha");
		// usuarioService.save(usuario);
		// List<Categoria> cat = new ArrayList<Categoria>();
		// cat = categoriaService.listar();
		// for (Categoria categoria : cat) {
		// System.out.println(categoria.getDescricao());
		// }
		// SistemaService sis = new SistemaService();
		// Sistema sistema = new Sistema();
		// sistema.setNome("carreira");
		// sistema.setFabricante("Carlos");
		// sis.save(sistema);
		// TODO Auto-generated method stub
		// List<Municipios> muni = new ArrayList<Municipios>();
		// muni = municipioService.listar();
		// for (Municipios municipio : muni) {
		// System.out.println(municipio.getNome());
		// }
		//
		// Sistema sistema = sistemaService.FindById(6);
		sistema = new Sistema();
		sistema.setFabricante("hp");
		sistema.setNome("notebook");
		sistemaService.save(sistema);
		// System.out.println(sistema.getNome());
		// Municipios muni = municipioService.FindById(4106902);
		// System.out.println(muni.getNome());
		// municipioDAO.findById(4105805);
		// System.out.println(municipio.getNome());
		// //municipioService.FindById(4105805);
		// municipio.setNome("indiassss");
		// municipio.setUf("PR");
		// municipio.setIdmunicipio(4);
		// municipioService.save(municipio);
		// usuario.setNome("carlosAlberto");
		// usuario.setCpf("01223929938");
		// usuario.setBairro("xaxim");
		// usuario.setComplemento("casa");
		// usuario.setEndereco("Gerhdar Heinrichs");
		// usuario.setRg("12131133");
		// usuario.setRgEmissor("PR");
		// usuario.setMunicipio(muni);
		// usuarioService.save(usuario);
		//
	}

	/**
	 * @return the usuario
	 */
	public static Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public static void setUsuario(Usuario usuario) {
		teste.usuario = usuario;
	}

	/**
	 * @return the usuarioService
	 */
	public static UsuarioService getUsuarioService() {
		return usuarioService;
	}

	/**
	 * @param usuarioService
	 *            the usuarioService to set
	 */
	public static void setUsuarioService(UsuarioService usuarioService) {
		teste.usuarioService = usuarioService;
	}

	/**
	 * @return the municipio
	 */
	public static Municipios getMunicipio() {
		return municipio;
	}

	/**
	 * @param municipio
	 *            the municipio to set
	 */
	public static void setMunicipio(Municipios municipio) {
		teste.municipio = municipio;
	}

	/**
	 * @return the municipioService
	 */
	public static MunicipioService getMunicipioService() {
		return municipioService;
	}

	/**
	 * @param municipioService
	 *            the municipioService to set
	 */
	public static void setMunicipioService(MunicipioService municipioService) {
		teste.municipioService = municipioService;
	}

	/**
	 * @return the municipioDAO
	 */
	public static MunicipiosDAO getMunicipioDAO() {
		return municipioDAO;
	}

	/**
	 * @param municipioDAO
	 *            the municipioDAO to set
	 */
	public static void setMunicipioDAO(MunicipiosDAO municipioDAO) {
		teste.municipioDAO = municipioDAO;
	}

	/**
	 * @return the sistemaService
	 */
	public static SistemaService getSistemaService() {
		return sistemaService;
	}

	/**
	 * @param sistemaService
	 *            the sistemaService to set
	 */
	public static void setSistemaService(SistemaService sistemaService) {
		teste.sistemaService = sistemaService;
	}

	/**
	 * @return the categoriaService
	 */
	public static CategoriaService getCategoriaService() {
		return categoriaService;
	}

	/**
	 * @param categoriaService
	 *            the categoriaService to set
	 */
	public static void setCategoriaService(CategoriaService categoriaService) {
		teste.categoriaService = categoriaService;
	}

	/**
	 * @return the sis
	 */
	/**
	 * @return the oferta
	 */
	public static Oferta getOferta() {
		return oferta;
	}

	/**
	 * @param oferta
	 *            the oferta to set
	 */
	public static void setOferta(Oferta oferta) {
		teste.oferta = oferta;
	}

	/**
	 * @return the ofertaService
	 */
	public static OfertaService getOfertaService() {
		return ofertaService;
	}

	/**
	 * @param ofertaService
	 *            the ofertaService to set
	 */
	public static void setOfertaService(OfertaService ofertaService) {
		teste.ofertaService = ofertaService;
	}

	/**
	 * @return the ofertaDAO
	 */
	public static OfertaDAO getOfertaDAO() {
		return ofertaDAO;
	}

	/**
	 * @param ofertaDAO
	 *            the ofertaDAO to set
	 */
	public static void setOfertaDAO(OfertaDAO ofertaDAO) {
		teste.ofertaDAO = ofertaDAO;
	}

}
