package business;

/**
 * Une exception personnalisée pour les erreurs spécifiques de la couche métier
 */
public class BusinessException extends Exception{

    /**
     * Constructeur avec un message d'erreur
     * @param message, le message d'erreur
     */
    public BusinessException(String message){
        super(message);
    }
}
