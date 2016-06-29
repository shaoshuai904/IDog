package com.maple.idog.home;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.maple.idog.R;
import com.maple.idog.base.BaseActivity;
import com.maple.idog.home.fragment.PrivateMessagesPage;
import com.maple.idog.home.fragment.PublicMessagesPage;
import com.maple.idog.home.fragment.SettingsPage;


/**
 * @author maple
 * @time 16/4/13 下午6:35
 */
public class MainActivity extends BaseActivity {
    private FragmentTabHost mTabHost;

    private String[] mTextViewArray;
    private Class[] fragmentArray = new Class[]{PublicMessagesPage.class, PrivateMessagesPage.class, SettingsPage.class};
    private int[] mImageViewArray = {R.drawable.tag_public_msg, R.drawable.tag_private_msg, R.drawable.tag_settings};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_main);

        mTabHost = (FragmentTabHost) findViewById(R.id.tabhost);
        mTextViewArray = getResources().getStringArray(R.array.tab_fun_array);

        initView();
    }


    private void initView() {
        setLeftBtnState(View.INVISIBLE, false);
        setRightBtnState(View.INVISIBLE, false);

        mTabHost.setup(this, getSupportFragmentManager(), R.id.fl_content);
        for (int i = 0; i < fragmentArray.length; i++) {
            // 为每一个Tab按钮设置图标、文字和内容
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(mTextViewArray[i]).setIndicator(getTabItemView(i));
            mTabHost.addTab(tabSpec, fragmentArray[i], null);
            mTabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.selector_tab_item_bg);
        }
        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tag) {
                setTitle(tag);
            }
        });
        mTabHost.setCurrentTab(0);
        setTitle(mTextViewArray[0]);
    }


    private View getTabItemView(int index) {
        View view = LayoutInflater.from(this).inflate(R.layout.tab_item_view, null);

        ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
        imageView.setImageResource(mImageViewArray[index]);

        TextView textView = (TextView) view.findViewById(R.id.textview);
        textView.setText(mTextViewArray[index]);

        return view;
    }


//    @Override
//    public void onBackPressed() {
//        new AlertDialog(this)
//                .setTitle("Do you want to exit?")
//                .setNegativeButton("Cancel", new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                    }
//                })
//                .setPositiveButton("Exit", new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        finish();
//                    }
//                })
//                .show();
//    }
}