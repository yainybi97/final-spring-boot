package exception;

/**
 * Creado por @author: YainyBi
 * el 13/11/20
 **/
public class RepositoryException extends  Exception {

    public RepositoryException(){
        super();
    }

    public RepositoryException(String mesagge){
        super(mesagge);
    }

    public RepositoryException( Throwable cause){
        super(cause);
    }

    public RepositoryException(String message, Throwable couse) {
        super(message, couse);
    }

}
