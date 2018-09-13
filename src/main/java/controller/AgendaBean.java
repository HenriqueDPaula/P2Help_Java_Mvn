package controller;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import model.Agenda;
import model.AgendaPK;
import model.Avaliacao;
import model.Contratacao;
import model.Oferta;
import model.Usuario;
import service.AgendaService;
import service.AvaliacaoService;
import service.ContratacaoService;
import util.Util;

@SessionScoped
@Named("agendaBean")
public class AgendaBean implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -8579903826986634497L;

	/**
	 * Atributos
	 */
	private AgendaPK agendaPK;
	private Date dataEhora;

	private AgendaService agendaService;
	private ContratacaoService contratacaoService;
	private AvaliacaoService avaliacaoService;

	private Agenda agenda;
	private Agenda agendaAvaliar;
	private Agenda agendaSelecionada;
	private Avaliacao avaliacao;
	private Contratacao contratacao;
	private Contratacao contratacaoSelecionada;
	private Oferta oferta;
	private Oferta ofertaSelecionada;
	private Usuario usuario;

	private Integer servico;
	private Integer atendimento;
	private String comentario;

	private List<Agenda> listarAgenda;

	/**
	 * Construtor instanciando os principais atributos
	 */
	public AgendaBean() {
		contratacaoService = new ContratacaoService();
		avaliacaoService = new AvaliacaoService();
		agendaService = new AgendaService();
		agenda = new Agenda();
		contratacao = new Contratacao();
		avaliacao = new Avaliacao();
		agendaAvaliar = new Agenda();
		oferta = (Oferta) Util.getSessionParameter("ofertaC"); // Oferta
		usuario = (Usuario) Util.getSessionParameter("usuarioL"); // Usuario
		setDataEhora(null);
	}

	/**
	 * Cadastro de Agenda e sua Chave Primï¿½ria(agendaPK)
	 *
	 */
	public String cadastrarAgenda() {

		agendaPK = new AgendaPK(dataEhora, oferta); // Nova chave primÃ¡ria
		agenda.setIdagenda(agendaPK); // Chave primÃ¡ria da agenda
		try {
			agendaService.save(agenda);
			Util.mensagemInfo("Agenda cadastrada com sucesso!");

		} catch (Exception e) {
			e.printStackTrace();
			Util.mensagemErro("Erro Banco de Dados");
		}

		return "/agenda/agenda";
	}

	/**
	 * Tentativa de limpar o campo inputText
	 */
	public void clean() {
		setDataEhora(null);
	}

	/**
	 * Atualizaï¿½ï¿½o de agenda com o id do usuï¿½rio logado
	 *
	 */
	public String agendaUpdate() {

		agenda = encontrarAgendaPeloId();
		agenda.setUsuario(usuario); // Setando o usuario logado
		try {
			agendaService.atualizar(agenda); /* Atualizar com o id do Usuário contratante */
			cadastrarContratacao();
			return "/contratacao/sucesso";

		} catch (Exception e) {
			e.printStackTrace();
			Util.mensagemErro("Erro Banco de Dados");
			return "";
		}

	}

	public Agenda encontrarAgendaPeloId() {
		return agendaService.findById(agendaSelecionada.getIdagenda().getOferta().getIdoferta(),
				agendaSelecionada.getIdagenda().getDataEhora());
	}

	/**
	 * Cadastrar Contrataï¿½ï¿½o apï¿½s a agenda ser atualizada com o id do usuario
	 *
	 */
	public void cadastrarContratacao() {
		contratacao = new Contratacao(agenda, new Date(), 'p'); // 'p' - pendente
		try {
			contratacaoService.save(contratacao);
			enviarEmailOferta();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void enviarEmailOferta() {
		Util.emailOferta(agenda.getIdagenda().getOferta(), usuario);
	}

	/**
	 * Listar agenda de data e hora pelo id da oferta selecionada na tela "Ofertas"
	 *
	 */
	public List<Agenda> findAgendaByOferta() {
		List<Agenda> listarAgenda = null;
		listarAgenda = agendaService.listById(ofertaSelecionada.getIdoferta()); // Listando pelo id da oferta
																				// selecionada
		return listarAgenda;
	}

	/**
	 * Listar todos as datas/horas contratadas pelo usuario logado
	 *
	 * @return
	 */
	public List<Agenda> listAgendaByIdUsuario() {
		List<Agenda> listAgendaByIdUsuario = null;
		listAgendaByIdUsuario = agendaService.listAgendaByIdUsuario(usuario.getIdusuario()); // Id do usuario logado
		return listAgendaByIdUsuario;
	}

	/**
	 * Cadastrar a avaliaï¿½ï¿½o do usuï¿½rio
	 *
	 */
	public String avaliacao() {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy HH:mm");
		sdf.format(agendaAvaliar.getIdagenda().getDataEhora());

		contratacao = encontrarContratacaoPeloId();
		avaliacao = new Avaliacao(contratacao, atendimento, servico, comentario);
		try {
			avaliacaoService.save(avaliacao);
			Util.mensagemInfo("Avaliado com sucesso!");
			return "/avaliacao/sucesso"; // tela final do sistema na parte do usuÃ¡rio contratante

		} catch (Exception e) {
			e.printStackTrace();
			Util.mensagemErro("Erro Banco de Dados");
			return "";
		}

	}

	public Contratacao encontrarContratacaoPeloId() {
		return contratacaoService.findById(agendaAvaliar.getIdagenda().getOferta().getIdoferta(),
				agendaAvaliar.getIdagenda().getDataEhora());
	}

	public String redirecionarAgenda() {
		Util.mensagemInfo("Concluído!");
		return "/oferta/usuario";
	}

	public String redirecionarAvaliacao() {
		return "/avaliacao/avaliacao";
	}

	/**
	 * Getters and Setters
	 *
	 */
	/**
	 * @return the agendaPK
	 */
	public AgendaPK getAgendaPK() {
		return agendaPK;
	}

	/**
	 * @param agendaPK
	 *            the agendaPK to set
	 */
	public void setAgendaPK(AgendaPK agendaPK) {
		this.agendaPK = agendaPK;
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the oferta
	 */
	public Oferta getOferta() {
		return oferta;
	}

	/**
	 * @param oferta
	 *            the oferta to set
	 */
	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}

	/**
	 * @return the agendaService
	 */
	public AgendaService getAgendaService() {
		return agendaService;
	}

	/**
	 * @param agendaService
	 *            the agendaService to set
	 */
	public void setAgendaService(AgendaService agendaService) {
		this.agendaService = agendaService;
	}

	/**
	 * @return the agenda
	 */
	public Agenda getAgenda() {
		return agenda;
	}

	/**
	 * @param agenda
	 *            the agenda to set
	 */
	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the dataEhora
	 */
	public Date getDataEhora() {
		return dataEhora;
	}

	/**
	 * @param dataEhora
	 *            the dataEhora to set
	 */
	public void setDataEhora(Date dataEhora) {
		this.dataEhora = dataEhora;
	}

	/**
	 * @return the contratacaoService
	 */
	public ContratacaoService getContratacaoService() {
		return contratacaoService;
	}

	/**
	 * @param contratacaoService
	 *            the contratacaoService to set
	 */
	public void setContratacaoService(ContratacaoService contratacaoService) {
		this.contratacaoService = contratacaoService;
	}

	/**
	 * @return the avaliacaoService
	 */
	public AvaliacaoService getAvaliacaoService() {
		return avaliacaoService;
	}

	/**
	 * @param avaliacaoService
	 *            the avaliacaoService to set
	 */
	public void setAvaliacaoService(AvaliacaoService avaliacaoService) {
		this.avaliacaoService = avaliacaoService;
	}

	/**
	 * @return the avaliacao
	 */
	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	/**
	 * @param avaliacao
	 *            the avaliacao to set
	 */
	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

	/**
	 * @return the servico
	 */
	public Integer getServico() {
		return servico;
	}

	/**
	 * @param servico
	 *            the servico to set
	 */
	public void setServico(Integer servico) {
		this.servico = servico;
	}

	/**
	 * @return the atendimento
	 */
	public Integer getAtendimento() {
		return atendimento;
	}

	/**
	 * @param atendimento
	 *            the atendimento to set
	 */
	public void setAtendimento(Integer atendimento) {
		this.atendimento = atendimento;
	}

	/**
	 * @return the comentario
	 */
	public String getComentario() {
		return comentario;
	}

	/**
	 * @param comentario
	 *            the comentario to set
	 */
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	/**
	 * @return the contratacao
	 */
	public Contratacao getContratacao() {
		return contratacao;
	}

	/**
	 * @param contratacao
	 *            the contratacao to set
	 */
	public void setContratacao(Contratacao contratacao) {
		this.contratacao = contratacao;
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
	 * @return the listarAgenda
	 */
	public List<Agenda> getListarAgenda() {
		return listarAgenda;
	}

	/**
	 * @param listarAgenda
	 *            the listarAgenda to set
	 */
	public void setListarAgenda(List<Agenda> listarAgenda) {
		this.listarAgenda = listarAgenda;
	}

	/**
	 * @return the agendaSelecionada
	 */
	public Agenda getAgendaSelecionada() {
		return agendaSelecionada;
	}

	/**
	 * @param agendaSelecionada
	 *            the agendaSelecionada to set
	 */
	public void setAgendaSelecionada(Agenda agendaSelecionada) {
		this.agendaSelecionada = agendaSelecionada;
	}

	public Contratacao getContratacaoSelecionada() {
		return contratacaoSelecionada;
	}

	public void setContratacaoSelecionada(Contratacao contratacaoSelecionada) {
		this.contratacaoSelecionada = contratacaoSelecionada;
	}

	public Agenda getAgendaAvaliar() {
		return agendaAvaliar;
	}

	public void setAgendaAvaliar(Agenda agendaAvaliar) {
		this.agendaAvaliar = agendaAvaliar;
	}

	// public Agenda inserirUsuario() {
	// Agenda agenda = new Agenda();
	// agenda = agendaService.findById(agendaPK);
	// agenda.setUsuario(usuario);
	// return agenda;
	//
	// }
	//
	// public String cadastrarContratacao() {
	// Agenda agenda = inserirUsuario();
	// agendaService.atualizar(agenda);
	//
	// // ToDo entender a regra negocial e cadastrar a agenda na tabela contratacao
	// com
	// // os demais atributos
	//
	// // contratacaoService.save(contratacao);
	// // ToDo Faces Message de Contrataï¿½ï¿½o realizada com sucesso
	// return "contratacaoSucesso";
	//
	// }
	//
	// public List<Agenda> listById() {
	// List<Agenda> horarios = new ArrayList<Agenda>();
	// // horarios = agendaService.listById();
	// return horarios;
	// }
	// ToDo Getters and Setters
}
