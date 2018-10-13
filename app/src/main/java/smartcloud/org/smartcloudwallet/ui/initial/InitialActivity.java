package smartcloud.cash.smartcloudwallet.ui.initial;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import smartcloud.cash.smartcloudwallet.SmartcloudApplication;
import smartcloud.cash.smartcloudwallet.ui.splash_activity.SplashActivity;
import smartcloud.cash.smartcloudwallet.ui.wallet_activity.WalletActivity;
import smartcloud.cash.smartcloudwallet.utils.AppConf;

/**
 * Created by Telostia on 8/19/17.
 */

public class InitialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SmartcloudApplication smartcloudApplication = SmartcloudApplication.getInstance();
        AppConf appConf = smartcloudApplication.getAppConf();
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
