package br.com.error;

/**
 *
 * @author Celson Rodrigues
 */
public class DAOException extends Exception{
    
    public DAOException(String e){
        
        super(e);
        
    }
    
    public DAOException(Exception e){
       
        super(e);
        
    }

    public DAOException(){
        
        super();
        
    }
}
