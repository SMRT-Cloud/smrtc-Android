package smartcloud.cash.smartcloudwallet.module.wallet;

import java.io.File;
import java.text.DateFormat;
import java.util.Date;
import java.util.TimeZone;

import smartcloud.cash.smartcloudwallet.SmartcloudApplication;
import smartcloud.cash.smartcloudwallet.module.SmartcloudContext;
import global.utils.Iso8601Format;
import global.BackupHelper;

import static com.google.common.base.Preconditions.checkState;

/**
 * Created by Telostia on 6/29/17.
 */

public class WalletBackupHelper implements BackupHelper {

    public File determineBackupFile(String extraData) {
        SmartcloudContext.Files.EXTERNAL_WALLET_BACKUP_DIR.mkdirs();
        checkState(SmartcloudContext.Files.EXTERNAL_WALLET_BACKUP_DIR.isDirectory(), "%s is not a directory", SmartcloudContext.Files.EXTERNAL_WALLET_BACKUP_DIR);

        final DateFormat dateFormat = Iso8601Format.newDateFormat();
        dateFormat.setTimeZone(TimeZone.getDefault());

        String appName = SmartcloudApplication.getInstance().getVersionName();

        for (int i = 0; true; i++) {
            final StringBuilder filename = new StringBuilder(SmartcloudContext.Files.getExternalWalletBackupFileName(appName));
            filename.append('-');
            filename.append(dateFormat.format(new Date()));
            if (extraData != null) {
                filename.append("-" + extraData);
            }
            if (i > 0)
                filename.append(" (").append(i).append(')');

            final File file = new File(SmartcloudContext.Files.EXTERNAL_WALLET_BACKUP_DIR, filename.toString());
            if (!file.exists())
                return file;
        }
    }

}
