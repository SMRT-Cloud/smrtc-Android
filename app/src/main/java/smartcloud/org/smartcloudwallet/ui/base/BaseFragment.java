package smartcloud.cash.smartcloudwallet.ui.base;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;

import smartcloud.cash.smartcloudwallet.SmartcloudApplication;
import global.SmartcloudModule;

/**
 * Created by Telostia on 6/29/17.
 */

public class BaseFragment extends Fragment {

    protected SmartcloudApplication smartcloudApplication;
    protected SmartcloudModule smartcloudModule;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        smartcloudApplication = SmartcloudApplication.getInstance();
        smartcloudModule = smartcloudApplication.getModule();
    }

    protected boolean checkPermission(String permission) {
        int result = ContextCompat.checkSelfPermission(getActivity(), permission);
        return result == PackageManager.PERMISSION_GRANTED;
    }
}
