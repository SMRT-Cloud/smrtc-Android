package global;

import java.util.ArrayList;
import java.util.List;

import pivtrum.PivtrumPeerData;

/**
 * Created by akshaynexus on 7/2/17.
 */

public class PivtrumGlobalData {

    public static final String FURSZY_TESTNET_SERVER = "104.207.134.189";

    public static final String[] TRUSTED_NODES = new String[]{"45.32.207.214","178.62.94.162","54.39.96.184","104.238.186.149","45.63.100.153"};

    public static final List<PivtrumPeerData> listTrustedHosts(){
        List<PivtrumPeerData> list = new ArrayList<>();
        list.add(new PivtrumPeerData(FURSZY_TESTNET_SERVER,8443,55552));
        for (String trustedNode : TRUSTED_NODES) {
            list.add(new PivtrumPeerData(trustedNode,51470,55552));
        }
        return list;
    }

}
