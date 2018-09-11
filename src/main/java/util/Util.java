package util;

import java.util.Properties;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import model.Oferta;
import model.Usuario;

public class Util {

	private static Usuario usuario;
	private static Oferta oferta;

	public Util() {
		usuario = (Usuario) getSessionParameter("usuarioL");
		oferta = (Oferta) getSessionParameter("ofertaC");
	}

	public static void mensagemInfo(String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, ""));
	}

	public static void mensagemErro(String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, mensagem, ""));
	}

	public static void setSessionParameter(String nome, Object value) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(nome, value);
	}

	public static Object getSessionParameter(String nome) {
		return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(nome);
	}

	public static void manterMensagem() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext extContext = context.getExternalContext();
		extContext.getFlash().setKeepMessages(true);
	}

	public static void emailOferta(Oferta oferta, Usuario usuario) {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "587");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("p2helpemail@gmail.com", "emailp2help");
			}
		});
		session.setDebug(true);

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("p2helpemail@gmail.com")); // Remetente

			Address[] toUser = InternetAddress.parse("henrique.depaula@hotmail.com");

			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject("Contratação da oferta: " + oferta.getTitulo());// Assunto
			message.setText("Teste oferta" + oferta.getDescricao() + oferta.getValorHora());
			Transport.send(message);

			System.out.println("Email enviado com sucesso ==============================================!!!");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

}
