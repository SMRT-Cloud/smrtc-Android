package smartcloud.cash.smartcloudwallet.ui.qr_activity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import smartcloud.cash.smartcloudwallet.R;
import smartcloud.cash.smartcloudwallet.ui.base.BaseActivity;
import smartcloud.cash.smartcloudwallet.utils.NavigationUtils;

/**
 * Created by Telostia on 6/8/17.
 */

public class QrActivity extends BaseActivity {

    private View root;

    @Override
    protected void onCreateView(Bundle savedInstanceState, ViewGroup container) {
        super.onCreateView(savedInstanceState, container);
        ;
        root = getLayoutInflater().inflate(R.layout.qr_activity, container, true);
        setTitle(R.string.my_address);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        NavigationUtils.goBackToHome(this);
    }

}
