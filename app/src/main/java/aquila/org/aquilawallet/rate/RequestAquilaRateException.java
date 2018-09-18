package aquila.org.aquilawallet.rate;

/**
 * Created by MotoAcidic on 7/5/17.
 */
public class RequestAquilaRateException extends Exception {
    public RequestAquilaRateException(String message) {
        super(message);
    }

    public RequestAquilaRateException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequestAquilaRateException(Exception e) {
        super(e);
    }
}
