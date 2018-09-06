package concierge.org.conciergewallet.ui.initial;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import concierge.org.conciergewallet.ConciergeApplication;
import concierge.org.conciergewallet.ui.splash_activity.SplashActivity;
import concierge.org.conciergewallet.ui.wallet_activity.WalletActivity;
import concierge.org.conciergewallet.utils.AppConf;

/**
 * Created by furszy on 8/19/17.
 */

public class InitialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ConciergeApplication conciergeApplication = ConciergeApplication.getInstance();
        AppConf appConf = conciergeApplication.getAppConf();
        // show report dialog if something happen with the previous process
        Intent intent;
        if (!appConf.isAppInit() || appConf.isSplashSoundEnabled()){
            intent = new Intent(this, SplashActivity.class);
        }else {
            intent = new Intent(this, WalletActivity.class);
        }
        startActivity(intent);
        finish();
    }
}
