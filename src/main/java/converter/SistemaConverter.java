package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import model.Sistema;
import service.SistemaService;

@FacesConverter(value = "sistemaConverter")
public class SistemaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String codigoString) {
		if (codigoString != null && codigoString.trim().length() > 0) {
			Integer codigo = Integer.valueOf(codigoString);
			SistemaService sistemaService = new SistemaService();

			return sistemaService.FindById(codigo);
		} else {
			return null;
		}

	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object sistemaObjeto) {
		if (sistemaObjeto != null) {
			Sistema sistema = (Sistema) sistemaObjeto;
			return sistema.getIdsistema().toString();
		} else {
			return null;
		}

	}

}
