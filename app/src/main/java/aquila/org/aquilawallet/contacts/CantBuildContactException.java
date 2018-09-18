package aquila.org.aquilawallet.contacts;

/**
 * Created by MotoAcidic on 7/1/17.
 */
public class CantBuildContactException extends RuntimeException {
    public CantBuildContactException(Exception e) {
        super(e);
    }
}
