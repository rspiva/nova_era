package br.com.novaera.messages;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertiesLoader {  
  
    private Properties props;  
    public PropertiesLoader( String nomeDoProperties ){
    	    StringBuilder arq = new StringBuilder();
    	    String arrayNome[] = nomeDoProperties.split("\\.");
    	    arq.append(arrayNome[4]);
    	    arq.append(".properties");
    	
            props = new Properties();  
            InputStream in = this.getClass().getResourceAsStream(arq.toString());  
            try{  
                    props.load(in);  
                    in.close();  
            }  
            catch(IOException e){e.printStackTrace();}  
    }  
  
    public String getValor(String chave){  
            return (String)props.getProperty(chave);  
    }  
}  