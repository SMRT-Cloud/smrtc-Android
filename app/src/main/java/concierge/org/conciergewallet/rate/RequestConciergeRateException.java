package concierge.org.conciergewallet.rate;

/**
 * Created by furszy on 7/5/17.
 */
public class RequestConciergeRateException extends Exception {
    public RequestConciergeRateException(String message) {
        super(message);
    }

    public RequestConciergeRateException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequestConciergeRateException(Exception e) {
        super(e);
    }
}
