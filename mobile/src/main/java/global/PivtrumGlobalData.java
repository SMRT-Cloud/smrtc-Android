package global;

import java.util.ArrayList;
import java.util.List;

import pivtrum.PivtrumPeerData;

/**
 * Created by Telostia on 7/2/17.
 */

public class PivtrumGlobalData {

    public static final String FURSZY_TESTNET_SERVER = "139.99.197.135";

    public static final String[] TRUSTED_NODES = new String[]{"139.99.197.135","139.99.197.113"};

    public static final List<PivtrumPeerData> listTrustedHosts(){
        List<PivtrumPeerData> list = new ArrayList<>();
        list.add(new PivtrumPeerData(FURSZY_TESTNET_SERVER,19887,55552));
        for (String trustedNode : TRUSTED_NODES) {
            list.add(new PivtrumPeerData(trustedNode,9887,55552));
        }
        return list;
    }

}
