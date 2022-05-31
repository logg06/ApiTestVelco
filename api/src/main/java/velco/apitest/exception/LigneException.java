package velco.apitest.exception;

public class LigneException extends Exception {
	/**
     * serialVersionUID
     */
    private static final long serialVersionUID = 8864722301907836863L;

    /**
     * constructeur
     * 
     * @param message
     *            message de l'erreur
     */
    public LigneException(String message) {
        super(message);
    }

    /**
     * constructeur
     * 
     * @param message
     *            message de l'erreur
     * @param cause
     *            cause de l'erreur
     */
    public LigneException(String message, Throwable cause) {
        super(message, cause);
    }
}
