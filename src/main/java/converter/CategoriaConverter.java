package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import model.Categoria;
import service.CategoriaService;

@FacesConverter(value = "categoriaConverter")
public class CategoriaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String codigoString) {
		if (codigoString != null && codigoString.trim().length() > 0) {
			Integer codigo = Integer.valueOf(codigoString);
			CategoriaService categoriaService = new CategoriaService();

			return categoriaService.FindById(codigo);
		} else {
			return null;
		}

	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object categoriaObjeto) {
		if (categoriaObjeto != null) {
			Categoria categoria = (Categoria) categoriaObjeto;
			return categoria.getIdcategoria().toString();
		} else {
			return null;
		}
	}

}
