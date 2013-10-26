package br.com.novaera.system;

public class JpivaException extends Exception{
    public JpivaException(String mensagem, Exception e) {
        super(mensagem, e);
    }

    public JpivaException(String mensagem) {
        super(mensagem);
    }    
}
