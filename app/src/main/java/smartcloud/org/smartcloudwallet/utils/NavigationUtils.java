package smartcloud.cash.smartcloudwallet.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import smartcloud.cash.smartcloudwallet.ui.wallet_activity.WalletActivity;

/**
 * Created by Telostia on 10/19/17.
 */

public class NavigationUtils {

    public static void goBackToHome(Activity activity) {
        Intent upIntent = new Intent(activity, WalletActivity.class);
        upIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        activity.startActivity(upIntent);
        activity.finish();
    }

}
