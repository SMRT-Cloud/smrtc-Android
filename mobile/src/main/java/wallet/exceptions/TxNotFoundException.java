package wallet.exceptions;

/**
 * Created by Telostia on 8/10/17.
 */

public class TxNotFoundException extends Exception {
    public TxNotFoundException(String s) {
        super(s);
    }
}
