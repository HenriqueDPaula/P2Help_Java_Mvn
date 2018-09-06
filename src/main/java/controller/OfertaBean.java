package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import dao.CategoriaDAO;
import model.Categoria;
import model.Municipios;
import model.Oferta;
import model.Sistema;
import model.Usuario;
import service.CategoriaService;
import service.OfertaService;
import service.SistemaService;
import service.UsuarioService;
import util.Util;

@Named("ofertaBean")
@SessionScoped
public class OfertaBean implements Serializable {

	/**
	 * Atributos
	 */
	private static final long serialVersionUID = 5998663528528731657L;
	private Oferta oferta;
	private Municipios municipio;
	private Usuario usuario;
	private OfertaService ofertaService;
	private SistemaService sistemaService;
	private CategoriaService categoriaService;
	private String titulo;
	private String descricao;
	private float valorHora;
	private char status;
	private Categoria categoria;
	private List<SelectItem> sistemasSelect;
	private List<SelectItem> categoriasSelect;
	private List<Categoria> categorias;
	private Sistema sistema;
	private CategoriaDAO categoriaDAO;
	private boolean radio;
	private UsuarioService usuarioService;
	private List<Oferta> listOfertas;
	private List<Oferta> listOferta;
	private Boolean flagModal;
	private Oferta ofertaSelecionada;
	private String sistemaNome;
	private String sistemaFabricante;

	/**
	 * Construtor, instanciado as devidas Services e pegando o usuario logado na
	 * sess�o
	 */
	public OfertaBean() {
		this.oferta = new Oferta();
		this.sistemaService = new SistemaService();
		this.categoriaService = new CategoriaService();
		this.ofertaService = new OfertaService();
		this.usuarioService = new UsuarioService();
		selectSistema();
		usuario = (Usuario) Util.getSessionParameter("usuarioL");
		// usuario = (Usuario)
		// FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioL");

	}

	/**
	 * M�todo para SelectOne do primefaces de Categoria, com SelectItem
	 *
	 * @return
	 */
	public List<SelectItem> selectCategoria() {
		categoriasSelect = new ArrayList<SelectItem>();
		List<Categoria> listacategoria = new ArrayList<Categoria>();
		listacategoria = categoriaService.listar();
		if (listacategoria != null && !listacategoria.isEmpty()) {
			for (Categoria categoria : listacategoria) {
				SelectItem item1 = new SelectItem(categoria, categoria.getDescricao());
				categoriasSelect.add(item1);
			}

		}
		return categoriasSelect;
	}

	/**
	 * M�todo para SelectOne do primefaces de Sistema, com SelectItem
	 *
	 * @return
	 */
	public List<SelectItem> selectSistema() {
		sistemasSelect = new ArrayList<>();
		List<Sistema> listasistemas = new ArrayList<>();
		listasistemas = sistemaService.listar();
		if (listasistemas != null && !listasistemas.isEmpty()) {
			for (Sistema sistema : listasistemas) {
				SelectItem item = new SelectItem(sistema, sistema.getNome());
				sistemasSelect.add(item);
			}
		}
		return sistemasSelect;
	}

	/**
	 * Cadastrar Oferta o
	 * 
	 * @return
	 */
	public String cadastrar() {

		oferta = new Oferta();
		oferta.setTitulo(titulo);
		java.util.Date date = new java.util.Date(); // Instanciando um objeto do tipo Date da classe java.util
		long t = date.getTime();
		java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(t);
		oferta.setDataOferta(sqlTimestamp); // Data e hora do sistema
		oferta.setDescricao(descricao);
		oferta.setCategoria(categoria);
		oferta.setSistema(sistema);
		oferta.setUsuario(usuario);
		oferta.setStatus('s'); // Ativo
		oferta.setValorHora(valorHora);
		try {
			ofertaService.save(oferta);
			Util.setSessionParameter("ofertaC", oferta);
			// FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("ofertaC", oferta);
			Util.mensagemInfo("Oferta cadastrada com sucesso!");
			//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Oferta cadastrada com sucesso!", " "));
			return "agenda.jsf?faces-redirect=true";
		} catch (Exception e) {
			e.printStackTrace();
			Util.mensagemErro("N�o foi possivel cadastrar!");
			//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro, não foi possivel cadastrar a oferta", " "));
			return "cadastrarOferta.jsf?faces-redirect=true";
		}

	}

	/**
	 * Localizar oferta pelo id e redirecionar para a pagina para editar
	 *
	 * @return Ofertas
	 */
	public String atualizar() {
		this.oferta = ofertaService.findById(this.oferta.getIdoferta()); // Encontrando oferta pelo id para atualizar
		return "atualizarOferta.jsf?faces-redirect=true";
	}

	/**
	 * Atualizando oferta
	 *
	 * @return
	 */
	public String atualizarConfirm() {

		java.util.Date date = new java.util.Date(); // Instanciando um objeto do tipo Date da classe java.util
		long t = date.getTime();
		java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(t);
		oferta.setDataOferta(sqlTimestamp); // Data e hora do sistema
		try {
			ofertaService.atualizar(oferta);
			Util.mensagemInfo("Oferta atualizada!");
			//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Oferta Atualizada", " "));
		} catch (Exception e) {
			e.printStackTrace();
			Util.mensagemErro("N�o foi possivel atualizar!");
			//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro, não foi possivel atualizar a oferta", " "));
		}

		return "pageOferta.jsf?faces-redirect=true";
	}

	/**
	 * Listagem de todas as ofertas
	 *
	 * @return lista de ofertas
	 */
	public List<Oferta> listarOfertas() {
		List<Oferta> lista = null;
		listOfertas = ofertaService.listarOfertas();
		lista = listOfertas.stream() /* Filtro status da oferta 's' (Ativo) */
				.filter(oferta -> oferta.getStatus() == 's').collect(Collectors.toList());

		return lista;
	}

	/**
	 * Listar ofertas pelo id do usuario
	 * 
	 * @return
	 */
	public List<Oferta> listById() {
		listOferta = ofertaService.listById(usuario.getIdusuario());
		return listOferta;
	}

	/**
	 * Apagar Oferta
	 */
	public String deleteOferta() {
		this.oferta = ofertaService.findById(this.oferta.getIdoferta());
		try {
			deleteConfirm();
			Util.mensagemInfo("Oferta exclu�da!");
			//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Oferta Excluida", " "));
		} catch (Exception e) {
			e.printStackTrace();
			Util.mensagemErro("Contrato atrelado a esta oferta");
			//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Contrato atrelado a esta oferta!", " "));
		}

		return "pageUsuario.jsf?faces-redirect=true";

	}

	/**
	 * Deletar oferta
	 */
	public void deleteConfirm() {
		ofertaService.delete(this.oferta);
	}

	/**
	 * M�todo para retornar nome do sistema
	 *
	 * @return Nome sistema
	 */
	public String detalheSistema() {

		return oferta.getSistema().getNome();
	}

	/**
	 * M�todo para retornar nome da categoria
	 *
	 * @return Descricao Categoria
	 */
	public String detalheCategoria() {

		return oferta.getCategoria().getDescricao();
	}

	/*
	 * Redirecionamento de p�gina
	 */
	public String redirecionaOfertas() {
		return "Ofertas.jsf?faces-redirect=true";
	}

	public String redirecionarContratadas() {
		return "ofertasContratadas.jsf?faces-redirect=true";
	}

	/*
	 * Redirecionamento de p�gina
	 */
	public String redirecionaCadastroOferta() {
		return "cadastrarOferta.jsf?faces-redirect=true";
	}

	public String redirecionaOfertasUsuario() {
		return "ofertasUsuario.jsf?faces-redirect=true";
	}

	// public void refresh() {
	// FacesContext context = FacesContext.getCurrentInstance();
	// Application application = context.getApplication();
	// ViewHandler viewHandler = application.getViewHandler();
	// UIViewRoot viewRoot = viewHandler.createView(context,
	// context.getViewRoot().getViewId());
	// context.setViewRoot(viewRoot);
	// context.renderResponse();
	// }
	public void refresh() {
		FacesContext context = FacesContext.getCurrentInstance();
		String viewId = context.getViewRoot().getViewId();
		ViewHandler handler = context.getApplication().getViewHandler();
		UIViewRoot root = handler.createView(context, viewId);
		root.setViewId(viewId);
		context.setViewRoot(root);
	}

	public void cadastrarSistema() {
		sistema = new Sistema();
		sistema.setFabricante(sistemaNome);
		sistema.setNome(sistemaFabricante);
		try {
			sistemaService.save(sistema);
			Util.mensagemInfo("Sistema cadastrado");
			//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sistema, cadastrado", " "));

		} catch (Exception e) {
			e.printStackTrace();
			Util.mensagemErro("Erro banco de dados!");
			//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Houve um erro, sistema não cadastrado", " "));
		}

	}

	/**
	 * Getters and Setters
	 *
	 * @return
	 */
	public String redirecionarSistema() {
		return "cadastrarSistema.jsf?faces-redirect=true";
	}

	public Oferta getOferta() {
		return oferta;
	}

	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}

	public Municipios getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipios municipio) {
		this.municipio = municipio;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public OfertaService getOfertaService() {
		return ofertaService;
	}

	public void setOfertaService(OfertaService ofertaService) {
		this.ofertaService = ofertaService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public SistemaService getSistemaService() {
		return sistemaService;
	}

	public void setSistemaService(SistemaService sistemaService) {
		this.sistemaService = sistemaService;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getValorHora() {
		return valorHora;
	}

	public void setValorHora(float valorHora) {
		this.valorHora = valorHora;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public List<SelectItem> getSistemasSelect() {
		return sistemasSelect;
	}

	public void setSistemasSelect(List<SelectItem> sistemasSelect) {
		this.sistemasSelect = sistemasSelect;
	}

	public List<Sistema> getSistemas() {

		return sistemaService.listar();
	}

	public CategoriaService getCategoriaService() {
		return categoriaService;
	}

	public void setCategoriaService(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}

	public List<SelectItem> getCategoriasSelect() {
		return categoriasSelect;
	}

	public void setCategoriasSelect(List<SelectItem> categoriasSelect) {
		this.categoriasSelect = categoriasSelect;
	}

	public Sistema getSistema() {
		return sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public CategoriaDAO getCategoriaDAO() {
		return categoriaDAO;
	}

	public void setCategoriaDAO(CategoriaDAO categoriaDAO) {
		this.categoriaDAO = categoriaDAO;
	}

	/**
	 * @return the radio
	 */
	public boolean isRadio() {
		return radio;
	}

	/**
	 * @param radio
	 *            the radio to set
	 */
	public void setRadio(boolean radio) {
		this.radio = radio;
	}

	/**
	 * @return the usuarioService
	 */
	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	/**
	 * @param usuarioService
	 *            the usuarioService to set
	 */
	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	/**
	 * @return the listOfertas
	 */
	public List<Oferta> getListOfertas() {
		return listOfertas;
	}

	/**
	 * @param listOfertas
	 *            the listOfertas to set
	 */
	public void setListOfertas(List<Oferta> listOfertas) {
		this.listOfertas = listOfertas;
	}
	// public void onRowSelect(SelectEvent event) {
	// FacesMessage msg = new FacesMessage("Car Selected", event.;
	// FacesContext.getCurrentInstance().addMessage(null, msg);
	// }
	//
	// public void onRowUnselect(UnselectEvent event) {
	// FacesMessage msg = new FacesMessage("Car Unselected", ((Car)
	// event.getObject()).getId());
	// FacesContext.getCurrentInstance().addMessage(null, msg);
	// }

	/**
	 * @return the ofertaSelecionada
	 */
	/**
	 * @return the flagModal
	 */
	public Boolean getFlagModal() {
		return flagModal;
	}

	/**
	 * @param flagModal
	 *            the flagModal to set
	 */
	public void setFlagModal(Boolean flagModal) {
		this.flagModal = flagModal;
	}

	/**
	 * @return the ofertaSelecionada
	 */
	public Oferta getOfertaSelecionada() {
		return ofertaSelecionada;
	}

	/**
	 * @param ofertaSelecionada
	 *            the ofertaSelecionada to set
	 */
	public void setOfertaSelecionada(Oferta ofertaSelecionada) {
		this.ofertaSelecionada = ofertaSelecionada;
	}

	/**
	 * @return the listOferta
	 */
	public List<Oferta> getListOferta() {
		return listOferta;
	}

	/**
	 * @param listOferta
	 *            the listOferta to set
	 */
	public void setListOferta(List<Oferta> listOferta) {
		this.listOferta = listOferta;
	}

	/**
	 * @return the sistemaNome
	 */
	public String getSistemaNome() {
		return sistemaNome;
	}

	/**
	 * @param sistemaNome
	 *            the sistemaNome to set
	 */
	public void setSistemaNome(String sistemaNome) {
		this.sistemaNome = sistemaNome;
	}

	/**
	 * @return the sistemaFabricante
	 */
	public String getSistemaFabricante() {
		return sistemaFabricante;
	}

	/**
	 * @param sistemaFabricante
	 *            the sistemaFabricante to set
	 */
	public void setSistemaFabricante(String sistemaFabricante) {
		this.sistemaFabricante = sistemaFabricante;
	}

}
