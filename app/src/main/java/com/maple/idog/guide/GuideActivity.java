package com.maple.idog.guide;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.maple.idog.Const;
import com.maple.idog.R;
import com.maple.idog.base.BaseActivity;
import com.maple.idog.home.MainActivity;
import com.maple.idog.utils.T;


/**
 * guide page
 *
 * @author maple
 * @time 16/4/13 下午5:28
 */
public class GuideActivity extends BaseActivity {
    protected static final int MSG_ENTER_HOME = 20;
    protected static final int MSG_IO_ERROR = 30;


    Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_ENTER_HOME:// to mian page
                    enterHome();
                    break;
                case MSG_IO_ERROR:// error
                    T.showShort(mContext, "error:" + MSG_IO_ERROR);
                    enterHome();
                    break;
                default:
                    break;
            }
        }

        ;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        long startTime = System.currentTimeMillis();
//        boolean isFirst = SPUtils.getBol(getApplicationContext(), Const.FIRST_COME_IN, true);


//        if (isFirst) {
//            initViews();
//        } else {
        Message msg = Message.obtain();
        msg.what = MSG_ENTER_HOME;
        long sleepTime = Const.SPLASH_MIN_TIME - (System.currentTimeMillis() - startTime);
        handler.sendMessageDelayed(msg, sleepTime);
//        }
    }


    protected void enterHome() {
        finish();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
