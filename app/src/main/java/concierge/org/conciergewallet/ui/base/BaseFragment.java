package concierge.org.conciergewallet.ui.base;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;

import concierge.org.conciergewallet.ConciergeApplication;
import global.ConciergeModule;

/**
 * Created by akshaynexus on 6/29/17.
 */

public class BaseFragment extends Fragment {

    protected ConciergeApplication conciergeApplication;
    protected ConciergeModule conciergeModule;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        conciergeApplication = ConciergeApplication.getInstance();
        conciergeModule = conciergeApplication.getModule();
    }

    protected boolean checkPermission(String permission) {
        int result = ContextCompat.checkSelfPermission(getActivity(),permission);
        return result == PackageManager.PERMISSION_GRANTED;
    }
}
