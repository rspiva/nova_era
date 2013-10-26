package br.com.novaera.sistema.controller;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.novaera.messages.PropertiesLoader;
import br.com.novaera.sistema.model.User;

@ManagedBean(name = "acessoSistema")
public class AcessoController {
	
	
	String email;
	String password;
	String idioma;
	FacesContext context;
	public static final String LOCALE = "localidade";	
	public static final String USER_SESSION_KEY = "userLogado";
	String txt_locale = "br.com.novaera.messages.pt_txt";
		
	
	public String gravaIdioma(String idioma){
		
		context = FacesContext.getCurrentInstance();
		String txt_locale = "br.com.novaera.messages.pt_txt";
		if(idioma.equals("en")){
			txt_locale = "br.com.novaera.messages.en_txt";
		}
		if(idioma.equals("es")){
			txt_locale = "br.com.novaera.messages.es_txt";
		}		
		context.getExternalContext().getSessionMap().put(LOCALE, txt_locale);
		return txt_locale;
		
	}
	
	
	public String txtLocale(){
		context = FacesContext.getCurrentInstance();
		String txt_locale = (String) context.getExternalContext().getSessionMap().get(LOCALE);
		if(txt_locale == "" || txt_locale == null){
			txt_locale = "br.com.novaera.messages.pt_txt";
		}
		return txt_locale;
	}
	
	
	public String validateUser(){
	    FacesContext context = FacesContext.getCurrentInstance();
	    PropertiesLoader msg = new PropertiesLoader(txtLocale());
	    
	    User user = new UserController().getUserEmail(email);
        if (user != null) {
            if (!user.getPassword().equals(password)) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                						   msg.getValor("msgEmailIncorreto"),
                						   msg.getValor("msgSenhaIncorreta"));
                context.addMessage(null, message);
                return null;
            }
            
            context.getExternalContext().getSessionMap().put(USER_SESSION_KEY, user);
            try {
				context.getExternalContext().redirect("portal.jsf");
			} catch (IOException e) {
				e.printStackTrace();
			}
            //return "app-main";
        } else {           
        	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
        			msg.getValor("msgEmailIncorreto"),
        			msg.getValor("msgUserNaoCadastrado"));
			context.addMessage(null, message);
            return null;
        }
		return null;
	}
	
	public String logout() {
		FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession)context.getExternalContext().getSession(false);
        if (session != null) {
            session.invalidate();
        }
        try {
			context.getExternalContext().redirect("index.jsf");
		} catch (IOException e) {
			e.printStackTrace();
		}
        return null;        
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	

}
