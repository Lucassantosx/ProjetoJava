package br.com.error;

/**
 *
 * @author Tito
 */
public class ConexaoException extends Exception{
    public ConexaoException(String e){
        super(e);
    }
    
    public ConexaoException(Exception e){
        super(e);
    }

    public ConexaoException(){
        super();
    }
}
