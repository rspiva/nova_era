package br.com.novaera.system.converter;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("com.piva.DecimalConverter")
public class DecimalConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,String value) {
 
		String valorsRS = value.replace("R$", "");
		String valorsponto = valorsRS.replace(".", "");
		String valorVirgPonto = valorsponto.replace(",", ".");
		
		return valorVirgPonto.trim();
		
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,Object value) {
 		return value.toString();
 	}

}
