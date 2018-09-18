package aquila.org.aquilawallet.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import aquila.org.aquilawallet.ui.wallet_activity.WalletActivity;

/**
 * Created by MotoAcidic on 10/19/17.
 */

public class NavigationUtils {

    public static void goBackToHome(Activity activity){
        Intent upIntent = new Intent(activity,WalletActivity.class);
        upIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        activity.startActivity(upIntent);
        activity.finish();
    }

}
