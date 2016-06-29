package com.maple.idog.home.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.maple.idog.R;
import com.maple.idog.base.BaseActivity;
import com.maple.idog.base.BaseFragment;


/**
 * @author maple
 * @time 16/4/14 下午3:38
 */
public class SettingsPage extends BaseFragment implements View.OnClickListener {

    BaseActivity mActivity;

    @Override
    public View initView(LayoutInflater inflater) {
        view = inflater.inflate(R.layout.fragment_settings, null);


        mActivity = (BaseActivity) getActivity();
        mActivity.setTitle(getResources().getStringArray(R.array.tab_fun_array)[2]);
        mActivity.setLeftBtnState(View.INVISIBLE, false);
        mActivity.setRightBtnState("Lagout", View.VISIBLE, true);


        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {


    }


    @Override
    public void initListener() {
        mActivity.setRightBtnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_right_title:
                // TODO Logout 暂时没有API
//                toLoginPage();
                break;

        }
    }


//    protected void toLoginPage() {
//        mActivity.finish();
//        Intent intent = new Intent(mContext, LoginActivity.class);
//        startActivity(intent);
//    }
//
//    private void toSettingPage(int loadPageIndex) {
//        Intent intent = new Intent(mContext, SettingsActivity.class);
//        intent.putExtra(SettingsActivity.LOADING_PAGE_INDEX, loadPageIndex);
//        mContext.startActivity(intent);
//    }

}