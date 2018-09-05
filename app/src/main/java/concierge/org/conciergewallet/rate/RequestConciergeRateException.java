package concierge.org.conciergewallet.rate;

/**
 * Created by furszy on 7/5/17.
 */
public class RequestPivxRateException extends Exception {
    public RequestPivxRateException(String message) {
        super(message);
    }

    public RequestPivxRateException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequestPivxRateException(Exception e) {
        super(e);
    }
}
