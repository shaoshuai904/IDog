package com.maple.idog.home.fragment;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.maple.idog.R;
import com.maple.idog.base.BaseActivity;
import com.maple.idog.base.BaseFragment;


/**
 * @author maple
 * @time 16/4/14 下午2:36
 */
public class PublicMessagesPage extends BaseFragment implements View.OnClickListener {


    BaseActivity mActivity;
    Bitmap userBmp;


    @Override
    public View initView(LayoutInflater inflater) {
        view = inflater.inflate(R.layout.fragment_public_messages, null);

        mActivity = (BaseActivity) getActivity();
        mActivity.setLeftBtnState(View.INVISIBLE, false);
        mActivity.setRightBtnState(View.INVISIBLE, false);

        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void initListener() {

    }


    @Override
    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.bt_advanced_message:
//                startActivity(new Intent(mContext, AdvancedMsgActivity.class));
//                break;
//            case R.id.bt_quick_message:
//                startActivity(new Intent(mContext, QuickMsgActivity.class));
//                break;
//        }
    }


//    protected void toLoginPage() {
//        mActivity.finish();
//        Intent intent = new Intent(mContext, LoginActivity.class);
//        startActivity(intent);
//    }
}
