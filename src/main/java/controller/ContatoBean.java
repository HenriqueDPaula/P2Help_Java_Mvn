package controller;

import java.io.Serializable;
import java.util.Properties;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import model.Usuario;
import util.Util;

@SessionScoped
@Named("contatoBean")
public class ContatoBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5446592150716200457L;

	/**
	 * 
	 */
	private String reclamacao;
	private String melhoria;
	private Usuario usuario;

	private final static String EMAIL = "p2helpemail@gmail.com";
	private final static String SENHA = "emailp2help";

	private final static String HOST = "mail.smtp.host";
	private final static String GMAIL = "smtp.gmail.com";
	private final static String SOCKET_PORT = "mail.smtp.socketFactory.port";
	private final static String SOCKET_NUMBER = "465";
	private final static String SOCKET_CLASS = "mail.smtp.socketFactory.class";
	private final static String SOCKET_FACTORY = "javax.net.ssl.SSLSocketFactory";
	private final static String AUTH = "mail.smtp.auth";
	private final static String SMTP_PORT = "mail.smtp.port";
	private final static String SMTP_NUMBER = "587";

	public ContatoBean() {
		usuario = (Usuario) Util.getSessionParameter("usuarioL");
	}

	public void reclamacao() {
		Properties props = new Properties();
		props.put(HOST, GMAIL);
		props.put(SOCKET_PORT, SOCKET_NUMBER);
		props.put(SOCKET_CLASS, SOCKET_FACTORY);
		props.put(AUTH, "true");
		props.put(SMTP_PORT, SMTP_NUMBER);

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(EMAIL, SENHA);
			}
		});
		session.setDebug(true);

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(EMAIL)); // Remetente

			Address[] toUser = InternetAddress.parse(EMAIL);

			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject("Reclamação from : " + usuario.getEmail());// Assunto

			message.setText(reclamacao);
			Transport.send(message);

			System.out.println("Email enviado com sucesso ==============================================!!!");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public void melhoria() {

		Properties props = new Properties();
		props.put(HOST, GMAIL);
		props.put(SOCKET_PORT, SOCKET_NUMBER);
		props.put(SOCKET_CLASS, SOCKET_FACTORY);
		props.put(AUTH, "true");
		props.put(SMTP_PORT, SMTP_NUMBER);

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(EMAIL, SENHA);
			}
		});
		session.setDebug(true);

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(EMAIL)); // Remetente

			Address[] toUser = InternetAddress.parse(EMAIL);

			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject("Sugestão de melhoria from : " + usuario.getEmail());// Assunto

			message.setText(melhoria);
			Transport.send(message);

			System.out.println("Email enviado com sucesso ==============================================!!!");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

	public String redirecionarReclamacao() {
		return "/contato/reclamacao";
	}

	public String redirecionarMelhoria() {
		return "/contato/melhoria";
	}

	public String getReclamacao() {
		return reclamacao;
	}

	public void setReclamacao(String reclamacao) {
		this.reclamacao = reclamacao;
	}

	public String getMelhoria() {
		return melhoria;
	}

	public void setMelhoria(String melhoria) {
		this.melhoria = melhoria;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
