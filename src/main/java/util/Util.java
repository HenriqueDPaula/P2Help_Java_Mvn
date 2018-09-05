package util;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class Util {

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

}