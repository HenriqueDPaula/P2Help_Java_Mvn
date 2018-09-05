package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import model.Municipios;
import service.MunicipioService;

@FacesConverter(value = "municipioConverter")
public class MunicipioConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String codigoString) {
		if (codigoString != null && codigoString.trim().length() > 0) {
			Integer codigo = Integer.valueOf(codigoString);
			MunicipioService municipioService = new MunicipioService();

			return municipioService.FindById(codigo);
		} else {
			return null;
		}

	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object municipioObjeto) {
		if (municipioObjeto != null) {
			Municipios municipio = (Municipios) municipioObjeto;
			return municipio.getIdmunicipio().toString();
		} else {
			return null;
		}
	}

}
