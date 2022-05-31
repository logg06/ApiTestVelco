package velco.apitest.exception;

public class ApiException extends Exception {
	/**
     * serialVersionUID
     */
    private static final long serialVersionUID = 8864722301907436863L;

    /**
     * constructeur
     * 
     * @param message
     *            message de l'erreur
     */
    public ApiException(String message) {
        super(message);
    }

    /**
     * constructeur
     * 
     * @param message
     *            message de l'erreur
     * @param string
     *            cause de l'erreur
     */
    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }
}
