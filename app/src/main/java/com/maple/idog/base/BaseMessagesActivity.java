package com.maple.idog.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import java.util.List;

/**
 * @author maple
 * @time 16/4/20 下午1:13
 */
public class BaseMessagesActivity extends BaseActivity {

    public List<Fragment> fragmentList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void onBack() {
        if (getSupportFragmentManager().getBackStackEntryCount() >= 1) {
            getSupportFragmentManager().popBackStack();
        } else {
            finish();
        }
    }

    public boolean onNext() {
        int nextPage = getSupportFragmentManager().getBackStackEntryCount() + 1;
        if (fragmentList != null && fragmentList.size() > nextPage) {
            replaceView(fragmentList.get(nextPage));
            return true;
        }
        return false;
    }


}
