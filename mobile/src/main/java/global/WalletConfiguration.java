package global;

import org.smartcloudj.core.Context;
import org.smartcloudj.core.NetworkParameters;

/**
 * Created by Telostia on 6/4/17.
 */

public interface WalletConfiguration {


    int getTrustedNodePort();

    String getTrustedNodeHost();

    void saveTrustedNode(String host,int port);

    void saveScheduleBlockchainService(long time);

    long getScheduledBLockchainService();

    /**************   Constants   ***************/

    String getMnemonicFilename();

    String getWalletProtobufFilename();

    NetworkParameters getNetworkParams();

    String getKeyBackupProtobuf();

    long getWalletAutosaveDelayMs();

    Context getWalletContext();

    String getBlockchainFilename();

    String getCheckpointFilename();

    int getPeerTimeoutMs();

    long getPeerDiscoveryTimeoutMs();

    int getMinMemoryNeeded();

    long getBackupMaxChars();

    boolean isTest();

    int getProtocolVersion();
}
