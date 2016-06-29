package com.maple.idog.home.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.maple.idog.R;
import com.maple.idog.base.BaseActivity;
import com.maple.idog.base.BaseFragment;

import butterknife.ButterKnife;

/**
 * @author maple
 * @time 16/4/14 下午3:50
 */
public class CenterPage extends BaseFragment implements View.OnClickListener {

    BaseActivity mActivity;

    @Override
    public View initView(LayoutInflater inflater) {
        view = inflater.inflate(R.layout.fragment_center, null);
        ButterKnife.bind(this, view);

        mActivity = (BaseActivity) getActivity();
        mActivity.setLeftBtnState(View.INVISIBLE, false);
        mActivity.setRightBtnState("next", View.VISIBLE, true);

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
//                toPrivateMsg();
                break;
        }
    }


}