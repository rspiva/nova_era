package br.com.novaera.system.converter;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("com.piva.MonetarioConverter")
public class MonetarioConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,String value) {
 
		String valorsRS = value.replace("R$", "");
		String valorsponto = valorsRS.replace(".", "");
		String valorVirgPonto = valorsponto.replace(",", ".");
		
		return valorVirgPonto.trim();
		
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,Object value) {
		
		NumberFormat nf_us = NumberFormat.getInstance(new Locale( "pt", "BR" ));
		String number_us = nf_us.format(value);
		
		return number_us;
 	}

}
