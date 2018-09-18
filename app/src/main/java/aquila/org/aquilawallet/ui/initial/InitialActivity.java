package aquila.org.aquilawallet.ui.initial;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import aquila.org.aquilawallet.AquilaApplication;
import aquila.org.aquilawallet.ui.splash_activity.SplashActivity;
import aquila.org.aquilawallet.ui.wallet_activity.WalletActivity;
import aquila.org.aquilawallet.utils.AppConf;

/**
 * Created by MotoAcidic on 8/19/17.
 */

public class InitialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AquilaApplication aquilaApplication = AquilaApplication.getInstance();
        AppConf appConf = aquilaApplication.getAppConf();
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
