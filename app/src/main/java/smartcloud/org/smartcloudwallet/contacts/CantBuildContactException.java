package smartcloud.cash.smartcloudwallet.contacts;

/**
 * Created by Telostia on 7/1/17.
 */
public class CantBuildContactException extends RuntimeException {
    public CantBuildContactException(Exception e) {
        super(e);
    }
}
