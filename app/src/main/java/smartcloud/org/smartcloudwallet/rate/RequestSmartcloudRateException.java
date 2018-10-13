package smartcloud.cash.smartcloudwallet.rate;

/**
 * Created by Telostia on 7/5/17.
 */
public class RequestSmartcloudRateException extends Exception {
    public RequestSmartcloudRateException(String message) {
        super(message);
    }

    public RequestSmartcloudRateException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequestSmartcloudRateException(Exception e) {
        super(e);
    }
}
