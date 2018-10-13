package smartcloud.cash.smartcloudwallet.utils;

import org.smartcloudj.core.ScriptException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

import global.AddressLabel;
import global.SmartcloudModule;
import global.wrappers.TransactionWrapper;

/**
 * Created by Telostia on 8/14/17.
 */

public class TxUtils {

    private static Logger logger = LoggerFactory.getLogger(TxUtils.class);

    public static String getAddressOrContact(SmartcloudModule smartcloudModule, TransactionWrapper data) {
        String text;
        if (data.getOutputLabels() != null && !data.getOutputLabels().isEmpty()) {
            Collection<AddressLabel> addressLabels = data.getOutputLabels().values();
            AddressLabel addressLabel = addressLabels.iterator().next();
            if (addressLabel != null) {
                if (addressLabel.getName() != null)
                    text = addressLabel.getName();
                else
                    text = addressLabel.getAddresses().get(0);
            } else {
                try {
                    text = data.getTransaction().getOutput(0).getScriptPubKey().getToAddress(smartcloudModule.getConf().getNetworkParams(), true).toBase58();
                } catch (ScriptException e) {
                    text = data.getTransaction().getOutput(1).getScriptPubKey().getToAddress(smartcloudModule.getConf().getNetworkParams(), true).toBase58();
                }
            }
        } else {
            text = "Error";
            logger.warn(data.toString());
        }
        return text;
    }

}
